// 이미지가 들어간 페이지 타이틀(About, Community, Mypage)
<template>
    <div id="PageTitleRoot">
        <div class="sub-title" :style="{ backgroundImage: 'url(' + this.pageUrl +')'}" >
            <div class="sub-title-bg">
                <p class="title">{{this.page}}</p>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        pageTitle: String,
    },
    data() {
        return {
            page : this.pageTitle,
            pageUrl :'',
        }
    },
    methods: {
        getImgSrc() {
            if(this.page === "About") {
                this.pageUrl = require("@/assets/images/PageTitle_1.png");
            } else if(this.page === "Notice" || this.page === "QnA") {
                this.pageUrl = require("@/assets/images/PageTitle_2.png");
            } else if(this.page === "MyPage" || this.page === "I have" || this.page === "I want" || this.page === "회원탈퇴") {
                this.pageUrl = require("@/assets/images/PageTitle_3.png");
            } else if(this.page === "Login" || this.page === "SignUp") {
                this.pageUrl = require("@/assets/images/PageTitle_4.png");
            }   else if(this.page === "Perfume") {
                this.pageUrl = require("@/assets/images/PageTitle_5.png");
            }
        },
    },
    mounted() {
        this.getImgSrc();
    },
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
#PageTitleRoot {
    width: 100%;
    height: 10%;
    position: absolute;
    top: 0;
    left: 0;
}
.sub-title {
  width: 100%;
  height: 250px;
  background-repeat: no-repeat;
  background-size: cover;
}
.sub-title-bg {
  width: 100%;
  height: 180px;
  position: relative;
  top: 70px;
  background-color: rgba(0,0,0,0.2);
  text-align: center;
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  align-content: center;
  justify-content: center;
}
.title {
  font-size: $subtitle-font-size;
  color: $white-color;
  font-weight: 700;
}
</style>