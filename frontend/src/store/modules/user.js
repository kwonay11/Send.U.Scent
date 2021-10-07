import axios from "axios";
import router from "../../router/index";
import swal from 'sweetalert';

export default {
  //namespaced: true,

  mutations: {},

  actions: {
    // 로그인 시도
    login({ dispatch }, loginObj) {
      axios
        .post("https://j5c204.p.ssafy.io/suscent/api/login/", loginObj) // user_id, password
        .then((res) => {
          if (res.data.code === 200) {
            let user_id = res.data.user_id;
            localStorage.setItem("user_id", user_id);
            router.push({ name: "Home" });
          } else {
            swal("아이디와 비밀번호를 확인하세요.")
          }
        })
        // 로그인 실패했을 때.
        .catch(() => {
          swal("아이디과 비밀번호를 확인하세요.");
        });
    },

    signup({ dispatch }, signupObj) {
      axios
        .post("https://j5c204.p.ssafy.io/suscent/api/users/signup", signupObj)
        .then((res) => {
          swal("회원가입을 축하합니다!");
          router.push({ name: "Login" });
        })
        .catch(() => {
          swal("다시 입력해주세요!");
          location.reload()
        });
    },
  },
};
