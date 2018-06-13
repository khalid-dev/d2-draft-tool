<template>
  <div class="ReplaysAppTable">
    <!-- <Row v-for="index of 1" :key="index" :replay="replays[0]"/> -->
    <Draft v-for="(replay, index) of replays" :key="index" :replay="replay"/>
  </div>
</template>

<script>
  import Draft from './Draft.vue';
  export default {
    name: 'ReplaysAppTable',
    components: {Draft},
    props: ['replays', 'heroData'],
    data() {
      return {}
    },
    computed: {},
    mounted() {
      
    },
    methods: {}
  }
</script>

<style>
</style>