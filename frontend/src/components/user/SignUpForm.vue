// 회원가입 폼
<template>
  <div id="SignUpRoot">
    <page-title pageTitle="SignUp"/>
    <div class="content-box mt-5">
      <div class="form-box pt-5">
        <div class="input-box">
          <span class="input-label">아이디
            <button class="chk-btn" :class="{'dup-chk-on':idOk}" @click="idChk()"><i class="fas fa-check"></i>{{chk_text}}</button>
          </span>
          <div class="input-bg">
            <input type="text" v-model="user_id" maxlength="20" id="userId" @keydown.space.prevent>
          </div>
          <span class="warn-text" v-if="error.id">{{error.id}}</span>
        </div>
        <div class="input-box">
          <span class="input-label">닉네임
            <button class="chk-btn" :class="{'dup-chk-on':nickOk}" @click="nickChk()"><i class="fas fa-check"></i>{{chk_text}}</button>
          </span>
          <div class="input-bg">
            <input type="text" v-model="nickname" maxlength="20" id="userNic" @keydown.space.prevent>
          </div>
          <span class="warn-text" v-if="error.nickname">{{error.nickname}}</span>
        </div>
        <div class="input-box">
          <span class="input-label">비밀번호</span>
          <div class="input-bg">
            <input type="password" maxlength="20" id="userPwd"
                    v-model="password" @keydown.space.prevent>
          </div>
          <span class="warn-text" v-if="error.password">{{error.password}}</span>
        </div>
        <div class="input-box">
          <span class="input-label">비밀번호 확인</span>
          <div class="input-bg">
            <input type="password" maxlength="20" id="userPwd"
                    v-model="password_chk" @keydown.space.prevent @keyup.enter="checkForm()"
            >
          </div>
          <span class="warn-text succ-text" v-if="error.passwordConfirm">{{error.passwordConfirm}}</span>
        </div>
        <div class="button-group mt-5">
          <button class="submit-btn" @click="checkForm(this.user_id, this.nickname, this.password)">회원가입</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PageTitle from '../../components/Header/PageTitle.vue';
