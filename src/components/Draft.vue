<template>
  <div class="Draft">
    <div class="Draft__team Draft__radiant">
      <Hero class="Draft__ban Draft__ban1" :id="radiant.bans[0]" />
      <Hero class="Draft__ban Draft__ban2" :id="radiant.bans[1]" />
      <Hero class="Draft__ban Draft__ban3" :id="radiant.bans[2]" />
      <Hero class="pick pick1" :id="radiant.picks[0]" />
      <Hero class="pick pick2" :id="radiant.picks[1]" />
      <Hero class="Draft__ban Draft__ban4" :id="radiant.bans[3]" />
      <Hero class="Draft__ban Draft__ban5" :id="radiant.bans[4]" />
      <Hero class="pick pick3" :id="radiant.picks[2]" />
      <Hero class="pick pick4" :id="radiant.picks[3]" />
      <Hero class="Draft__ban Draft__ban6" :id="radiant.bans[5]" />
      <Hero class="pick pick5" :id="radiant.picks[4]" />
    </div>
    <div class="Draft__team dire">
      <Hero class="Draft__ban Draft__ban1" :id="dire.bans[0]" />
      <Hero class="Draft__ban Draft__ban2 " :id="dire.bans[1]" />
      <Hero class="Draft__ban Draft__ban3" :id="dire.bans[2]" />
      <Hero class="pick pick1" :id="dire.picks[0]" />
      <Hero class="pick pick2" :id="dire.picks[1]" />
      <Hero class="Draft__ban Draft__ban4" :id="dire.bans[3]" />
      <Hero class="Draft__ban Draft__ban5" :id="dire.bans[4]" />
      <Hero class="pick pick3" :id="dire.picks[2]" />
      <Hero class="pick pick4" :id="dire.picks[3]" />
      <Hero class="Draft__ban Draft__ban6" :id="dire.bans[5]" />
      <Hero class="pick pick5" :id="dire.picks[4]" />
    </div>
  </div>
</template>

<script>
  import Hero from './Hero.vue';
  export default {
    name: 'Draft',
    components: {Hero},
    props: ['replay', 'vertical'],
    data() {
      return {

      }
    },
    computed: {
      radiant() {
        if(this.replay) return {
          name: this.replay.radiantTeam,
          isFirstPick: this.replay.teamFP === 'Radiant',
          isWinner: this.replay.winningTeamSide === 'Radiant',
          picks: this.replay.radiantPicks ? this.replay.radiantPicks : [],
          bans: this.replay.radiantBans ? this.replay.radiantBans : []
        }; 
        else return { 
          bans: [1,1,1,1,1,1],
          picks: [1,1,1,1,1]
        }
      },
      dire() {
        if(this.replay) return {
          name: this.replay.direTeam,
          isFirstPick: this.replay.teamFP === 'Dire',
          isWinner: this.replay.winningTeamSide === 'Dire',
          picks: this.replay.direPicks ? this.replay.direPicks : [],
          bans: this.replay.direBans ? this.replay.direBans : []
        };
        else return { 
          bans: [1,1,1,1,1,1],
          picks: [1,1,1,1,1]
        }
      }
    },
    mounted() {

    },
    methods: {}
  }
</script>

<style>
.Draft {
  position: relative;
}
.Draft__ban {
  flex: 1 2 auto;
  height: 6vw;
  max-height: 30px;
  max-width: 54px;
}
.Draft__team {
  width: 100%;
  display: flex;
  justify-content: center;
}
.Draft__radiant {
  margin-bottom: 10px;
}
.Draft__radiant .Draft__ban {
  align-self: flex-end;
}
.pick {
  flex: 2 1 auto;
  height: 10vw;
  max-width: 93px;
  max-height: 50px;
  max-width: 93px;
}
.Draft .positionline {
  width: 3px;
  height: 7px;
  position: absolute;
  left: 50%;
  bottom: -7px;
  background-color: rgba(0,0,0,0.6);
}
.Draft .Hero {
  margin: 0 1px;
}
.dire .positionline {
  top: -7px;
}
.Draft__radiant .Draft__ban1 .positionline {
  left: 30%;
}
.dire .Draft__ban1 .positionline {
  left: 70%;
}
.Draft__radiant .Draft__ban2 .positionline {
  left: 30%;
}
.dire .Draft__ban2 .positionline {
  left: 70%;
}
.Draft__radiant .Draft__ban3 .positionline {
  left: 30%;
}
.dire .Draft__ban3 .positionline {
  left: 70%;
}
.Draft__radiant .pick1 .positionline {
  left: 30%;
}
.dire .pick1 .positionline {
  left: 70%;
}
.dire .pick2 .positionline {
  left: 30%;
}
.Draft__radiant .pick2 .positionline {
  left: 70%;
}
.Draft__radiant .Draft__ban4 .positionline {
  left: 30%;
}
.dire .Draft__ban4 .positionline {
  left: 70%;
}
.Draft__radiant .Draft__ban5 .positionline {
  left: 30%;
}
.dire .Draft__ban5 .positionline {
  left: 70%;
}
.Draft__radiant .pick3 .positionline {
  left: 30%;
}
.dire .pick3 .positionline {
  left: 70%;
}
.Draft__radiant .pick4 .positionline {
  left: 30%;
}
.dire .pick4 .positionline {
  left: 70%;
}
.Draft__radiant .Draft__ban6 .positionline {
  left: 30%;
}
.dire .Draft__ban6 .positionline {
  left: 70%;
}
.Draft__radiant .pick5 .positionline {
  left: 30%;
}
.dire .pick5 .positionline {
  left: 70%;
}
</style>