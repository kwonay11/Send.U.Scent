<template>
  <div id="nav">
    <Nav />
  </div>
  <router-view />
</template>

<script>
import Nav from "@/components/Header/Nav.vue"
export default {
  name: "App",
  components:{
    Nav,
  },
}

</script>

<style lang="scss">

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

/* #nav {
  padding: 30px;
} */

</style>
