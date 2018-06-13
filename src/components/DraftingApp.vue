<template>
  <div class="DraftingApp">
    <SearchBar :handleSearchbarInput="handleSearchbarInput" />
    <div class="left">
      <v-select
          :items="enemyTeamNames"
          editable
          label="Select Enemy Team"
          item-value="text"
          v-model="enemyTeamName"
      ></v-select>
      <v-btn-toggle v-model="pickOrderToggle" mandatory>
        <v-btn flat>
          1st PICK
        </v-btn>
        <v-btn flat>
          2nd PICK
        </v-btn>
      </v-btn-toggle>
      <MockDraft :handleDraftClick="handleDraftClick" :draft="draft" :currentPick="currentPick" />
      <div>
        <v-btn flat small @click="handleResetClick">RESET</v-btn>
      </div>
    </div>
    <v-data-table
      class="hero-data-table"
      :headers="headers"
      :items="filteredHeroData"
      hide-actions
      item-key="id"
    >

      <template slot="items" slot-scope="props">
        <tr @click="(e) => handleHeroClick(props.item)">
          <td>{{ props.item.name }}</td>
          <td class="text-xs-right">{{ props.item.teamFight }}</td>
          <td class="text-xs-right">{{ props.item.waveClear }}</td>
          <td class="text-xs-right">{{ props.item.catchCapability }}</td>
          <td class="text-xs-right">{{ props.item.towerPush }}</td>
          <td class="text-xs-right">{{ props.item.burstDamage }}</td>
          <td class="text-xs-right">{{ props.item.counterInitiate }}</td>
          <td class="text-xs-right">{{ props.item.disengage }}</td>
          <td class="text-xs-right">{{ props.item.lanePressure }}</td>
          <td class="text-xs-right">{{ props.item.roshTaking }}</td>
        </tr>
      </template>

    </v-data-table>
  </div>
</template>

<script>
  import MockDraft from './MockDraft.vue';
  import SearchBar from './SearchBar.vue';
  export default {
    name: 'DraftingApp',
    components: { MockDraft, SearchBar },
    props: ['heroData', 'replayData'],
    data() {
      return {
        currentPick: 1,
        draft: (new Array(23)).fill({}),
        headers: [
          {
            text: 'Name',
            align: 'left',
            value: 'name'
          },
          { text: 'Team Fight', value: 'teamFight'},
          { text: 'Wave Clear', value: 'waveClear'},
          { text: 'Catch', value: 'catchCapability'},
          { text: 'Push', value: 'towerPush'},
          { text: 'Burst', value: 'burstDamage'},
          { text: 'Counter', value: 'counterInitiate'},
          { text: 'Disengage', value: 'disengage'},
          { text: 'Lane Pressure', value: 'lanePressure'},
          { text: 'Rosh', value: 'roshTaking'},
        ],
        pickOrderToggle: 0, // 0 1st pick, 1 2nd pick
        enemyTeamName: "",
        filteredHeroData: this.heroData,
        query: '',
        potentialEnemyPicks: [],
      }
    },
    computed: {
      isEnemyFirstPick() {
        return Boolean(this.pickOrderToggle);
      },
      enemyTeamNames() {
        let teamNames = new Set();
        for (let i = 0; i<this.replayData.length; i++) {
          teamNames.add(this.replayData[i].direTeam);
          teamNames.add(this.replayData[i].radiantTeam);
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
      }
    },
    mounted() {
      
    },
    methods: {
      handleResetClick() {
        this.draft = (new Array(23)).fill({});
        this.potentialEnemyPicks = [];
        this.currentPick = 1;
      },
      handleHeroClick(hero) {
        this.draft.splice(this.currentPick, 1, hero);
        this.potentialEnemyPicks = this.generatePotentialEnemyPicks();
        if (this.currentPick < 22) this.currentPick++;
        this.filteredHeroData = this.getFilteredHeroData();
      },
      handleDraftClick(e, pickNumber) {
        this.currentPick = pickNumber;
        this.draft.splice(this.currentPick, 1, {});
        this.potentialEnemyPicks = this.generatePotentialEnemyPicks();
      },
      handleSearchbarInput(newQuery, oldQuery) {
        this.query = newQuery;
        this.filteredHeroData = this.getFilteredHeroData();
      },
      getHeroForId(id) {
        return this.heroData[id];
      },
      generateEnemyTeamNames() {
        let teamNames = new Set();
        for (let i = 0; i<this.replayData.length; i++) {
          teamNames.add(this.replayData[i].direTeam);
          teamNames.add(this.replayData[i].radiantTeam);
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
      generatePotentialEnemyPicks() {
        let draft = this.draft;
        let replayData = this.replayData;
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
          if (hero.role) {
            let isSingleRoleHero = hero.role.length === 1;
            return isSingleRoleHero;
          }
        })
        var rolesFilled = singleRoleEnemyHeroes.map(hero => hero.role);
        //need to have different roles for 4/5 supports in the json.
        potentialEnemyPicks = potentialEnemyPicks.filter(hero => {
          let isAvailableToDraft = this.draft.indexOf(hero) === -1;
          let isFilledRole = (rolesFilled.includes(hero.role)); 
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
      },
      getFilteredHeroData() {
        let matchingQueryTerms = [];
        for (let header of this.headers) {
          let keyword = header.text.toLowerCase();
          let indexOfKeyword = this.query.indexOf(keyword + ' > ');
          if (indexOfKeyword !== -1) {
            let value = this.query[indexOfKeyword + keyword.length + 3];
            if (value) {
              matchingQueryTerms.push({
                header: header,
                value: value
              });
            }
          }
        }
        if (matchingQueryTerms.length) console.log(matchingQueryTerms);

        return this.heroData.filter(hero => {
          let meetsQueryCriteria = true;
          for (let term of matchingQueryTerms) {
            if (hero[term.header.value] > term.value) {
              meetsQueryCriteria = true;
            } else {
              meetsQueryCriteria = false;
            }
          }

          let isAlreadyDraftedOrBanned = this.draft.indexOf(hero) === -1;
          return isAlreadyDraftedOrBanned && meetsQueryCriteria;
        });
      }
    }
  }
</script>

<style>
.DraftingApp {
  width: 100%;
  display: flex;
  /* justify-content: center; */
  overflow: auto;
}
.DraftingApp td {
  user-select: none;
}
.DraftingApp tr {
  cursor: pointer;
}
.DraftingApp .left {
  width: 400px;
}
</style>