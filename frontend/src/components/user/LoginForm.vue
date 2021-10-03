// 로그인 폼
<template>
  <div id="LoginRoot">
    <page-title pageTitle="Login"/>
    <div class="content-box mt-5">
      <div class="form-box pt-5">
        <div class="input-box">
          <span class="input-label">아이디</span>
          <div class="input-bg">
            <input type="text" v-model="user_id" maxlength="20" id="userId">
          </div>
        </div>
        <div class="input-box">
          <span class="input-label">비밀번호</span>
          <div class="input-bg">
            <input type="password" maxlength="20" id="userPwd"
                    v-model="password" @keydown.space.prevent @keyup.enter="login({user_id, password})"
            >
          </div>
        </div>
        <div class="button-group mt-5">
          <button class="submit-btn" @click="login({ user_id, password })">로그인</button>
        </div>
        <div class="mem-join-box mt-4">
          <p class="mem-join-text">
            <router-link to="/signup"> 회원가입 </router-link>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PageTitle from '../../components/Header/PageTitle.vue';
import { mapState, mapActions } from "vuex";
export default {
  components: {
    PageTitle,
  },
  data() {
    return {
      user_id: null,
      password: null,
    };
  },
  computed: {
    ...mapState(["isLogin", "isLoginError"]),
  },
  created() {
  },
  methods: {
    ...mapActions(["login"]),
  },
};
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
span, p {
  font-family: $kor-font-family;
}
#LoginRoot {
  width: 100%;
  min-height: 1000px;
}
.form-box {
  width: 50%;
  margin: 0 auto;
  text-align: left;
}
.form-title {
  font-size: $bodytitle-font-size;
  font-weight: bold;
}
.input-box {
  width: 90%;
  margin: 0 auto;
}
.input-box:not(:first-child) {
  margin-top: 10px;
}
.input-label {
  font-size: $body-subtitle-font-size;
  font-weight: 700;
  color: $main-color;
  padding: 4px 15px;
  display: inline-block;
}
.input-bg {
  background: $light-color;
  height: 40px;
  border-radius: 50px;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  align-content: center;
  align-items: center;
}
.input-bg > input {
  padding: 0 30px;
  width: 100%;
}
.input-bg > input:focus {
  border-radius: 50px;
  border : 1px solid $main-color;
  height: 40px;
}
.button-group {
  width: 90%;
  margin: 0 auto;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  align-content: center;
  justify-content: space-between;
  align-items: center;
}
.submit-btn {
  width: 100%;
  height: 40px;
  border: none;
  border-radius: 50px;
  font-size: $body-font-size;
  background: $point-color;
  color: $white-color;
}
.mem-join-box {
  text-align: center;
}
.mem-join-text {
  padding: 10px;
}
.mem-join-text > a {
  color: $sub-point-color;
  text-decoration: underline;
}
</style>
