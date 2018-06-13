<template>
  <div class="Hero" @click="handleClick">
    <div class="positionline"></div>
    <div class="imgcontainer">
      <img :src="imagePath">
    </div>
  </div>
</template>

<script>
  import HERO_DATA from '../assets/heroes.json';
  export default {
    name: 'Hero',
    props: ['id', 'click'],
    data() {
      return {}
    },
    computed: {
      imagePath() {

        if(!this.id) return '';

        var heroData = HERO_DATA[this.id];
        var filename = heroData.name.split(' ').join('_').toLowerCase();
        if(heroData.name === 'Anti-Mage') filename = 'antimage';
        if(heroData.name === 'Centaur Warrunner') filename = 'centaur';
        if(heroData.name === 'Clockwerk') filename = 'rattletrap';
        if(heroData.name === 'Doom') filename = 'doom_bringer';
        if(heroData.name === 'Io') filename = 'wisp';
        if(heroData.name === 'Lifestealer') filename = 'life_stealer';
        if(heroData.name === 'Magnus') filename = 'magnataur';
        if(heroData.name === 'Nature\'s Prophet') filename = 'furion';
        if(heroData.name === 'Necrophos') filename = 'necrolyte';
        if(heroData.name === 'Outworld Devourer') filename = 'obsidian_destroyer';
        if(heroData.name === 'Queen of Pain') filename = 'queenofpain';
        if(heroData.name === 'Shadow Fiend') filename = 'nevermore';
        if(heroData.name === 'Timbersaw') filename = 'shredder';
        if(heroData.name === 'Treant Protector') filename = 'treant';
        if(heroData.name === 'Underlord') filename = 'abyssal_underlord';
        if(heroData.name === 'Vengeful Spirit') filename = 'vengefulspirit';
        if(heroData.name === 'Windranger') filename = 'windrunner';
        if(heroData.name === 'Wraith King') filename = 'skeleton_king';
        if(heroData.name === 'Zeus') filename = 'zuus';
        if(heroData.name === 'Lycanthrope') filename = 'lycan';
        
        return './static/landscapes/' + filename + '.png';
      }
    },
    mounted() {
      
    },
    methods: {
      handleClick(e) {
        if (this.click) this.click(e);
      }
    }
  }
</script>

<style>
.Hero {
  position: relative;
  background-color: rgba(0, 0, 0, 0.3);
}
.Hero .imgcontainer {
  border: 1px solid rgba(0, 0, 0, 0.6);
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
}
.Hero img {
  height: 120%;
  opacity: 0.7;
}
</style>