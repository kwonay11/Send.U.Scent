import axios from "axios";
import router from "../../router/index";

export default {
  //   namespaced: true,
  // data
  state: {
    // isLogin: false,
    user_id: null,
    isLoginError: false,
  },
  // 변이 : state값 변경은 여기서만 가능
  // 실행할 때  .commit() 메소드 사용
  mutations: {
    // 로그인 성공했을 때,
    loginSuccess(state, payload) {
      state.isLogin = true;
      state.isLoginError = false;
      state.userInfo = payload;
      state.email = payload.email;
    },
    // 로그인이 실패했을 때,
    LoginError(state) {
      state.isLogin = false;
      state.isLoginError = false;
    },
  },
  // 비동기 처리
  // 실행할 때 .dispatch() 메소드 사용
  // context : state 데이터 접근, payload : 입력받은 값의 매개변수
  actions: {
    // 로그인 시도
    login({ dispatch }, loginObj) {
      // console.log(a)
      // 로그인 -> 토큰반환
      console.log("로그인오브젝트");
      console.log(loginObj);

      axios
        .post("http://j5c204.p.ssafy.io/suscent/api/login/", loginObj) // user_id, password
        .then((res) => {
          if (res.data.code === 200) {
            let user_id = res.data.user_id;
            localStorage.setItem("user_id", user_id);
            router.push({ name: "Home" });
          } else {
            alert("아이디와 비밀번호를 확인해주세요.")
          }
        })
        // 로그인 실패했을 때.
        .catch(() => {
          alert("아이디과 비밀번호를 확인하세요.");
        });
    },

    signup({ dispatch }, signupObj) {
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
