<template>
  <v-app id="inspire" class="DraftingApp">

    <!-- Right Navigation Drawer -->
    <v-navigation-drawer
      v-model="drawerRight"
      right
      app
      
      
    >
      <v-flex class="DraftingApp__right-nav">

        <v-toolbar color="blue-grey lighten-2" dark>
          <v-toolbar-title>Current Draft</v-toolbar-title>
        </v-toolbar>
        <v-select
          class="DraftingApp__team-select-dropdown"
          :items="enemyTeamNames"
          editable
          label="Select Enemy Team"
          item-value="text"
          v-model="enemyTeamName"
        ></v-select>
        <v-btn-toggle v-model="pickOrderToggle" mandatory>
          <v-btn flat>
            first pick
          </v-btn>
          <v-btn flat>
            second pick
          </v-btn>
        </v-btn-toggle>
        <MockDraft :handleDraftClick="handleDraftClick" :draft="draft" :currentPick="currentPick" />
        <v-btn class="DraftingApp__reset-button" flat small @click="handleResetClick">RESET</v-btn>

      </v-flex>

    </v-navigation-drawer>
    <!-- End Right Navigation Drawer -->

    <!-- Toolbar -->
    <v-toolbar
      color="blue-grey"
      dark
      fixed
      app
    >
      <v-btn icon @click.stop="drawer = !drawer">
        <v-icon>{{drawer ? 'keyboard_arrow_left' : 'keyboard_arrow_right'}}</v-icon>
      </v-btn>
      <v-toolbar-title>d2-draft-tool</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-text-field
          name="searchbar"
          class="DraftingApp__searchbar"
          append-icon="search"
          single-line
          v-model="query"
          color="white"
          label="teamfight>2 waveclear>1"
      ></v-text-field>
      <v-btn icon @click.stop="drawerRight = !drawerRight">
        <v-icon>{{drawerRight ? 'keyboard_arrow_right' : 'keyboard_arrow_left'}}</v-icon>
      </v-btn>
    </v-toolbar>
    <!-- Toolbar End -->    

    <!-- Left Navigation Drawer -->
    <v-navigation-drawer
      v-model="drawer"
      fixed
      app
      class="DraftingApp__left-nav"
    >
      <v-toolbar color="blue-grey lighten-2" dark>
        <v-toolbar-title>Team Composition</v-toolbar-title>
      </v-toolbar>
      <v-data-table
        class="draft-hero-attributes"
        hide-headers
        hide-actions
        :items="teamCompositionItems"
        :headers="teamCompositionHeaders"
      >
        <template slot="items" slot-scope="props">
        <tr>
          <td>{{ props.item.name }}</td>
          <td class="text-xs-right">{{ props.item.firstPick }}</td>
          <td class="text-xs-right">{{ props.item.secondPick }}</td>
        </tr>
      </template>
      </v-data-table>

      <v-toolbar color="blue-grey lighten-2" dark>
        <v-toolbar-title>Potential Enemy Picks</v-toolbar-title>
      </v-toolbar>
      <v-list class="DraftingApp__potential-picks">
        <v-list-tile v-for="item in potentialEnemyPicks" :key="item.heroObject.name" >
          <v-list-tile-content>
            <v-list-tile-title v-text="item.heroObject.name + ' (' + item.percentage.toFixed(1) + ')'"></v-list-tile-title>
          </v-list-tile-content>
          <v-list-tile-avatar>
            <div class="DraftingApp__potential-picks-image-container">
              <img class="DraftingApp__potential-picks-image" :src="getHeroImagePath(item.heroObject)">
            </div>
          </v-list-tile-avatar>
        </v-list-tile>
      </v-list>
        
    </v-navigation-drawer>
    <!-- End Navigation Drawer -->

    <!-- Main Content -->
    <v-content>
      <v-container fluid fill-height>
        <v-layout>

            <!-- Hero Data Table -->
            <v-data-table
              class="DraftingApp__hero-data-table"
              :headers="heroHeaders"
              :items="filteredHeroes"
              hide-actions
              must-sort
              item-key="id"
            >

              <template slot="items" slot-scope="props">
                <tr @click="(e) => handleHeroClick(props.item)" class="DraftingApp__hero-data-table-row">
                  <td class="DraftingApp__hero-table-icon-cell">
                    <div class="DraftingApp__hero-table-icon-container">
                      <img class="DraftingApp__hero-table-icon" :src="getHeroImagePath(props.item)">
                    </div>
                    {{ props.item.name }}
                  </td>
                  <td class="text-xs-right">{{ props.item.teamFight }}</td>
                  <td class="text-xs-right">{{ props.item.waveClear }}</td>
                  <td class="text-xs-right">{{ props.item.catchCapability }}</td>
                  <td class="text-xs-right">{{ props.item.towerPush }}</td>
                  <td class="text-xs-right">{{ props.item.burstDamage }}</td>
                  <td class="text-xs-right">{{ props.item.counterInitiate }}</td>
                  <td class="text-xs-right">{{ props.item.disengage }}</td>
                  <td class="text-xs-right">{{ props.item.lanePressure }}</td>
                  <td class="text-xs-right">{{ props.item.roshTaking }}</td>
                  <td class="text-xs-right">{{ props.item.splitPush }}</td>
                </tr>
              </template>

            </v-data-table>

        </v-layout>
      </v-container>
    </v-content>
    <!-- End Main Content -->

  </v-app>
