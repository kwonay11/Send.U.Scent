import axios from "axios";
import router from "../../router/index";
import swal from 'sweetalert';

export default {
  namespaced: true,

  // 비동기 처리
  // 실행할 때 .dispatch() 메소드 사용
  // context : state 데이터 접근, payload : 입력받은 값의 매개변수
  actions: {
    // 로그인 시도
    notices({ dispatch }) {

      console.log("공지사항 목록들 디스패치");
      
      axios
        .get("http://j5c204.p.ssafy.io/suscent/api/notices/") // user_id, password
        .then((res) => {
          console.log("res");
          // console.log(res);
          // console.log(res.data);
          // let user_id = res.data.user_id;
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
          swal("아이디과 비밀번호를 확인하세요.");
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
          swal("다시 입력해주세요!");
        });
    },
  },
};
