<template>
  <div id="MypageMainRoot">
    <page-title pageTitle="MyPage"/>
    <div class="content-box mt-5 my-3">
      <my-profile />
      <div class="button-group mt-4 mb-5">
        <div class="have-list-btn">
          <router-link to="/mypage/havelist" >내가 가진 향수</router-link>
        </div>
        <div class="want-list-btn">
          <router-link to="/mypage/wantlist" >관심 목록</router-link>
        </div>
      </div>
      <my-reviews ctitle="MyReviews" :reviewList="reviewList" />
    </div>
  </div>
</template>

<script>
import swal from 'sweetalert';
import PageTitle from '../../components/Header/PageTitle.vue';
import MyProfile from '../../components/Mypage/MyProfile.vue';
import MyReviews from '../../components/Mypage/MyReviews.vue';
import http from '../../utils/http-common.js'
import { mapState } from 'vuex';
export default {
  name: "MypageMain",
  components: { 
      PageTitle,
      MyProfile ,
      MyReviews,
    },
    computed: {
      ...mapState(["userInfo"])
    },
    created() {
      this.getUser();
    },
    methods: {
      getUser() {
        this.user_id = localStorage.getItem("user_id")
        http
        .get("/user/info", { params: { user_id: this.user_id } })
        .then((res) => {
          if (res.data.result === "success") {
            this.$store.commit("setUserInfo", res.data.user);
            this.user_No = res.data.user.id;
            this.getList()
          } else {
            swal("에러가 발생했습니다.");
          }
        })
        .catch(() => {
          swal("에러 발생!");
        });
      },
      getList() {
        http
        .get("/have/list", { params: { user_id : this.user_No}})
        .then((res) => {
          if(res.data.result === "success") {
            this.reviewList = res.data.havelist
          } else {
            const reason = res.data.reason
            if(reason === "등록된 목록이 없습니다.")
              return;
            else
              swal("데이터를 불러오는데 문제가 발생했습니다.")
          }
        })
      },
    },
    data() {
      return {
        user_No: Number,
        user_id : String,
        reviewList: [],
      }
    },
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
* {
  font-family: $kor-font-family;
}
#MypageMainRoot {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}
.button-group {
  width: 90%;
  margin: 0 auto;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  align-content: center;
  justify-content: space-evenly;
}
.have-list-btn, .want-list-btn {
  display: inline-grid;
    // width: 40%;
    // height: 50px;
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
  width: 33vw;
  height: 50px;
  line-height: 3.2em;
}
.have-list-btn {
  background-color: $sub-point-color;
}
.want-list-btn {
  background-color: $point-color;
}
</style>