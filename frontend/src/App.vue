<template>
  <div id="app">
    <Nav />
   
  

    <router-view />
    <Footer/>

  </div>
</template>

<script>
import Nav from "@/components/Header/Nav.vue"
import Footer from "@/components/Footer.vue"
export default {
  name: "App",
  components:{
    Nav,
    Footer,
  },
}

</script>

<style lang="scss">
@import "./styles/common.scss";
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
body::-webkit-scrollbar {
  width: 7px;
}
// scrollbar 상태바
body::-webkit-scrollbar-thumb {
  background-color: $sub-color;
  border-radius: 10px;
  border: 1px solid $light-color;
}
// scrollbar 전체바
body::-webkit-scrollbar-track {
  background-color: $light-color;
  border-radius: 10px;
  margin: 10px;
}

/* #nav {
  padding: 30px;
} */

</style>
