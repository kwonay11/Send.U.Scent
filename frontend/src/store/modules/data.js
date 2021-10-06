import api from "../../api";
import http from "../../utils/http-common.js";
import swal from 'sweetalert';

// initial state
const state = {
    isLogin: false,
    userInfo: null,
    
};

// getters
const getters = {
    login(state) {
        return state.isLogin;
    },
    userInfo(state) {
        return state.userInfo;
    }
};

// actions
const actions = {
    getUserInfo({ commit }, payload) {
        http.get('/user/info', {params: {user_id: payload}})
            .then((res) => {
                if(res.data.result === "success") {
                    commit('setUserInfo', res.data.user);
                // console.log(this.user_nickname)
                } else {
                swal("에러가 발생했습니다.")
                }
            })
            .catch(() => {
                swal("에러 발생!")
            })
        
    }

};

// mutations
const mutations = {
    setIsLogined(state, isLogin) {
        state.isLogin = isLogin;
    },
    setUserInfo(state, userInfo) {
        state.isLogin = true;
        state.userInfo = userInfo;
    }
};


export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
};
