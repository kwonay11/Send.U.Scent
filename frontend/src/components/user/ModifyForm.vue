<template>
  <div id="ModifyFormRoot">
    <div class="content-box">
      <p class="form-title pt-5">정보 수정</p>
      <div class="form-box pt-5">
        <div class="input-box">
          <span class="input-label">아이디</span>
          <div class="input-bg">
            <input type="text" maxlength="20" id="userId" :placeholder="user_id" disabled>
          </div>
        </div>
        <div class="input-box">
          <span class="input-label">닉네임
            <button class="edit-btn" @click="onEdit('nickname')">
              <i class="fas fa-edit edit-icon-off" :class="{'edit-icon-on':editNickname}"></i>
            </button>
          </span>
          <div class="input-bg">
            <input v-if="editNickname" type="text" maxlength="20" id="userNickname" :placeholder="user_nickname" 
                  v-model="editUser_nickname" @keydown.space.prevent>
            <input v-else type="text" maxlength="20" id="userNickname" :placeholder="user_nickname" disabled>
          </div>
        </div>
        <div class="input-box">
          <span class="input-label">비밀번호
            <button class="edit-btn" @click="onEdit('pwd')">
              <i class="fas fa-edit edit-icon-off" :class="{'edit-icon-on':editPassword}"></i>
            </button>
          </span>
          <div class="input-bg" v-if="editPassword">
            <input type="password" maxlength="20" id="userPwd" placeholder="변경 할 비밀번호를 입력하세요."
                    v-model="editUser_password" @keydown.space.prevent
            >
          </div>
          <span class="warn-text" v-if="error.password">{{error.password}}</span>
        </div>
        <div class="input-box" v-if="editPassword">
          <span class="input-label">비밀번호 확인</span>
          <div class="input-bg">
            <input type="password" maxlength="20" id="pwdChk" placeholder="다시 한 번 입력해주세요." 
                  v-model="passwordConfirm" @keydown.space.prevent>
          </div>
          <span class="warn-text succ-text" v-if="error.passwordConfirm">{{error.passwordConfirm}}</span>
        </div>
        <div class="button-group mt-4">
          <button class="cancel-btn" @click="cancelBtn">취소</button>
          <button class="submit-btn" @click="goSubmit">수정</button>
        </div>
        <div class="mem-cancel-box mt-5">
          <p class="mem-cancel-text">
            <router-link to="/mypage/cancel">회원탈퇴</router-link>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import swal from 'sweetalert';
