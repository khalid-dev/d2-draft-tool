<template>
    <div class="TopNav elevation-2">
        <button class="TopNav__hamburgerbutton" @click="handleMenuClick"><i class="material-icons TopNav__hamburger">menu</i></button>
    </div>
</template>

<script>
  export default {
    name: 'Nav',
    props: ['handleMenuClick'],
    data() {
      return {

      }
    },
    computed: {

    },
    mounted() {

    },
    methods: {
    }
  }
</script>

<style>
.TopNav {
    height: 56px;
    width: 100%;
    background-color: #567082;
    display: flex;
    align-items: center;
}
.TopNav__hamburgerbutton {
    border: none;
    background: none;
    -webkit-tap-highlight-color: transparent;
}
.TopNav__hamburgerbutton:focus {
    outline: none;
}
.TopNav__hamburger {
    margin-left: 2px;
    padding: 16px;
    color: white;
    cursor: pointer;
    user-select: none;
}
</style>