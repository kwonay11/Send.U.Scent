import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import './styles/common.scss'

import infiniteScroll from "vue-infinite-scroll";
// Vue.use(infiniteScroll);

createApp(App).use(store).use(router).mount("#app");
