<template>
  <div class="MockDraft">
    <div class="MockDraft__team MockDraft__radiant">
      <Hero class="ban ban1" :class="[currentPick === 1 ? 'MockDraft__Hero_selected' : '']" :id="draft[1].heroID" :click="(e) => handleDraftClick(e, 1)"/>
      <Hero class="ban ban2" :class="[currentPick === 3 ? 'MockDraft__Hero_selected' : '']" :id="draft[3].heroID" :click="(e) => handleDraftClick(e, 3)"/>
      <Hero class="ban ban3" :class="[currentPick === 5 ? 'MockDraft__Hero_selected' : '']" :id="draft[5].heroID" :click="(e) => handleDraftClick(e, 5)"/>
      <Hero class="pick pick1" :class="[currentPick === 7 ? 'MockDraft__Hero_selected' : '']" :id="draft[7].heroID" :click="(e) => handleDraftClick(e, 7)"/>
      <Hero class="pick pick2" :class="[currentPick === 10 ? 'MockDraft__Hero_selected' : '']" :id="draft[10].heroID" :click="(e) => handleDraftClick(e, 10)"/>
      <Hero class="ban ban4" :class="[currentPick === 11 ? 'MockDraft__Hero_selected' : '']" :id="draft[11].heroID" :click="(e) => handleDraftClick(e, 11)"/>
      <Hero class="ban ban5" :class="[currentPick === 13 ? 'MockDraft__Hero_selected' : '']" :id="draft[13].heroID" :click="(e) => handleDraftClick(e, 13)"/>
      <Hero class="pick pick3" :class="[currentPick === 15 ? 'MockDraft__Hero_selected' : '']" :id="draft[15].heroID" :click="(e) => handleDraftClick(e, 15)"/>
      <Hero class="pick pick4" :class="[currentPick === 17 ? 'MockDraft__Hero_selected' : '']" :id="draft[17].heroID" :click="(e) => handleDraftClick(e, 17)"/>
      <Hero class="ban ban6" :class="[currentPick === 19 ? 'MockDraft__Hero_selected' : '']" :id="draft[19].heroID" :click="(e) => handleDraftClick(e, 19)"/>
      <Hero class="pick pick5" :class="[currentPick === 21 ? 'MockDraft__Hero_selected' : '']" :id="draft[21].heroID" :click="(e) => handleDraftClick(e, 21)"/>
    </div>
    <div class ="MockDraft__ban-numbers">
      <div class="MockDraft__ban-num-1">1</div>
      <div class="MockDraft__ban-num-2">2</div>
      <div class="MockDraft__ban-num-3">3</div>
      <div class="MockDraft__ban-num-4">4</div>
      <div class="MockDraft__ban-num-5">5</div>
      <div class="MockDraft__ban-num-6">6</div>
      <div class="MockDraft__ban-num-7">7</div>
      <div class="MockDraft__ban-num-8">8</div>
      <div class="MockDraft__ban-num-9">9</div>
      <div class="MockDraft__ban-num-10">10</div>
      <div class="MockDraft__ban-num-11">11</div>
      <div class="MockDraft__ban-num-12">12</div>
      <div class="MockDraft__ban-num-13">13</div>
      <div class="MockDraft__ban-num-14">14</div>
      <div class="MockDraft__ban-num-15">15</div>
      <div class="MockDraft__ban-num-16">16</div>
      <div class="MockDraft__ban-num-17">17</div>
      <div class="MockDraft__ban-num-18">18</div>
      <div class="MockDraft__ban-num-19">19</div>
      <div class="MockDraft__ban-num-20">20</div>
      <div class="MockDraft__ban-num-21">21</div>
      <div class="MockDraft__ban-num-22">22</div>
    </div>
    <div class="MockDraft__team MockDraft__dire">
      <Hero class="ban ban1" :class="[currentPick === 2 ? 'MockDraft__Hero_selected' : '']" :id="draft[2].heroID" :click="(e) => handleDraftClick(e, 2)"/>
      <Hero class="ban ban2 " :class="[currentPick === 4 ? 'MockDraft__Hero_selected' : '']" :id="draft[4].heroID" :click="(e) => handleDraftClick(e,4)"/>
      <Hero class="ban ban3" :class="[currentPick === 6 ? 'MockDraft__Hero_selected' : '']" :id="draft[6].heroID" :click="(e) => handleDraftClick(e, 6)"/>
      <Hero class="pick pick1" :class="[currentPick === 8 ? 'MockDraft__Hero_selected' : '']" :id="draft[8].heroID" :click="(e) => handleDraftClick(e, 8)"/>
      <Hero class="pick pick2" :class="[currentPick === 9 ? 'MockDraft__Hero_selected' : '']" :id="draft[9].heroID" :click="(e) => handleDraftClick(e, 9)"/>
      <Hero class="ban ban4" :class="[currentPick === 12 ? 'MockDraft__Hero_selected' : '']" :id="draft[12].heroID" :click="(e) => handleDraftClick(e, 12)"/>
      <Hero class="ban ban5" :class="[currentPick === 14 ? 'MockDraft__Hero_selected' : '']" :id="draft[14].heroID" :click="(e) => handleDraftClick(e, 14)"/>
      <Hero class="pick pick3" :class="[currentPick === 16 ? 'MockDraft__Hero_selected' : '']" :id="draft[16].heroID" :click="(e) => handleDraftClick(e, 16)"/>
      <Hero class="pick pick4" :class="[currentPick === 18 ? 'MockDraft__Hero_selected' : '']" :id="draft[18].heroID" :click="(e) => handleDraftClick(e, 18)"/>
      <Hero class="ban ban6" :class="[currentPick === 20 ? 'MockDraft__Hero_selected' : '']" :id="draft[20].heroID" :click="(e) => handleDraftClick(e, 20)"/>
      <Hero class="pick pick5" :class="[currentPick === 22 ? 'MockDraft__Hero_selected' : '']" :id="draft[22].heroID" :click="(e) => handleDraftClick(e, 22)"/>
    </div>
  </div>
