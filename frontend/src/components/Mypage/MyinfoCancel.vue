<template>
  <div id="MyinfoCancelRoot">
      <page-title pageTitle="회원탈퇴"/>
      <div class="content-box">
        <div v-if="!this.cancelYes" class="cancel-confirm-box mt-5">
          <div class="text-box mt-4">
            <p class="title-text"><b>{{user.nickname}} </b>님 우리의 추억이 사라져요😥</p>
            <p class="body-text">정말 저희와 편지를 여기서 끝내실건가요?</p>
          </div>
          <div class="img-box">
            <img src="../../assets/images/lonely.jpg" alt="lonely">
          </div>
          <div class="button-group mt-3">
            <button class="cancel-btn" @click="cancelBtn">취소</button>
            <button class="delete-btn" @click="deleteBtn">탈퇴</button>
          </div>
        </div>
        <div v-if="this.cancelYes" class="ok-bye-box mt-5">
          <div class="text-box mt-4">
            <p class="title-text"><b>떠나시더라도 언제나 여러분의 편지를 기다리고 있을게요 :)</b></p>
            <span class="body-text">Send.U.Scent는 당신의 취향을 보내면, 당신에게 맞는 향을 보냅니다.</span><i class="far fa-paper-plane"></i>
          </div>
          <div class="img-box mt-4">
            <img src="../../assets/images/sendU.jpg" alt="sendLetter">
          </div>
          <div class="text-box mt-5">
            <p class="info-text">{{this.timeCnt}}초 후 자동으로 이동됩니다.</p>
          </div>
        </div>
      </div>
  </div>
</template>

<script>
import PageTitle from '../../components/Header/PageTitle.vue';
import http from "../../utils/http-common.js";
import { mapState } from 'vuex';
export default {
  name: 'MyinfoCancel',
  components: {
    PageTitle,
  },
  computed: {
    ...mapState(["isLogin", "userInfo"])
  },
  created() {
    this.getUser()
  },
  methods: {
    getUser() {
      this.user.userid = localStorage.getItem("user_id")
      this.user.nickname = this.userInfo.nickname
    },
    cancelBtn() {
      this.$router.replace('/mypage'); // 뒤로 가기
    },
    deleteBtn() {
      const ans = confirm('탈퇴 확인 시 계정이 삭제되며 돌이킬 수 없습니다. \n탈퇴하시겠습니까?');
      if(ans) {
        this.cancelYes = true;
        http.delete('/user/delete', {params: {user_id: this.user.userid}})
            .then((res) => {
              if(res.data.result === "success") {
                this.$store.dispatch("logout")
              }
            })
        localStorage.removeItem("user_id");
        this.countDownTimer();
        setTimeout(() => {
          this.$router.push('/');
        }, 4000);
      }
    },
    countDownTimer() {
      if(this.timeCnt > 0) {
        setTimeout(() => {
          this.timeCnt = this.timeCnt-1;
          this.countDownTimer();
        }, 1000);
      };
    },
  },
  data() {
    return {
      user: {
        userid: String,
        nickname: String,
      },
      cancelYes: false,
      timeCnt: 3,
    }
  },
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
span, p {
  font-family: $kor-font-family;
}
#MyinfoCancelRoot {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}
.cancel-confirm-box {
  width: 80%;
  margin: 0 auto;
}
.text-box {

}
.title-text {
  font-size: $subtitle-font-size;
}
.body-text {
  font-size: $body-subtitle-font-size;
}
.img-box {
  width: 50%;
  height: 50%;
  margin: 0 auto;
}
.img-box > img {
  width: 100%;
  height: 100%;
}
.button-group {
  width: 60%;
  margin: 0 auto;
}
.cancel-btn, .delete-btn {
  width: 40%;
  height: 40px;
  border: none;
  border-radius: 50px;
  font-size: $body-font-size;
}
.cancel-btn {
  background: $sub-color;
  margin-right: 20px;
}
.cancel-btn:hover {
  background: $main-color;
  color: $white-color;
}
.delete-btn {
  background: $light-color;
}
.delete-btn:hover {
  background: $sub-light-color;
  font-weight: bold;
}
.info-text {
  font-size: $body-font-size;
  color: $main-color;
}
</style>