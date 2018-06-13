<template>
  <div class="ReplaysApp">
    <!-- <div class="topcontainer">
      <button class="statebutton" @click="() => changeAppState('DraftingApp')">⥻</button>
      <div class="searchcontainer">
        <input class="autocomplete" v-model="autocompleteText" >
        <input class="search" ref="search" type="text" v-model="searchText" @keyup="handleSearchKeyup">
      </div>
    </div> -->
    <ReplaysAppTable :replays="replays" />
  </div>
</template>

<script>
import ReplaysAppTable from './ReplaysAppTable.vue';
export default {
  name: 'ReplaysApp',
  components: {ReplaysAppTable},
  props: ['changeAppState', 'replays'],
  data () {
    return {
      heroesLoaded: false,
      searchText: '',
      autocompleteText: '',
      heroNames: []
    }
  },
  methods: {
    handleSearchKeyup(e) {
      return false; // disabled
      if(e.key === 'Enter' && this.autocompleteText !== '') {
        this.searchText = this.autocompleteText;
      } else {
        for(const heroName of this.heroNames) {
          if(heroName.indexOf(this.searchText) === 0) {
            this.autocompleteText = heroName;
            return;
          } else {
            this.autocompleteText = '';
          }
        }
      }
    }
  },
  mounted() {
    var autocompleteTokens = [

    ]
  }
};
</script>

<style>
.ReplaysApp {
  width: 100%;
  max-width: 850px;
  height: 100%;
  font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
  display: flex;
  align-items: center;
  flex-flow: column;
}
.ReplaysAppTable {
  margin-top: 10px;
  width: 100%;
}
.topcontainer {
  width: 100%;
  display: flex;
  justify-content: space-between;
}
.statebutton {
  width: 5%;
  height: 36px;
  align-self: flex-end;
  background-color: #679df6;
  box-shadow: 1px 1px 5px 2px rgba(0,0,0,0.15);
  color: white;
  border: none;
  border-radius: 3px;
}
.searchcontainer {
  position: relative;
  height: 50px;
  width: 94%;
}
.search, .autocomplete {
  position: absolute;
  width: 100%;
  top: 0;
  bottom: 0;
  background-color: white;
  box-shadow: 1px 1px 5px 2px rgba(0,0,0,0.07);
  margin-top: 14px;
  outline: none;
  border: none;
  font-size: 12px;
  padding: 10px 10px;
  color: rgba(0, 0, 0, 0.7);
  border-radius: 3px;
}
.autocomplete {
  background-color: unset;
  pointer-events: none;
  z-index: 2;
  color: rgba(0, 0, 0, 0.3);
}
.Draft {
  width: 100%;
  display: flex;
  flex-flow: column;
  padding: 15px 10px;
  /* margin: 7px 0;
  border-radius: 3px;
  background-color: white;
  padding: 10px 5px;
  box-shadow: 1px 1px 5px 2px rgba(0,0,0,0.15); */
}
.Draft::after {
  position: absolute;
  bottom: 0;
  right: 0;
  width: 100%;
  height: 1px;
  background-color: rgba(0,0,0, 0.1);
  content: '';
}
.ReplaysApp .Hero .imgcontainer {
  border: 1px solid rgba(0, 0, 0, 0.3);
}
</style>
