// 이미지가 들어간 페이지 타이틀(About, Community, Mypage)
<template>
    <div id="PageTitleRoot">
        <!-- <div class="sub-title"> -->
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
                this.pageUrl = "/img/PageTitle_1.3d732872.png";
            } else if(this.page === "Notice" || this.page === "QnA") {
                this.pageUrl = "/img/{ageTitle_2.598cf4e9.png";
            } else if(this.page === "MyPage" || this.page === "I have" || this.page === "I want") {
                this.pageUrl = "/img/PageTitle_3.a6e86150.png";
            } else if(this.page === "Login" || this.page === "SignUp") {
                this.pageUrl = "/img/PageTitle_4.03b2913f.png";
            }
        },
    },
    mounted() {
        // console.log(this.page);
        this.getImgSrc();
        // console.log(this.pageUrl);
    },
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
#PageTitleRoot {
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
}
.sub-title {
  width: 100%;
  height: 250px;
  background-image: url("../../assets/images/PageTitle_4.png");
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