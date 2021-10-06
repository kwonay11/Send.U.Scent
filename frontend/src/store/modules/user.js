import axios from "axios";
import router from "../../router/index";

export default {
  //namespaced: true,

  mutations: {},

  actions: {
    // 로그인 시도
    login({ dispatch }, loginObj) {
      console.log("로그인오브젝트");
      console.log(loginObj);

      axios
        .post("http://j5c204.p.ssafy.io/suscent/api/login/", loginObj) // user_id, password
        .then((res) => {
          if (res.data.code === 200) {
            console.log("res");
            console.log(res.data);
            let user_id = res.data.user_id;
            console.log(user_id);

            localStorage.setItem("user_id", user_id);

            console.log("로그인 완료");

            router.push({ name: "Home" });
          } else {
            alert("아이디와 비밀번호를 확인하세요.")
          }
        })
        // 로그인 실패했을 때.
        .catch(() => {
          alert("아이디과 비밀번호를 확인하세요.");
        });
    },

    signup({ dispatch }, signupObj) {
      console.log("회원가입오브젝트");
      console.log(signupObj);
      axios
        .post("http://j5c204.p.ssafy.io/suscent/api/users/signup", signupObj)
        .then((res) => {
          console.log(res);
          console.log("회원가입 완료");
          router.push({ name: "Login" });
        })
        .catch(() => {
          alert("다시 입력해주세요!");
        });
    },
  },
};
