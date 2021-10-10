import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
// Recommend 메뉴
import RecAll from "../views/Recommend/RecAll.vue";
import RecPerfume from "../views/Recommend/RecPerfume.vue";
import RecSoftener from "../views/Recommend/RecSoftener.vue";
import RecDetail from "../views/Recommend/RecDetail.vue";

import MyTestMain from "../views/Recommend/ForTest/MyTestMain.vue";
import DearTestMain from "../views/Recommend/ForTest/DearTestMain.vue";
import MyTestQnA from "../views/Recommend/ForTest/MyTestQnA.vue";
import DearTestQnA from "../views/Recommend/ForTest/DearTestQnA.vue";
import MyTestResult from "../views/Recommend/ForTest/MyTestResult.vue";
import DearTestResult from "../views/Recommend/ForTest/DearTestResult.vue";
// Community 메뉴
import Notice from "../views/Community/Notice.vue";
import QnA from "../views/Community/QnA.vue";
import BoardWrite from "@/components/Board/WriteForm.vue";
import BoardListView from "@/components/Board/BoardListView.vue";
import BoardRead from "@/components/Board/BoardReadForm.vue";
import ModifyForm from "@/components/Board/ModifyForm.vue";
// Mypage 메뉴
import Mypage from "../views/Mypage/Mypage.vue";
import MypageMain from "@/components/Mypage/MypageMain.vue";
import MyinfoModify from "@/components/Mypage/MyinfoModify.vue";
import MyinfoCancel from "@/components/Mypage/MyinfoCancel.vue";
import HaveList from "../views/Mypage/HaveList.vue";
import WantList from "../views/Mypage/WantList.vue";
import MyHaveAdd from "@/components/Mypage/MyHaveAdd.vue";
// 에러 페이지
import Page404 from "../views/404.vue";

// User 메뉴
import SignUp from "@/components/user/SignUpForm.vue";
import LogIn from "@/components/user/LoginForm.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    component: () => import("../views/About.vue"),
  },
  {
    path: "/recommend",
    component: RecAll,
    children: [
      {
        path: "perfume",
        name: "Perfume",
        component: RecPerfume,
      },
      {
        path: "softener",
        name: "Softener",
        component: RecSoftener,
      },
      {
        path: "detail/:id",
        name: "RecDetail",
        component: RecDetail,
      },
      {
        path: "mytest",
        name: "MyTest",
        component: MyTestMain,
      },
      {
        path: "deartest",
        name: "DearTest",
        component: DearTestMain,
      },
      {
        path: "mytestQnA",
        name: "MyTestQnA",
        component: MyTestQnA,
      },
      {
        path: "deartestQnA",
        name: "DearTestQnA",
        component: DearTestQnA,
      },
      {
        path: "mytestResult",
        name: "MyTestResult",
        component: MyTestResult,
      },
      {
        path: "deartestResult",
        name: "DearTestResult",
        component: DearTestResult,
      },
    ],
  },
  {
    path: "/notice",
    name: "Notice",
    component: Notice,
    children: [
      {
        // 공지사항 게시글 목록
        path: "",
        name: "BoardListView",
        component: BoardListView,
      },
      {
        // 공지사항 게시글 하나 읽기
        path: ":id",
        name: "NoticeRead",
        component: BoardRead,
      },
      {
        // 공지사항 글쓰기
        path: "write",
        name: "NoticeWrite",
        component: BoardWrite,
      },
      {
        // 공지사항 글 수정
        path: "modify/:id",
        name: "NoticeModify",
        component: ModifyForm,
      },
    ],
  },
  // {
  //   path: "/notice/:id",
  //   name: "NoticeRead",
  //   component: BoardRead,
  // },
  {
    path: "/qna",
    name: "Qna",
    component: QnA,
    children: [
      {
        // 문의하기 게시글 하나 읽기
        path: ":id",
        name: "QnaRead",
        component: BoardRead,
      },
      {
        // 문의하기 글쓰기
        path: "write",
        name: "QnaWrite",
        component: BoardWrite,
      },
      {
        // 문의하기 글 수정
        path: "modify/:id",
        name: "QnaModify",
        component: BoardWrite,
      },
      {
        // 문의하기 답글 수정
        path: "modify/answer/:id",
        name: "QnaAnsModify",
        component: BoardWrite,
      },
    ],
  },
  {
    path: "/mypage",
    name: "MyPage",
    component: Mypage,
    children: [
      {
        path: "",
        name: "MypageMain",
        component: MypageMain,
      },
      {
        path: "modify",
        name: "MyinfoModify",
        component: MyinfoModify,
      },
      {
        path: "cancel",
        name: "MyinfoCancel",
        component: MyinfoCancel,
      },
      {
        path: "havelist",
        name: "HaveList",
        component: HaveList,
      },
      {
        path: "haveadd",
        name: "HaveAdd",
        component: MyHaveAdd,
      },
      {
        path: "wantlist",
        name: "WantList",
        component: WantList,
      },
    ],
  },
  {
    path: "/404",
    name: "Page404",
    component: Page404,
  },
  {
    path: "/:catchAll(.*)", // vue3 사용자 정의 정규표현식 매개변수 사용
    redirect: "/404",
  },
  {
    path: "/signup",
    name: "Signup",
    component: SignUp,
  },
  {
    path: "/login",
    name: "Login",
    component: LogIn,
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
