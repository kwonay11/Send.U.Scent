// 로그인 폼
<template>
  <div id="LoginRoot">
    <div class="background">
        <div class="up-box">
            <img src="../../assets/images/PageTitle_4.png" style="width: 100%; height: 250px;">
        </div>
        <div class="content-box">
            <div class="user" id="login">
                <div class="for-sns">
                <div class="form-wrap">
                    
                    <div>
                        <p>아이디</p>
                    </div>
                    
                    <div>
                        <input
                        v-model="id"
                        id="id"
                        
                        type="text"
                        />
                    </div>
                    
                    <br>
                    <div>
                        <p>비밀번호</p>
                    </div>
                    <div>
                        <input
                        v-model="password"
                        id="password"
                        
                        type="password"
                        />
                    </div>
                    
                    <br>
                    <div class="button-div">
                        <button class="btn btn-color" @click="login({ id, password })">
                            로그인
                        </button>
                    <!-- <button class="btn btn-color">
                        <router-link to="/signup" class="btn"> 회원가입 </router-link>
                    </button> -->
                    </div>
                    <!-- <router-link to="/signup" class="btn"> 회원가입 </router-link> -->
                    <div class="sns-login">
                    <img src="https://me2.kr/0wmie" alt="google" />
                    <img src="https://me2.kr/rh1k0" alt="naver" />
                    <img src="https://me2.kr/vxczh" alt="kakao" />
                    </div>
                </div>
                </div>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      id: null,
      password: null,
    };
  },
  methods: {
    toSignup() {
      this.$router.push("/signup");
    },
  },
};
</script>

<style lang="scss" scoped>
.background {
    height: 800px;
    font-family: "Do Hyeon", sans-serif;

    .up-box {
            position:absolute;
            margin-top: 69px;
            
            width: 100%;
            
    }
    .content-box {
        .user {
            display: flex;
            flex-direction: column;
            justify-content: center;
            .for-sns {
                // border: black 1px;
                width: 600px;
                height: 500px;
                display: flex;
                justify-content: center;
                align-content: center;
                flex-direction: column;
                margin: 0 auto;
                .form-wrap {
                    width: 600px;
                    height: 400px;
                    border: 0;
                    outline: 0;
                    display: flex;
                    flex-direction: column;
                    justify-content: center;
                    align-items: center;
                }
            
            #password,
            #id {
                background-color: #F4F6F6;
                border-radius: 10px;
                width: 380px;
                border: 0;
                outline: 0;
            }
            .button-div {
                display: flex;
                // background-color: #8064A2 !important;
                .btn-color {
                    background-color: #FA9D81;
                    border-radius: 50px;
                    width: 380px;
                }
                button {
                margin: 15px 10px;
                width: 110px;
                height: 32px;
                font-size: 15px;
                color: #ffffff;
                }
            }
            .add-option {
                margin: 10px 0;
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
</style>