</template>

<script>
  import Hero from './Hero.vue';
  export default {
    name: 'MockDraft',
    components: {Hero},
    props: ['handleDraftClick', 'draft', 'currentPick'],
    data() {
      return {}
    },
    computed: {

    },
    mounted() {

    },
    methods: {}
  }
</script>

<style>
.MockDraft {
  position: relative;
  display: flex;
  width: 300px;
  user-select: none;
}
.MockDraft .ban {
  flex: 1 2 auto;
  width: 60%;
  max-height: 30px;
  width: 54px;
}
.MockDraft__team {
  width: 100%;
  display: flex;
  flex-flow: column;
}
.MockDraft__dire {
  margin-left: 27px;
}
.MockDraft__radiant {
  margin-right: 27px; 
  align-items: flex-end;
}
.MockDraft .pick {
  flex: 2 1 auto;
  width: 100%;
  max-height: 50px;
  width: 93px;
}
.MockDraft .Hero {
  margin: 1px 0;
  margin-top: 10px;
  cursor: pointer;
}
.MockDraft .imgcontainer {
  border-radius: 6px;
  box-shadow: 0 0 0 2pt rgba(75, 75, 75, 1);
  /* z-index: 9; */
  background-color: rgba(0, 0, 0, 0.7);
  border: unset;
}
.MockDraft img {
  opacity: 1!important;
}
.MockDraft .positionline {
  width: 18px;
  height: 1px;
  position: absolute;
  top: 50%;
  right: -20px;
  box-shadow: 0 0 1px 1px rgba(75, 75, 75, 1);
  background-color: rgba(75, 75, 75, 1);
  /* z-index: 1; */
}
.MockDraft__Hero_selected .imgcontainer  {
  box-shadow: 0 0 0 2pt rgba(255, 100, 100, 1);
}
.MockDraft__Hero_selected .positionline {
  box-shadow: 0 0 1px 1px rgba(255, 100, 100, 1);
  background-color: rgba(255, 100, 100, 1);
}
.MockDraft__dire .positionline {
  left: -20px;
}
.MockDraft__radiant .ban1 .positionline {
  top: 30%;
}
.MockDraft__dire .ban1 .positionline {
  top: 70%;
}
.MockDraft__radiant .ban2 .positionline {
  top: 30%;
}
.MockDraft__dire .ban2 .positionline {
  top: 70%;
}
.MockDraft__radiant .ban3 .positionline {
  top: 30%;
}
.MockDraft__dire .ban3 .positionline {
  top: 70%;
}
.MockDraft__radiant .pick1 .positionline {
  top: 30%;
}
.MockDraft__dire .pick1 .positionline {
  top: 70%;
}
.MockDraft__dire .pick2 .positionline {
  top: 30%;
}
.MockDraft__radiant .pick2 .positionline {
  top: 70%;
}
.MockDraft__radiant .ban4 .positionline {
  top: 30%;
}
.MockDraft__dire .ban4 .positionline {
  top: 70%;
}
.MockDraft__radiant .ban5 .positionline {
  top: 30%;
}
.MockDraft__dire .ban5 .positionline {
  top: 70%;
}
.MockDraft__radiant .pick3 .positionline {
  top: 30%;
}
.MockDraft__dire .pick3 .positionline {
  top: 70%;
}
.MockDraft__radiant .pick4 .positionline {
  top: 30%;
}
.MockDraft__dire .pick4 .positionline {
  top: 70%;
}
.MockDraft__radiant .ban6 .positionline {
  top: 30%;
}
.MockDraft__dire .ban6 .positionline {
  top: 70%;
}
.MockDraft__radiant .pick5 .positionline {
  top: 30%;
}
.MockDraft__dire .pick5 .positionline {
  top: 70%;
}
.MockDraft__ban-numbers {
  margin-top: 5px;
  text-align: center;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  font-size: 13px;
  font-weight: 700;
  color: rgba(75, 75, 75, 1);
  display: flex;
  flex-flow: column;
}
.MockDraft__ban-numbers * {
  text-shadow: 0 1px 1px rgba(0, 0, 0, 0.8);
}
.MockDraft__ban-num-2 {
  margin-top: -5px;
}
.MockDraft__ban-num-3 {
  margin-top: 4px;
}
.MockDraft__ban-num-4 {
  margin-top: -4px;
}
.MockDraft__ban-num-5 {
  margin-top: 2px;
}
.MockDraft__ban-num-6 {
  margin-top: -4px;
}
.MockDraft__ban-num-7 {
  margin-top: 7px;
}
.MockDraft__ban-num-8 {
  margin-top: 1px;
}
.MockDraft__ban-num-9 {
  margin-top: 16px;
}
.MockDraft__ban-num-10 {
  margin-top: 0px;
}
.MockDraft__ban-num-11 {
  margin-top: 12px;
}
.MockDraft__ban-num-12 {
  margin-top: -4px;
}
.MockDraft__ban-num-13 {
  margin-top: 4px;
}
.MockDraft__ban-num-14 {
  margin-top: -4px;
}
.MockDraft__ban-num-15 {
  margin-top: 8px;
}
.MockDraft__ban-num-16 {
  margin-top: 1px;
}
.MockDraft__ban-num-17 {
  margin-top: 21px;
}
.MockDraft__ban-num-18 {
  margin-top: 2px;
}
.MockDraft__ban-num-19 {
  margin-top: 15px;
}
.MockDraft__ban-num-20 {
  margin-top: -4px;
}
.MockDraft__ban-num-21 {
  margin-top: 13px;
}
.MockDraft__ban-num-22 {
  margin-top: 2px;
}
</style>