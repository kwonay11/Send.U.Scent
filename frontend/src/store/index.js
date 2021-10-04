import { createStore } from "vuex";
import data from "./modules/data";
import app from "./modules/app";
import user from "./modules/user";
import http from "../utils/http-common.js";
import createPersistedState from 'vuex-persistedstate'

export default createStore({
  state: {
    isLogin: false,
    userInfo: null,
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

  },
  actions: {
    getUserInfo({ commit }, payload) {
      http
        .get("/user/info", { params: { user_id: payload } })
        .then((res) => {
          if (res.data.result === "success") {
            commit("setUserInfo", res.data.user);
            // console.log(this.user_nickname)
          } else {
            alert("에러가 발생했습니다.");
          }
        })
        .catch(() => {
          alert("에러 발생!");
        });
    },
    logout({ commit }) {
      commit("setLogout");
      localStorage.removeItem("user_id");
      localStorage.removeItem("accords");
      localStorage.removeItem("longevity");
      localStorage.removeItem("sillage");
      localStorage.removeItem("season");
      
    }
  },
  getters: {
    // login(state) {
    //   return state.isLogin;
    // },
    userInfo(state) {
      return state.userInfo;
    },
    
  },
  modules: {
    data,
    app,
    user,
  },
  plugins: [createPersistedState(),]
});
