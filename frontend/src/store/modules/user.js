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
        .post("http://localhost:8888/suscent/api/login/", loginObj) // user_id, password
        .then((res) => {
          console.log("res");
          console.log(res);
          console.log(res.data);
          let user_id = res.data.user_id;
          console.log(user_id);

          // this.$state.isLogin = true
          // this.$state.isLoginError = false
          // this.$state.user_id = user_id
          // 토큰을 로컬 스토리지에 저장
          //   localStorage.setItem("access_token", token) // key - value
          localStorage.setItem("user_id", user_id);
          //   dispatch("getMemberInfo")
          console.log("로그인 완료");
          //   res.commit('loginSuccess')
          router.push({ name: "Home" });
        })
        // 로그인 실패했을 때.
        .catch(() => {
          alert("아이디과 비밀번호를 확인하세요.");
        });
    },

    signup({ dispatch }, signupObj) {
      console.log("하이");
      console.log(signupObj);
      axios
        .post("http://j5c204.p.ssafy.io/suscent/api/users/signup", signupObj)
        .then((res) => {
          console.log(res);
          // let user_id = res.data.user_id
          // let nickname = res.data.nickname
          // let password = res.data.password
          // let loginObj = {
          //     user_id: user_id,
          //     nickname: nickname,
          //     password: password
          // }
          // console.log(loginObj)
          console.log("회원가입 완료");
          router.push({ name: "Login" });
          // dispatch('login', loginObj)
        })
        .catch(() => {
          alert("다시 입력해주세요!");
        });
    },
  },
};
