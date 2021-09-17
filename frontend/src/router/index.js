// import Router from "vue-router";
// import Vue from "vue";

import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
// Recommend 메뉴
import RecAll from "../views/Recommend/RecAll.vue";
import RecPerfume from "../views/Recommend/RecPerfume.vue";
import RecSoftener from "../views/Recommend/RecSoftener.vue";
import RecDetail from "../views/Recommend/RecDetail.vue";

import MyTestMain from "../views/Recommend/ForTest/MyTestMain.vue";
import DearTestMain from "../views/Recommend/ForTest/DearTestMain.vue";
import TestQnA from "../views/Recommend/ForTest/TestQnA.vue";
import TestResult from "../views/Recommend/ForTest/TestResult.vue";
// Community 메뉴
import Notice from "../views/Community/Notice.vue"
import QnA from "../views/Community/QnA.vue"
import BoardWrite from "@/components/Board/WriteForm.vue"
import BoardRead from "@/components/Board/BoardReadForm.vue"
// Mypage 메뉴
import Mypage from "../views/Mypage/Mypage.vue"
import HaveList from "../views/Mypage/HaveList.vue"
import WantList from "../views/Mypage/WantList.vue"
// 에러 페이지
import Page404 from "../views/404.vue"

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    component: () =>
      import("../views/About.vue"),
  },
  {
    path: "/recommend",
    component: RecAll,
    children: [
      {
        path: 'perfume',
        name: 'Perfume',
        component: RecPerfume,
      },
      {
        path: 'softener',
        name: 'Softener',
        component: RecSoftener,
      },
      {
        path: 'detail/:id',
        name: 'RecDetail',
        component: RecDetail,
      },
      {
        path: 'mytest',
        name: 'MyTest',
        component: MyTestMain,
      },
      {
        path: 'deartest',
        name: 'DearTest',
        component: DearTestMain,
      },
      {
        path: 'testQnA',
        name: 'TestQnA',
        component: TestQnA,
      },
      {
        path: 'testResult',
        name: 'TestResult',
        component: TestResult,
      },
    ]
  },
  {
    path: '/notice',
    name: 'Notice',
    component: Notice,
    children: [
      {
        // 공지사항 게시글 하나 읽기
        path: ':id',
        name: 'NoticeRead',
        component: BoardRead,
      },
      {
        // 공지사항 글쓰기
        path: 'write',
        name: 'NoticeWrite',
        component: BoardWrite,
      },
      {
        // 공지사항 글 수정
        path: 'modify/:id',
        name: 'NoticeModify',
        component: BoardWrite,
      },
    ],
  },
  {
    path: '/qna',
    name: 'Qna',
    component: QnA,
    children: [
      {
        // 문의하기 게시글 하나 읽기
        path: ':id',
        name: 'QnaRead',
        component: BoardRead,
      },
      {
        // 문의하기 글쓰기
        path: 'write',
        name: 'QnaWrite',
        component: BoardWrite,
      },
      {
        // 문의하기 글 수정
        path: 'modify/:id',
        name: 'QnaModify',
        component: BoardWrite,
      },
      {
        // 문의하기 답글 수정
        path: 'modify/answer/:id',
        name: 'QnaAnsModify',
        component: BoardWrite,
      },
    ],
  },
  {
    path: '/mypage',
    name: 'MyPage',
    component: Mypage,
    children: [
      {
        path: 'havelist',
        name: 'HaveList',
        component: HaveList,
      },
      {
        path: 'wantlist',
        name: 'WantList',
        component: WantList,
      },
    ],
  },
  {
    path: '/404',
    name: 'Page404',
    component: Page404,
  },
  {
    path: '/:catchAll(.*)', // vue3 사용자 정의 정규표현식 매개변수 사용
    redirect: '/404'
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
