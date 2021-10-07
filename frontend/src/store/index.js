import { createStore } from "vuex";
import data from "./modules/data";
import app from "./modules/app";
import user from "./modules/user";
import http from "../utils/http-common.js";
import createPersistedState from 'vuex-persistedstate'
import swal from 'sweetalert';

export default createStore({
  state: {
    isLogin: false,
    userInfo: null,
    userHave: null,
    userWant: null,
  },
  mutations: {
    setIsLogined(state, isLogin) {
      state.isLogin = isLogin;
    },
    setUserInfo(state, userInfo) {
      state.isLogin = true;
      state.userInfo = userInfo;
    },
    setLogout(state) {
      state.isLogin = false;
      state.userInfo = null;
    },
    setUserHave(state, userHave) {
      state.userHave = userHave;
    },
    setUserWant(state, userWant) {
      state.userWant = userWant;
    },

  },
  actions: {
    getUserInfo(payload) {
      http
        .get("/user/info", { params: { user_id: payload } })
        .then((res) => {
          if (res.data.result === "success") {
            this.$store.commit("setUserInfo", res.data.user);
            // console.log(this.user_nickname)
          } else {
            swal("에러가 발생했습니다.");
          }
        })
        .catch(() => {
          swal("에러 발생!");
        });
    },
    logout({ commit }) {
      commit("setLogout");
      localStorage.removeItem("user_id");
      localStorage.removeItem("accords");
      localStorage.removeItem("longevity");
      localStorage.removeItem("sillage");
      localStorage.removeItem("season");
      this.state.userHave = null;
      this.state.userWant = null;
    }
  },
  getters: {
    // login(state) {
    //   return state.isLogin;
    // },
    userInfo(state) {
      return state.userInfo;
    },
    userHave(state) {
      return state.userHave;
    },
    userWant(state) {
      return state.userWant;
    },
    
  },
  modules: {
    data,
    app,
    user,
  },
  plugins: [createPersistedState(),]
});
