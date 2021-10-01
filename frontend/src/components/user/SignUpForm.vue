// 회원가입 폼
<template>
  <div id="SignUpRoot">
    <div class="background">
      <div class="up-box">
        <img
          src="../../assets/images/PageTitle_4.png"
          style="width: 100%; height: 250px"
        />
      </div>
      <div class="content-box">
        <div class="user" id="login">
          <div class="for-sns">
            <div class="form-wrap">
              <div>
                <p>아이디</p>
              </div>
              <div>
                <input v-model="user_id" type="text" />
              </div>
              <br />
              <div>
                <p>닉네임</p>
              </div>
              <div>
                <input v-model="nickname" type="text" />
              </div>

              <br />
              <div class="width-form">
                <p>비밀번호</p>
              </div>
              <div>
                <input v-model="password" type="password" />
              </div>
              <br />
              <div class="width-form">
                <p>비밀번호 확인</p>
              </div>
              <div>
                <input v-model="password_chk" type="password" />
              </div>
              <br />
              <div class="button-div">
                <button
                  class="btn btn-color"
                  @click="signup({ user_id, nickname, password })"
                  :disabled="loading"
                >
                  회원가입
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";
export default {
  data() {
    return {
      user_id: null,
      nickname: null,
      password: null,
      password_chk: null,
    };
  },
  methods: {
    //   signup() {
    //       console.log('click')
    //   }
    ...mapActions(["signup"]),
  },
};
</script>

<style lang="scss" scoped>
.background {
  height: 800px;
  font-family: "Do Hyeon", sans-serif;
  display: flex;
  flex-direction: column;
  .up-box {
    position: absolute;
    margin-top: 69px;
    width: 100%;
  }
  .content-box {
    .user {
      display: flex;
      flex-direction: column;
      justify-content: center;
      .for-sns {
        width: 600px;
        height: 500px;
        display: flex;
        justify-content: center;
        align-content: center;
        flex-direction: column;
        margin: 0 auto;
        .form-wrap {
          width: 600px;
          height: 800px;
          border: 0;
          outline: 0;
          display: flex;
          flex-direction: column;
          justify-content: center;
          align-items: center;
          margin-top: 150px;

          input {
            background-color: #f4f6f6;
            border-radius: 10px;
            border: 0;
            outline: 0;
            width: 380px;
          }

          .button-div {
            display: flex;
            .btn-color {
              background-color: #fa9d81;
              border-radius: 50px;
              width: 380px;
            }
            button {
              margin: 15px 10px;
              width: 250px;
              height: 32px;
              font-size: 15px;
              color: #ffffff;
            }
          }
          .add-option {
            margin: 10px 0 0;
            color: rgb(192, 190, 190);
          }
          .sns-login {
            width: 600px;
            display: flex;
            justify-content: center;
            margin-top: 10px;
            img {
              width: 35px;
              height: 35px;
              margin: 0 5px;
            }
          }
        }
      }
    }
  }
}
</style>