import PV from 'password-validator';
import http from '@/utils/http-common.js'
import { mapState } from 'vuex';
export default {
  created() {
    this.passwordSchema
      .is()
      .min(8)
      .is()
      .max(20)
      .has()
      .digits()
      .has()
      .letters(),
    
    this.getUser()
  },
  computed: {
    ...mapState(["isLogin", "userInfo"])
  },
  watch: {
    editUser_password(v) {
      this.changePwd = true; // 비번 수정함
      this.moveCheck = false; // 페이지 이동 불가
      this.onCheckPassword();
    },
    passwordConfirm(v) {
      this.onCheckPasswordConfirm();
    },
    editUser_nickname(v) {
      this.changeNicname = true; // 닉넴 수정함
      this.moveCheck = false; // 페이지 이동 불가
    }
  },
  methods: {
    getUser() {
      this.user_id = localStorage.getItem("user_id")
      http.get('/user/info', {params: {user_id: this.user_id}})
          .then((res) => {
              if(res.data.result === "success") {
              this.user_nickname = res.data.user.nickname
              this.password = res.data.user.password
              } else {
              swal("에러가 발생했습니다.")
              }
          })
          .catch(() => {
              swal("에러 발생!")
          })
    },
    onCheckPassword() {
      if(this.editPassword) {
        if( 
          this.password.length >= 0 && !this.passwordSchema.validate(this.password)
        )
        this.error.password = "영문, 숫자 포함 8자리 이상이어야 합니다."
        else this.error.password = false;

        if(this.editUser_password.length === 0)
          this.error.password = "";
      }
    },
    onCheckPasswordConfirm() {
      if(this.editPassword) {
        if(this.editUser_password === this.passwordConfirm) { // 일치
          this.error.passwordConfirm = "";
          this.passwordChk = true;
        } else {
          this.error.passwordConfirm = "입력한 비밀번호가 일치하지 않습니다.";
        }
        if(this.passwordConfirm.length === 0) {
          this.error.passwordConfirm = "* 비밀번호를 다시 한 번 입력해주세요.";
        }
      }
    },
    checkForm() { // submit 전에 input 내용이 다 들어가 있는지 조건에 맞는지 확인
      if(this.changeNicname && this.editUser_nickname) {
        // 닉네임 수정
        this.user_nickname = this.editUser_nickname;
        this.submitChk = 0;
      } else if (this.changePwd && this.editUser_password) {
        // 비밀번호 변경
        if(this.passwordChk) {
          this.password = this.editUser_password;
          this.submitChk = 0;
        } else {
          this.submitChk = 1;
        }
      } else if (!this.changeNicname && !this.changePwd) {
        // 변경 사항 없음
        this.submitChk = 2;
      }else {
        // 예외 상황
        this.submitChk = 1;
      }
    },
    goSubmit() {
      this.checkForm();
      if(this.submitChk == 0) {
        const Form = {
          "user_id" : this.user_id,
          "nickname" : this.user_nickname,
          "password" : this.password
        };
        http.put('/user/update', Form)
            .then((res) => {
              if(res.data.result === 'success') {
                swal("수정 완료");
                this.$router.push('/mypage');
              } else {
                swal("문제가 발생했습니다.");
              }
            })
            .catch(() => {
              swal("문제가 발생했습니다.");
            })
        this.$router.push('/mypage');
      } else if(this.submitChk == 2) {
        swal("수정 사항이 없습니다.");
        this.$router.push('/mypage');
      } else {
        swal("문제가 발생했습니다. \n수정 중 틀린 곳은 없는 지 확인해주세요.");
      }
    },
    cancelBtn() {
      this.checkForm();
      if(this.submitChk !== 2) {
        const ans = confirm('현재 페이지에서 이동하시겠습니까? \n 변경사항이 저장되지 않을 수 있습니다.');
        if(ans)
          this.$router.push('/mypage');
      } else {
        this.$router.push('/mypage');
      }
    },
    onEdit(v) {
      if(v === 'nickname') {
        if(!this.changeNicname) {
          this.editNickname = !this.editNickname;
          window.document.getElementsByClassName('.edit-icon')
        }
      } else if (v === 'pwd') {
        if(!this.changePwd) {
          this.editPassword = !this.editPassword;
        }
      } else {
        this.editNickname = true;
        this.editPassword = true;
      }
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
  beforeRouteLeave (to, next) {
    // 라이프사이클 메소드 : SPA에서 페이지 이동 시
    if(this.moveCheck) next();
    else if(confirm('현재 페이지에서 이동하시겠습니까? \n 변경사항이 저장되지 않을 수 있습니다.')) {
        next();
    }
  },
  data() {
    return {
      editUser_nickname: '',
      editUser_password: '',
      user_id: String,
      user_nickname: String,
      password: '',
      passwordConfirm: '',
      passwordChk: false,
      // 닉네임, 비번 수정 여부
      changeNicname: false,
      changePwd: false,
      // 수정 버튼 활성화 여부
      editNickname: false,
      editPassword: false,
      passwordSchema: new PV(),
      error: {
        password: false,
        passwordConfirm: false,
      },
      // 페이지 이동 가능 여부 true: 가능, false: 불가
      moveCheck: true,
      submitChk: 0, // 0: 수정, 1:에러, 2:변경사항 없음
    }
  },
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
span, p {
  font-family: $kor-font-family;
}
#ModifyFormRoot {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
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
.edit-btn {
  width: 20px;
  height: 20px;
  background: $white-color;
  border: none;
  border-radius: 5px;
  display: inline-grid;
  flex-direction: row;
  flex-wrap: nowrap;
  align-content: center;
  justify-content: center;
  align-items: center;
}
.edit-icon-off {
  font-size: $detail-font-size;
  color: $sub-color;
}
.edit-icon-on {
  color: $main-color !important;
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
.warn-text {
  padding: 5px 20px;
  color: $sub-point-color;
  font-size: $smallest-font-size;
}
.succ-text {
  padding: 5px 20px;
  font-size: $smallest-font-size;
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
.cancel-btn, .submit-btn {
  width: 45%;
  height: 40px;
  border: none;
  border-radius: 50px;
  font-size: $body-font-size;
}
.cancel-btn {
  background: $gray-color;
  color: $white-color;
}
.submit-btn {
  background: $point-color;
  color: $white-color;
}
.mem-cancel-box {
  border-top: 1px solid $white-color;
  text-align: center;
}
.mem-cancel-text {
  padding: 10px;
}
.mem-cancel-text > a {
  color: $sub-color;
}
</style>