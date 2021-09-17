// 마이페이지 메인
<template>
  <div id="MypageRoot">
    <div class="sub-title">
      <div class="sub-title-bg">
        <p class="title">MyPage</p>
      </div>
    </div>
    <div class="content-box mt-4 my-3">
      <my-profile />
      <div class="button-group mt-3 mb-5">
        <div class="have-list-btn">
          <router-link to="/mypage/havelist" >내가 가진 향수</router-link>
        </div>
        <div class="want-list-btn">
          <router-link to="/mypage/wantlist" >관심 목록</router-link>
        </div>
      </div>
      <my-reviews />
    </div>
  </div>
</template>

<script>
import MyProfile from '../../components/Mypage/MyProfile.vue';
import MyReviews from '../../components/Mypage/MyReviews.vue';
export default {
  name: "MyPage",
  components: { 
      MyProfile ,
      MyReviews,
    },
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
* {
  font-family: $kor-font-family;
}
#MypageRoot {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}
.sub-title {
  width: 100%;
  height: 250px;
  background-image: url("../../assets/images/PageTitle_3.png");
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
.content-box {
  width: 80vw;
  height: 100%;
  margin: 0 auto;
  // background-color: gray;
}
.button-group {
  width: 90%;
  margin: 0 auto;
}
.have-list-btn, .want-list-btn {
  display: inline-grid;
    width: 40%;
    height: 50px;
    margin: 0 20px;
    flex-direction: row;
    flex-wrap: nowrap;
    align-content: center;
    justify-content: center;
    align-items: center;
    justify-items: center;
}
.have-list-btn > a, .want-list-btn > a {
  color: $white-color;
}
.have-list-btn {
  background-color: $sub-point-color;
}
.want-list-btn {
  background-color: $point-color;
}
</style>