import PV from 'password-validator';
import swal from 'sweetalert';
import http from '../../utils/http-common.js'
import { mapActions } from "vuex";
export default {
  components: {
    PageTitle,
  },
  created() {
    this.passwordSchema
      .is()
      .min(8)
      .is()
      .max(20)
      .has()
      .digits()
      .has()
      .letters()
  },
  watch: {
    user_id(v) {
      this.moveCheck = false; // 페이지 이동 불가
      this.onCheckId();
    },
    nickname(v) {
      this.moveCheck = false; // 페이지 이동 불가
      this.onCheckNick();
    },
    password(v) {
      this.moveCheck = false; // 페이지 이동 불가
      this.onCheckPassword();
    },
    password_chk(v) {
      this.onCheckPasswordConfirm();
    },
  },
  data() {
    return {
      user_id: null,
      nickname: null,
      password: null,
      password_chk: null,
      passwordSchema: new PV(),
      error: {
        id: false,
        nickname: false,
        password: false,
        passwordConfirm: false,
      },
      moveCheck: true,
      chk_text: '중복 체크',
      idOk: false,
      nickOk: false,
      passwordOk: false,
    };
  },
  methods: {
    ...mapActions(["signup"]),
    onCheckId() {
        if(this.user_id.length < 3)
          this.error.id = "최소 3글자 이상이어야 합니다."
        else this.error.id = false;
        if(this.user_id.length === 0) {
          this.error.id = "";
          this.idOk = false
        }
    },
    onCheckNick() {
        if(this.nickname.length < 3)
          this.error.nickname = "최소 3글자 이상이어야 합니다."
        else this.error.nickname = false;
        if(this.nickname.length === 0) {
          this.error.nickname = "";
          this.nickOk = false
        }
    },
    onCheckPassword() {
        if( 
          this.password.length >= 0 && !this.passwordSchema.validate(this.password)
        )
        this.error.password = "영문, 숫자 포함 8자리 이상이어야 합니다."
        else this.error.password = false;

        if(this.password.length === 0) {
          this.error.password = "";
          this.passwordOk = false
        }
    },
    onCheckPasswordConfirm() {
        if(this.password === this.password_chk) { // 일치
          this.error.passwordConfirm = "";
          this.passwordOk = true;
        } else {
          this.error.passwordConfirm = "입력한 비밀번호가 일치하지 않습니다.";
          this.passwordOk = false
        }
        if(this.password_chk.length === 0) {
          this.error.passwordConfirm = "* 비밀번호를 다시 한 번 입력해주세요.";
          this.passwordOk = false
        }
    },
    idChk() { // 아이디 중복체크
      if(this.user_id === "admin") {
        this.idOk = false
        this.error.id = "사용할 수 없는 아이디입니다."
      } else if(this.user_id === null || this.user_id === '') {
        this.error.id = "먼저 아이디를 입력해주세요."
      } else {
        http.get('/user/info/idchk', {params: {user_id : this.user_id}})
            .then((res) => {
              if(res.data.result === "success") {
                this.idOk = true
              } else if(res.data.result === "fail" && res.data.reason === "already used") {
                this.idOk = false
                this.error.id = "이미 사용 중인 아이디입니다."
              } else {
                this.idOk = false
                this.error.id = "사용할 수 없는 아이디입니다."
              }
            })
        }
    },
    nickChk() { // 닉네임 중복체크
      if(this.nickname === "admin") {
        this.nickOk = false
        this.error.nickname = "사용할 수 없는 닉네임입니다."
      } else if(this.nickname === null || this.nickname === '') {
        this.error.nickname = "먼저 닉네임을 입력해주세요."
      } else {
        http.get('/user/info/nickchk', {params: {nickname : this.nickname}})
            .then((res) => {
              if(res.data.result === "success") {
                this.nickOk = true
              } else if(res.data.result === "fail" && res.data.reason === "already used") {
                this.nickOk = false
                this.error.nickname = "이미 사용 중인 닉네임입니다."
              } else {
                this.nickOk = false
                this.error.nickname = "사용할 수 없는 닉네임입니다."
              }
            })
        }
    },
    checkForm(user_id, nickname, password) { // submit 전에 input 내용이 다 들어가 있는지 조건에 맞는지 확인
      if(!this.idOk) {
        this.error.id = "아이디 중복체크를 해주세요."
        return
      }
      if(!this.nickOk) {
        this.error.nickname = "닉네임 중복체크를 해주세요."
        return
      }
      if(!this.passwordOk) {
        this.error.password = "비밀번호를 다시 한 번 확인해주세요."
        return
      }
      this.moveCheck = true
      this.signup({ user_id, nickname, password })
      
    },
    unLoadEvent: function(event) {
        // input 이 변경되지 않은 경우 경고창 뜨지 않음
        if(this.moveCheck) return;
        event.preventDefault();
        event.returnValue = '';
      },
  },
  // 페이지 이동 감지
  mounted() {
    window.addEventListener('beforeunload', this.unLoadEvent);
  },
  beforeUnmount() {
    window.removeEventListener('beforeunload', this.unLoadEvent);
  },
  beforeRouteLeave (to, from, next) {
    // 라이프사이클 메소드 : SPA에서 페이지 이동 시
    if(this.moveCheck) next();
    else {
      const ans = confirm('현재 페이지에서 이동하시겠습니까? \n 변경사항이 저장되지 않을 수 있습니다.')
      if(!ans)
        next(false);
      else
        next();
    }
  },
};
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
span, p {
  font-family: $kor-font-family;
}
#SignUpRoot {
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
.chk-btn {
  background: none;
  border: none;
  height: 20px;
  font-size: $detail-font-size;
  color: $gray-color;
}
.dup-chk-on {
  color: $main-color;
}
.warn-text {
  padding: 5px 20px;
  color: $sub-point-color;
  font-size: $smallest-font-size;
}
.succ-text {
  padding: 5px 20px;
  font-size: $smallest-font-size;
}
</style>
