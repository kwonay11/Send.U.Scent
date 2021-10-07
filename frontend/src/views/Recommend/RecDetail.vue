// 상세보기 페이지
<template>
  <div id="RecDetailRoot">
    <div v-if="perfumeInfo" class="content-box">

      <div class="per-title">{{ perfumeInfo.title }}</div>
      <div v-if="isLogin">
        <img @click="Modal()" src="@/assets/icons/like2.png" alt="heart">
        <ModalLike v-if="setModal" @flag="closeModal" :id="this.perfumeInfo.perfume_id" :name="this.perfumeInfo.title"/>
        
      </div>

      <div class="prod-content-main">
        <div class="prod-content-img">
          <img class="per-img" :src="`https://fimgs.net/mdimg/perfume/375x500.${perfumeInfo.perfume_id}.jpg`" alt="perfume-image">
          <div class="score">
            <span class="me-3">평점</span>
            <span class="score">{{ perfumeInfo.rating_score }} / 5.0</span>
          </div>
        </div>
        <div class="prod-content-desc">
          <div class="per-brand">{{ perfumeInfo.brand }}</div>
          <div class="per-gender">PREFER | {{ perfumeInfo.gender }}</div>
          
          <div class="per-note-div">
            <h3>탑 노트&nbsp;&nbsp;<span>5-10 MIN</span></h3>
            향수의 첫 인상을 결정짓는 향
            <ul>
              <span class="me-2" v-for="(item, idx) in perfumeInfo.top" :key="`t-${idx}`">
                #{{ item }}
              </span>
            </ul>
          </div>
          <div class="per-note-div">
            <h3>미들 노트&nbsp;&nbsp;<span>15-60 MIN</span></h3>
            향수 본연의 향
            <ul>
              <span class="me-2" v-for="(item, idx) in perfumeInfo.middle" :key="`m-${idx}`">
                #{{ item }}
              </span>
            </ul>
          </div>
          <div class="per-note-div">
            <h3>베이스 노트&nbsp;&nbsp;<span>2 HOURS -</span></h3>
            가장 마지막에 남는 잔향
            <ul>
              <span class="me-2" v-for="(item, idx) in perfumeInfo.base" :key="`b-${idx}`">
                #{{ item }}
              </span>
            </ul>
          </div>
        </div>
      </div>

      <div class="line"></div>
      <ul>
        <li class="icon" v-for="(item, idx) in iconList" :key="idx">
          <SIcon :id="item.id" :color="item.color" :number="item.number" />
        </li>
      </ul>
      <div class="line"></div>

      <div v-if="reccList.length>0">
        <RecSlider :reccList="reccList" ctitle="recDetail" />
        <div class="line"></div>
      </div>

      <div class="d-desc">
        이미지로 분위기를 느껴보세요
      </div>

      <div class="d-content">
        <div class="d-title">
          <strong>Main Accords</strong><br>
          " {{ perfumeInfo.accords }} "
        </div>
        <ul>
          <li class="accord-img" v-for="(accord, idx) in this.perfumeInfo.accord_list" :key="`a-${idx}`">
            <SAccord :accord="accord" />
          </li>
        </ul>
      </div>

      <div class="d-content">
        <div class="d-title">
          <strong>Top Notes</strong>
        </div>
        <ul>
          <li class="note-img" v-for="(note, idx) in perfumeInfo.top_list" :key="`t-img-${idx}`">
            <SNote :note="note" />{{note}}
          </li>
        </ul>
      </div>
      <div class="d-content">
        <div class="d-title">
          <strong>Middle Notes</strong>
        </div>
        <ul>
          <li class="note-img" v-for="(note, idx) in perfumeInfo.middle_list" :key="`m-img-${idx}`">
            <SNote :note="note" />{{note}}
          </li>
        </ul>
      </div>
      <div class="d-content">
        <div class="d-title">
          <strong>Base Notes</strong>
        </div>
        <ul>
          <li class="note-img" v-for="(note, idx) in perfumeInfo.base_list" :key="`b-img-${idx}`">
            <SNote :note="note" />{{note}}
          </li>
        </ul>
      </div>

      <div v-if="reviewList.length===0">
        <div class="line"></div>
      </div>
      <div v-else>
        <div class="line"></div>
          <MyReviews ctitle="AllReviews" :reviewList="reviewList" />
        <div class="line"></div>
      </div>

      <div class="center-btn">
        <button class="back-btn" @click="goBack">목록</button>
      </div>

    </div>
    <go-top />
  </div>

</template>

<script>
import swal from 'sweetalert';
import SIcon from '@/components/Recommend/SeasonIcon.vue'
import SAccord from '@/components/Recommend/SimpleAccord.vue'
import SNote from '@/components/Recommend/SimpleNote.vue'
import MyReviews from '@/components/Mypage/MyReviews.vue'
import RecSlider from '@/components/Recommend/RecSlider.vue'
import ModalLike from '@/components/ModalLike.vue';
import GoTop from '../../components/GoTop.vue';
import http from '../../utils/http-common.js'
import { mapState } from 'vuex';

import axios from 'axios'
const DJANGO_URL = process.env.VUE_APP_DJANGO_URL

