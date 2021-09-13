// import Router from "vue-router";
// import Vue from "vue";

import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

// Routes
// import paths from "./paths";
// function route(path, view, name) {
//   return {
//     name: name || view,
//     path,
//     component:
//       resolve =>
//         import(`@/views/${view}.vue`)
//           .then(resolve)
//   };
// }

// Vue.use(Router);

// const router = new Router({
//   mode: "history",
//   base: process.env.BASE_URL,
//   routes: paths
//     .map(path => route(path.path, path.view, path.name))
//     .concat([{ path: "*", redirect: "/" }]),
//     scrollBehavior(to, from, savedPosition) {
//     if (savedPosition) {
//       return savedPosition;
//     }
//     if (to.hash) {
//       return { selector: to.hash };
//     }
//     return { x: 0, y: 0 };
//   }
// });

export default router;
