// 가지고 있는 리스트 페이지
<template>
  <div id="HaveListRoot">
    <page-title pageTitle="I have" />
    <div class="content-box mt-5 my-3">
      <!-- 향수간 유사도 기반 추천 향수 -->
      <!-- <div v-if="reccList.length>0"> -->
      <div class="rec-box mb-3">
        <RecSlider :reccList="reccList" />
        <div class="line"></div>
      </div>
      <p class="body-title">회원님이 가진 향수에요</p>
      <div class="have-list">
        <ul class="item-list">
            <li class="item m-3"  v-for="(item, index) in haveList" :key="index">
              <Prod :id="item.id" :name="item.title" :perfume_id="item.perfume_id" @click="writeReview(item.id, item.title, item.review)"/>
            </li>
        </ul>
      </div>
    </div>
    <go-top />
    <review-modal v-if="setModal" @flag="closeModal" :id="this.selectedProd.id" :name="this.selectedProd.title"/>
  </div>
</template>

<script>
import PageTitle from '../../components/Header/PageTitle.vue';
import Prod from '../../components/SimpleProd.vue';
import ReviewModal from '../../components/ModalReview.vue';
import GoTop from '../../components/GoTop.vue';
import RecSlider from '../../components/Recommend/RecSlider.vue'
import http from '../../utils/http-common.js'
import { mapState } from 'vuex';

import axios from 'axios'
const DJANGO_URL = process.env.VUE_APP_DJANGO_URL
export default {
  name: "HaveList",
  components: {
    PageTitle,
    Prod,
    ReviewModal,
    GoTop,
    RecSlider,
  },
  created() {
    this.user_No = this.userInfo.id;
    this.getList();
  },
  computed: {
      ...mapState(["userInfo"])
  },
  methods: {
    writeReview(id, title, review) {
      // alert(id + "번 향수 리뷰");
      if(review === null) {
        this.setModal = true;
        this.selectedProd.id = id;
        this.selectedProd.title = title;
      } else {
        alert("이미 리뷰를 작성한 향수입니다.")
      }
    },
    closeModal() {
      this.setModal = false;
    },
    getList() {
        http
        .get("/have/list", { params: { user_id : this.user_No}})
        .then((res) => {
          if(res.data.result === "success") {
            this.haveList = res.data.havelist
            // console.log(this.haveList)
            this.getRandIndex();
            this.getReccList(perfume_id);
            // .then((res) => {
            //   console.log('성공')
            //   console.log(res.data.reccList)
            //   console.log('성공')

            //   this.reccList = res.data.reccList
            // })
            // .catch((err) => {
            //   console.error(err)
            //   console.log('에러')
            // })
          } else {
            alert("!데이터를 불러오는데 문제가 발생했습니다.")
          }
        })
        .catch(() => {
          alert("데이터를 불러오는데 문제가 발생했습니다!")
        })
      },
      getReccList: async function (perfume_id) {
      const url = DJANGO_URL + `/api/detail/rec1/${perfume_id}`
      const res = await axios.get(url)
      if (res.status === 200) {
        console.log('성공')
        console.log(res.data.reccList)
        console.log('성공')

        this.reccList = res.data.reccList
      } else {
        console.log('에러')
      }
    },
    getRandIndex() {
      const idxSize = this.haveList.length
      const randNum = Math.floor(Math.random() * idxSize)
      console.log("랜덤")
      console.log(this.haveList[randNum])
      console.log(this.haveList[randNum].perfume_id)
      this.perfume_id = this.haveList[randNum].perfume_id
    },
  },
  data() {
    return {
      setModal: false,
      selectedProd: {
        id: Number,
        title: String,
      },
      haveList : [],
      user_No: Number,
      user_id : String,
      reccList: [],
      perfume_id: Number,
      randIndex: Number,
    }
  },
};
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
* {
  font-family: $kor-font-family;
}
#HaveListRoot {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}
.rec-box {
  min-height: 200px;
  border-bottom: 1px solid $light-color;
}
.body-title {
  font-size: $body-subtitle-font-size;
  font-weight: bold;
}
.item-list {
    width: 800px;
    margin: 0 auto;
}
.item {
    width: 120px;
    display: inline-block;
}
</style>
