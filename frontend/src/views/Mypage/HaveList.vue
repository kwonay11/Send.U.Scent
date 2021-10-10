// 가지고 있는 리스트 페이지
<template>
  <div id="HaveListRoot">
    <page-title pageTitle="I have" />
    <div class="content-box mt-5 my-3">
      <div v-if="reccList.length>0" class="rec-box mb-5">
        <RecSlider :reccList="reccList" ctitle="haveList" />
        <div class="line"></div>
      </div>
      <p class="body-title mt-2">회원님이 가진 향수에요</p>
      <div class="have-list">
        <ul v-if="!error" class="item-list">
          <li class="item m-3"  v-for="(item, index) in haveList" :key="index">
            <Prod :id="item.id" :name="item.title" :perfume_id="item.perfume_id" listIs="have" @click="writeReview(item.id, item.title, item.review)"/>
          </li>
        </ul>
        <ul v-if="error" class="item-list">
          <li class="error mt-5">
            💌가지고 있는 향수를 저희에게도 알려주세요~<br>
            관심 목록에서 구매하신 향수를 추가하거나, <br>
            오른쪽의 (+) 버튼을 통해 추가 할 수 있어요!😉
          </li>
        </ul>
      </div>
    </div>
    <div class="btn-box tip">
      <button class="add-list-btn" @click="addHaveProd">
        <i class="fas fa-plus"></i>
      </button>
      <span class="tip-text">보유 향수 등록</span>
    </div>
    <go-top />
    <review-modal v-if="setModal" @flag="closeModal" :id="this.selectedProd.id" :name="this.selectedProd.title"/>
  </div>
</template>

<script>
import swal from 'sweetalert';
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
    this.user_id = localStorage.getItem("user_id");
    this.getList();
    this.getRecList();
  },
  computed: {
      ...mapState(["userInfo"])
  },
  methods: {
    writeReview(id, title, review) {
      if(review === null) {
        this.setModal = true;
        this.selectedProd.id = id;
        this.selectedProd.title = title;
      } else {
        swal("이미 리뷰를 작성한 향수입니다.")
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
          } else {
            const reason = res.data.reason
            if(reason === "등록된 목록이 없습니다.")
              this.error = true;
            else
              swal("!데이터를 불러오는데 문제가 발생했습니다.")
          }
        })
      },
      getRecList() {
        if(!this.error) {
          axios.post(`${DJANGO_URL}/api/detail/rec2/`, { "user_id" : this.user_id})
                .then((res) => {
                  this.reccList = res.data.reccList
                })
                .catch((err) => {
                  console.log(err)
                })
        }
      },
      addHaveProd() {
        this.$router.push('/mypage/haveadd')
      },
  },
  data() {
    return {
      setModal: false,
      error: false,
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
span, p{
  font-family: $kor-font-family;
}
#HaveListRoot {
  width: 100%;
  height: 100%;
  min-height: 1300px;
  position: absolute;
  top: 0;
  left: 0;
  overflow: auto;
  /* for Firefox */
    scrollbar-width: none;
    /* for IE, Edge */
    -ms-overflow-style: none;
}
#HaveListRoot::-webkit-scrollbar {
    display: none;
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
    width: 910px;
    margin: 0 auto;
}
.item {
    width: 150px;
    display: inline-block;
}
.error {
    height: 200px;
    border: 1px solid $gray-color;
    border-radius: 10px;
    display: flex;
    flex-direction: row;
    align-content: center;
    justify-content: center;
    align-items: center
}
.btn-box {
  position: fixed;
  right: 35px;
  bottom: 100px;
}
.add-list-btn {
  width: 40px;
  height: 40px;
  border: none;
  border-radius: 100%;
  background: $point-color;
  color: $white-color;
  box-shadow: 1px 1px 10px rgba(0,0,0,0.2);
}
.add-list-btn:hover{
  background: $heart-color;
}
.tip .tip-text {
  visibility: hidden;
  width: 120px;
  background-color: $sub-point-color;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 5px 0;
  z-index: 1;
  position: fixed;
  right: 87px;
  bottom: 101px;
}
.tip .tip-text::after {
  content: "";
  position: absolute;
  top: 50%;
  left: 100%;
  margin-top: -5px;
  border-width: 5px;
  border-style: solid;
  border-color: transparent transparent transparent $sub-point-color;
}
.tip:hover .tip-text {
  visibility: visible;
}
</style>