</template>

<script>
  import replays from './assets/replays.json';
  import heroes from './assets/heroes.json';
  import MockDraft from './components/MockDraft.vue';
  import SearchBar from './components/SearchBar.vue';

  export default {
    components: { MockDraft, SearchBar },
    data: () => ({
      drawer: true,
      drawerRight: true,
      replays: replays,
      heroes: heroes,
      
      currentPick: 1,
      draft: (new Array(23)).fill({}),
      heroHeaders: [
        {
          text: 'Name',
          align: 'left',
          value: 'name'
        },
        { text: 'Team Fight', value: 'teamFight'},
        { text: 'Wave Clear', value: 'waveClear'},
        { text: 'Catch', value: 'catchCapability'},
        { text: 'Tower Push', value: 'towerPush'},
        { text: 'Burst', value: 'burstDamage'},
        { text: 'Counter', value: 'counterInitiate'},
        { text: 'Disengage', value: 'disengage'},
        { text: 'Lane Pressure', value: 'lanePressure'},
        { text: 'Rosh', value: 'roshTaking'},
        { text: 'Split Push', value: 'splitPush'},
      ],
      pickOrderToggle: 0, // 0 = 1st pick, 1 = 2nd pick
      enemyTeamName: 'VP',
      query: '',
      teamCompositionHeaders: [
        {
          align: 'left',
          value: 'name'
        },
        { value: 'firstPick'},
        { value: 'secondPick'},
      ]
    }),
    props: {
      source: String
    },
    computed: {
      isEnemyFirstPick() {
        return Boolean(this.pickOrderToggle);
      },
      enemyTeamNames() {
        let teamNames = new Set();
        for (let i = 0; i<this.replays.length; i++) {
          teamNames.add(this.replays[i].direTeam);
          teamNames.add(this.replays[i].radiantTeam);
        }
        let nameComparator = (a, b) => {
          let nameA = a.toUpperCase();
          let nameB = b.toUpperCase();
          if (nameA<nameB)
            return -1;
          if (nameA>nameB)
            return 1;
          else
            return 0;
        };
        return [...teamNames].sort(nameComparator);
      },
      teamCompositionItems() {
        const firstPickLocations = [7, 10, 15, 17, 21];
        const secondPickLocations = [8, 9, 16, 18, 22];

        let teamCompositionItems = [];
        for (let attribute of this.heroHeaders.slice(1)) {

          teamCompositionItems.push({
            name: attribute.text,

            firstPick: firstPickLocations.reduce((total, draftIndex) => {
              const hero = this.draft[draftIndex];
              if (hero.name) total += hero[attribute.value];
              return total;
            }, 0),

            secondPick: secondPickLocations.reduce((total, draftIndex) => {
              const hero = this.draft[draftIndex];
              if (hero.name) total += hero[attribute.value];
              return total;
            }, 0)
            
          });
        }
        return teamCompositionItems;
      },
      filteredHeroes() {
        
        let queryTerms = this.query.split(' ').map(term => term.toLowerCase());
    
        // returns a new filtered array of hero objects
        return this.heroes.filter(hero => {
          
          // immediately filter out any hero that doesnt meet these conditions
          const isDraftedOrBanned = this.draft.indexOf(hero) !== -1;
          const heroExists = hero.name !== 'XHeroNoExist';
          if (isDraftedOrBanned || !heroExists) return false;

          // generate keywords to match against query
          let heroKeywords = [
            hero.name,
            ...hero.roles,
            `teamfight>${hero.teamFight-1}`,
            `waveclear>${hero.waveClear-1}`,
            `catch>${hero.catchCapability-1}`,
            //split push vs push, no splitpush in table
            `push>${hero.towerPush-1}`,
            `burst>${hero.burstDamage-1}`,
            //counter vs counter initiate
            `counter>${hero.counterInitiate-1}`,
            `disengage>${hero.disengage-1}`,
            //cant see rosh on table
            `rosh>${hero.roshTaking-1}`,
            `lanepressure>${hero.lanePressure-1}`,
            `lanepressure>${hero.splitPush-1}`
          ].map(x => x.toLowerCase());
 
          // returns true if all query terms are found in the heroKeywords array (using indexOf string search)
          const meetsQueryCriteria = queryTerms.every(term => {
            return heroKeywords.some(keyword => {
              return keyword.indexOf(term) !== -1
            })
          });

          return meetsQueryCriteria;
        });
      },
      potentialEnemyPicks() {
        let draft = this.draft;
        let replayData = this.replays;
        let enemyTeam = this.enemyTeamName;
        var enemyDraftPickLocations;
        var enemyHeroesSelected = [];
        if (this.isEnemyFirstPick) {
          enemyDraftPickLocations = [7, 10, 15, 17, 21];
        }
        else {
          enemyDraftPickLocations = [8, 9, 16, 18, 22];
        }
        for (let i of enemyDraftPickLocations) {
          enemyHeroesSelected.push(draft[i]);
        }
        var potentialEnemyPicks = [];
       //this loop generates more instances of a hero the more similar this draft is to a replay's draft (through overcounting)
        for (let i = 0; i<replayData.length; i++) {
          if (replayData[i].radiantTeam === enemyTeam) {
            for (let a = 0; a<enemyHeroesSelected.length; a++) {
              let radiantPicks = replayData[i].radiantPicks.map(heroIDString => this.getHeroForId(heroIDString));
              if (radiantPicks.includes(enemyHeroesSelected[a]))
                potentialEnemyPicks.push(...radiantPicks);
            }
          }
          else if (replayData[i].direTeam === enemyTeam) {
            for (let b = 0; b<enemyHeroesSelected.length; b++) {
              let direPicks = replayData[i].direPicks.map(heroIDString => this.getHeroForId(heroIDString));
              if (direPicks.includes(enemyHeroesSelected[b]))
                potentialEnemyPicks.push(...direPicks);
            }
          }
        }
        //remove all instances of draftedHeroes from potentialEnemyPicks
        //put additional filter conditions down below
        //isAlreadyFilledRole
        var singleRoleEnemyHeroes = enemyHeroesSelected.filter(hero => {
          if (hero.roles) {
            let isSingleRoleHero = hero.roles.length === 1;
            return isSingleRoleHero;
          }
        })
        var rolesFilled = singleRoleEnemyHeroes.map(hero => hero.roles);
        //need to have different roles for 4/5 supports in the json.
        potentialEnemyPicks = potentialEnemyPicks.filter(hero => {
          let isAvailableToDraft = this.draft.indexOf(hero) === -1;
          let isFilledRole = (rolesFilled.includes(hero.roles)); 
          return isAvailableToDraft && !isFilledRole;
        })
        potentialEnemyPicks.sort((heroA, heroB) => {
          if (heroA.heroID < heroB.heroID)
            return -1;
          if (heroA.heroID > heroB.heroID)
            return 1;
          else
            return 0;
        })
        var potentialEnemyPicksWithOccurrences = {};
        var totalOccurences = 0;
        for (let hero of potentialEnemyPicks) {
          if (!potentialEnemyPicksWithOccurrences[hero.name]) {
            potentialEnemyPicksWithOccurrences[hero.name] = {
              heroObject: hero,
              occurences: 1,
            }
          } 
          else {
            potentialEnemyPicksWithOccurrences[hero.name].occurences++;
          }
          totalOccurences++;
        }
        var output = [];
        for (let key in potentialEnemyPicksWithOccurrences) {
          output.push(potentialEnemyPicksWithOccurrences[key]);
        }
        output.sort((objA, objB) => {
          if (objA.occurences < objB.occurences)
            return 1;
          if (objA.occurences > objB.occurences)
            return -1;
          else
            return 0;
        })
        for (let item of output) {
          item.percentage = item.occurences/totalOccurences;
        }
        return output;
        //Sort potentialEnemyPicks by # hero instances (sorted descending, 0->length-1)
      //Trim array to 5 heroes
      }
    },
    methods: {
      handleResetClick() {
        this.draft = (new Array(23)).fill({});
        this.currentPick = 1;
        this.enemyTeamName = '';
      },
      handleHeroClick(hero) {
        this.draft.splice(this.currentPick, 1, hero);
        if (this.currentPick < 22) this.currentPick++;
      },
      handleDraftClick(e, pickNumber) {
        this.currentPick = pickNumber;
        this.draft.splice(this.currentPick, 1, {});
      },
      handleSearchbarInput(newQuery, oldQuery) {
        this.query = newQuery;
      },
      getHeroForId(id) {
        return this.heroes[id];
      },
      getHeroImagePath(hero) {

        if(!hero.name) return '';

        var filename = hero.name.split(' ').join('_').toLowerCase();
        if(hero.name === 'Anti-Mage') filename = 'antimage';
        if(hero.name === 'Centaur Warrunner') filename = 'centaur';
        if(hero.name === 'Clockwerk') filename = 'rattletrap';
        if(hero.name === 'Doom') filename = 'doom_bringer';
        if(hero.name === 'Io') filename = 'wisp';
        if(hero.name === 'Lifestealer') filename = 'life_stealer';
        if(hero.name === 'Magnus') filename = 'magnataur';
        if(hero.name === 'Nature\'s Prophet') filename = 'furion';
        if(hero.name === 'Necrophos') filename = 'necrolyte';
        if(hero.name === 'Outworld Devourer') filename = 'obsidian_destroyer';
        if(hero.name === 'Queen of Pain') filename = 'queenofpain';
        if(hero.name === 'Shadow Fiend') filename = 'nevermore';
        if(hero.name === 'Timbersaw') filename = 'shredder';
        if(hero.name === 'Treant Protector') filename = 'treant';
        if(hero.name === 'Underlord') filename = 'abyssal_underlord';
        if(hero.name === 'Vengeful Spirit') filename = 'vengefulspirit';
        if(hero.name === 'Windranger') filename = 'windrunner';
        if(hero.name === 'Wraith King') filename = 'skeleton_king';
        if(hero.name === 'Zeus') filename = 'zuus';
        if(hero.name === 'Lycanthrope') filename = 'lycan';
        
        return './static/landscapes/' + filename + '.png';
      }
    }
  }
