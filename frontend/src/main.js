import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import './styles/common.scss'

import infiniteScroll from "vue-infinite-scroll";
// Vue.use(infiniteScroll);
// import Vue from 'vue';
import VueWordCloud from 'vuewordcloud';

createApp(VueWordCloud.name, VueWordCloud);

createApp(App).use(store).use(router).mount("#app");
