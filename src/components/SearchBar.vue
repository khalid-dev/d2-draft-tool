<template>
  <div :class="['SearchBar']">
    <input v-model="query" />
  </div>
</template>

<script>
  export default {
    name: 'SearchBar',
    props: ['handleSearchbarInput'],
    data() {
      return {
        query: '',
      }
    },
    computed: {},
    mounted() {},
    methods: {},
    watch: {
      query: function (newQuery, oldQuery) {
        this.handleSearchbarInput(newQuery, oldQuery)
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.SearchBar {
  font-size: 22px;
  color: rgba(255, 255, 255, 0.95);
}
</style>