</script>

<style>
.DraftingApp {
  width: 100%;
  display: flex;
  overflow: auto;
}
.DraftingApp td {
  user-select: none;
}
.DraftingApp__hero-data-table-row {
  cursor: pointer;
}
.DraftingApp__hero-data-table-row:active {
  filter: brightness(0.8);
}
.DraftingApp__hero-table-icon-cell {
  display: flex;
  align-items: center;
}
.DraftingApp__hero-table-icon-container {
  margin-right: 15px;
}
.DraftingApp__potential-picks-image-container, .DraftingApp__hero-table-icon-container {
  height: 35px!important;
  width: 35px!important;
  flex: none;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 100%;
}
.avatar .DraftingApp__potential-picks-image, .DraftingApp__hero-table-icon {
  height: 100%;
  width: auto;
  border-radius: unset;
  pointer-events: none;
}
.DraftingApp .Hero .imgcontainer {
  border: unset;
}
.DraftingApp__hero-data-table {
  width: 100%;
}
.DraftingApp .container.fluid.fill-height {
  padding: 0;
}
.DraftingApp__potential-picks {
  overflow: auto;
}
.DraftingApp__left-nav {
  overflow: hidden;
}
.DraftingApp__reset-button {
  margin-left: auto;
}
.DraftingApp__right-nav {
  display: flex;
  flex-flow: column;
  align-items: center;
  justify-content: flex-start;
}
.DraftingApp .MockDraft {
  margin-top: 20px;
}
.DraftingApp__searchbar {
  transform: translate(-13px, 14px);
}
.DraftingApp__hero-data-table .text-xs-right, .DraftingApp__hero-data-table .text-xs-left {
  text-align: right;
}
</style>