export default {
  name: "RecDetail",
  components: {
    SIcon,
    SAccord,
    SNote,
    MyReviews,
    RecSlider,
    ModalLike,
    GoTop,
  },
  data() {
    return {
      perfumeInfo: {},
      setModal: false,
      iconList: [
        {
          id: "longevity",
          color: "#fa9d81",
          number: null,
        },
        {
          id: "sillage",
          color: "#f28e85",
          number: null,
        },
        {
          id: "winter",
          color: "#78D6F0",
          number: null,
        },
        {
          id: "spring",
          color: "#9FE584",
          number: null,
        },
        {
          id: "summer",
          color: "#FFF574",
          number: null,
        },
        {
          id: "autumn",
          color: "#F9BE6E",
          number: null,
        },
        {
          id: "day",
          color: "#FFD454",
          number: 82,
        },
      ],
      reviewList: [],
      reccList: [],
      likeActive: true,
      wantList: [],
    }
  },
  watch: {
    $route(to, from) {
      if (to.path != from.path) {
        this.$router.go();
      }
    }
  },
  computed: {
    ...mapState(["isLogin","userInfo", "userWant"])
  },
  created() {
    this.wantListChk(this.$route.params.id)
    const perfume_id = this.$route.params.id
    this.getPerfumeInfo(perfume_id)
    .then((res) => {
      this.perfumeInfo = res.data
      this.iconList[0].number = res.data.longevity
      this.iconList[1].number = res.data.sillage
      this.iconList[2].number = res.data.winter
      this.iconList[3].number = res.data.spring
      this.iconList[4].number = res.data.summer
      this.iconList[5].number = res.data.autumn
      if (res.data.daynight === 2) {
        this.iconList[6].id = "night"
        this.iconList[6].color = "#43508C"
      }
    })
    .catch((err) => {
      this.$router.push({ name: 'Page404'})
    })

    this.getReviews(perfume_id)
    .then((res) => {
      this.reviewList = res.data.reviews
    })
    .catch((err) => {
      console.error(err)
    })

    this.getReccList(perfume_id)
    .then((res) => {
      this.reccList = res.data.reccList
    })
    .catch((err) => {
      console.error(err)
    })
  },
  methods: {
    goBack() {
      this.$router.push({ name: 'Perfume'})
    },
    getPerfumeInfo: async function (perfume_id) {
      const url = DJANGO_URL + `/api/detail/${perfume_id}`
      const res = await axios.get(url)
      if (res.status === 200) {
        return res
      }
    },
    getReviews: async function (perfume_id) {
      const url = DJANGO_URL + `/api/detail/${perfume_id}/review`
      const res = await axios.get(url)
      if (res.status === 200) {
        return res
      }
    },
    getReccList: async function (perfume_id) {
      const url = DJANGO_URL + `/api/detail/rec1/${perfume_id}`
      const res = await axios.get(url)
      if (res.status === 200) {
        return res
      }
    },
    closeModal() {
      this.setModal = false;
    },
    Modal(){
      // 이미 보유하고 있으면
      if(!this.likeActive) {
        swal("이미 관심 목록에 등록한 향수입니다.")
      } else {
        console.log("모달 켜져")
        this.setModal = true;
        console.log(this.setModal)
      }
    },
  wantListChk(v) {
    if(this.userInfo !== null)
      http
      .get("/like/list", { params: { user_id : this.userInfo.id}})
      .then((res) => {
        if(res.data.result === "success") {
          this.wantList = res.data.wantlist
          for (let i = 0; i < this.wantList.length; i++) {
            if(this.wantList[i].perfume_id === (v-'0')) {
              // 보유 목록에 이미 있으면
              this.likeActive = false
              // return
            }
          }
        } else {
          const reason = res.data.reason
          if(reason === "등록된 목록이 없습니다.") {
            return;
          } else 
          swal("!데이터를 불러오는데 문제가 발생했습니다.")
        }
      })
    },
  },
}
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";

#RecDetailRoot {
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  font-family: $kor-font-family;
  color: $black-color;
}
.content-box {
  top: 0;
  padding-top: 120px;
}
.prod-content-main {
  display: flex;
  justify-content: center;
  margin-bottom: 80px;
}
.prod-content-img {
  width: 310px;
  margin-right: 10%;
}
.prod-content-desc {
  text-align: left;
  width: 300px;
}
.per-title {
  font-family: $eng-font-family;
  font-weight: bold;
  font-size: 38px;
}
.per-img {
  width: 300px;
  height: 400px;
}
.per-brand {
  font-weight: bold;
  font-size: $bodytitle-font-size;
  color: $point-color;
  margin-top: 28px;
}
.per-gender {
  font-weight: bold;
  font-size: $body-font-size;
  margin-top: 26px;
}
.per-note-div {
  margin-top: 28px;
  line-height: 1.25rem;
}
.per-note-div h3 {
  font-weight: bold;
  font-size: $body-subtitle-font-size;
}
.per-note-div h3> span {
  font-size: $smallest-font-size;
}
.per-note-div ul span {
  font-weight: bold;
  color: #528596;
}
.score {
  display: flex;
  justify-content: center;
  align-items: flex-end;
  margin-top: 10px;
  font-size: $body-font-size;
}
.score > span:first-child{
  font-weight: bold;
  font-size: $body-subtitle-font-size;
  color: $main-color;
}

.line {
  margin-top: 20px;
  margin-bottom: 30px;
  border-top: 1px solid $gray-color;
}
.icon {
  width: 100px;
  height: 100px;
  display: inline-block;
}

.d-desc {
  font-size: $bodytitle-font-size;
  color: $dark-color;
  margin: 110px 0;
}
.d-content {
  margin: 60px 0;
}
.d-title {
  font-family: NanumGothic;
  font-size: $body-subtitle-font-size;
  line-height: 2.4rem;
  margin: 20px;
}
.accord-img {
  width: 330px;
  height: 250px;
  display: inline-block;
}
.note-img {
  width: 190px;
  height: 160px;
  display: inline-block;
}

.center-btn {
  display: flex;
  justify-content: center;
  margin-top: 60px;
  margin-bottom: 100px;
}
.back-btn {
	width: 130px;
	height: 45px;
	border: none;
	border-radius: 3px;
  background: $main-color;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.25);
  color: $white-color;
}

</style>