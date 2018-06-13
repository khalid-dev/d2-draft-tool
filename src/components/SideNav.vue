<template>
    <div class="SideNav" ref="SideNav" :class="{ visible: isVisible }">
        <div class="SideNav__topbar" @click="toggleSideNav">d2-draft-tool</div>
        <ul class="SideNav__items">
            <li
                class="SideNav__item"
                v-for="item of navItems"
                :key="item.name"
                @click="() => handleItemClick(item.onClick)"
            >
                <i class="material-icons SideNav__itemicon">{{item.icon}}</i>
                {{item.title}}
            </li>
        </ul>
    </div>
</template>

<script>
  export default {
    name: 'SideNav',
    props: ['isVisible', 'navItems', 'toggleVisibility'],
    data() {
      return {

      }
    },
    computed: {

    },
    mounted() {

    },
    methods: {
        handleItemClick(itemOnClick) {
            itemOnClick();
            this.toggleSideNav();
        },
        clickOutsideSideNav(e) {
            var children = Array.prototype.slice.call(document.querySelectorAll('.SideNav *'));
            if(e.target !== this.$refs.SideNav && children.indexOf(e.target) === -1) {
                this.toggleSideNav();
            };
        },
        toggleSideNav() {
            !this.isVisible && window.removeEventListener('click', this.clickOutsideSideNav);
            this.toggleVisibility();
        }
    },
    watch: {
        isVisible() {
            if (!this.isVisible) window.removeEventListener('click', this.clickOutsideSideNav);
            else window.addEventListener('click', this.clickOutsideSideNav);
        }
    }
  }
</script>

<style>
.SideNav {
    position: absolute;
    left: 0;
    height: 100vh;
    width: 80%;
    max-width: 320px;
    background-color: #fff;
    transform: translateX(-110%);
    transition: transform 250ms ease;
    z-index: 26;
    box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 10px, rgba(0, 0, 0, 0.23) 0px 3px 10px;
}
.SideNav__topbar {
    height: 56px;
    width: 100%;
    background-color: #567082;
    display: flex;
    align-items: center;
    padding-left: 30px;
    font-size: 24px;
    font-weight: 300;
    color: rgba(255, 255, 255, 0.95);
    user-select: none;
    cursor: pointer;
}
.SideNav.visible {
    transform: inherit;
}
.SideNav button {
    background-color: unset;
    border: unset;
}
/* .SideNav button:focus {
    outline: none;
} */
.SideNav__items {
    padding-top: 15px;
}
.SideNav__item {
    color: rgba(0,0,0, 0.75);
    margin: 22px 14px;
    padding: 16px 16px;
    display: flex;
    align-items: center;
    user-select: none;
    cursor: pointer;
}
.SideNav__itemicon {
    color: rgba(0,0,0, 0.6);
    font-size: 28px;
    margin-right: 20px;
}
</style>