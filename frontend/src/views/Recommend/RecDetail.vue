// 상세보기 페이지
<template>
  <div id="RecDetailRoot">
<<<<<<< HEAD
    <div class="content-box">
=======
    <div v-if="perfumeInfo" class="content-box">
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630

      <div class="per-title">{{ perfumeInfo.title }}</div>

      <!-- 요약(평점,브랜드,젠더,노트) -->
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
<<<<<<< HEAD
          <div class="per-gender">PREFER | {{ perfumeInfo.gender.toUpperCase() }}</div>
=======
          <div class="per-gender">PREFER | {{ perfumeInfo.gender }}</div>
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
          
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


      <!-- 지속력,잔향,계절,낮밤 -->
      <div class="line"></div>
      <ul>
        <li class="icon" v-for="(item, idx) in iconList" :key="idx">
          <SIcon :id="item.id" :color="item.color" :number="item.number" />
        </li>
      </ul>
      <div class="line"></div>


      <!-- 상세설명(accord, note) -->
      <div class="d-desc">
        이미지로 분위기를 느껴보세요
      </div>

      <div class="d-content">
        <div class="d-title">
          <strong>Main Accords</strong><br>
          " {{ perfumeInfo.accords }} "
        </div>
        <ul>
<<<<<<< HEAD
          <li class="accord-img" v-for="(accord, idx) in this.accordList" :key="`a-${idx}`">
=======
          <li class="accord-img" v-for="(accord, idx) in this.perfumeInfo.accord_list" :key="`a-${idx}`">
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
            <SAccord :accord="accord" />
          </li>
        </ul>
      </div>

      <div class="d-content">
        <div class="d-title">
          <strong>Top Notes</strong>
        </div>
        <ul>
<<<<<<< HEAD
          <li class="note-img" v-for="(note, idx) in perfumeInfo.top" :key="`t-img-${idx}`">
=======
          <li class="note-img" v-for="(note, idx) in perfumeInfo.top_list" :key="`t-img-${idx}`">
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
            <SNote :note="note" />{{note}}
          </li>
        </ul>
      </div>
      <div class="d-content">
        <div class="d-title">
          <strong>Middle Notes</strong>
        </div>
        <ul>
<<<<<<< HEAD
          <li class="note-img" v-for="(note, idx) in perfumeInfo.middle" :key="`m-img-${idx}`">
=======
          <li class="note-img" v-for="(note, idx) in perfumeInfo.middle_list" :key="`m-img-${idx}`">
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
            <SNote :note="note" />{{note}}
          </li>
        </ul>
      </div>
      <div class="d-content">
        <div class="d-title">
          <strong>Base Notes</strong>
        </div>
        <ul>
<<<<<<< HEAD
          <li class="note-img" v-for="(note, idx) in perfumeInfo.base" :key="`b-img-${idx}`">
=======
          <li class="note-img" v-for="(note, idx) in perfumeInfo.base_list" :key="`b-img-${idx}`">
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
            <SNote :note="note" />{{note}}
          </li>
        </ul>
      </div>


      <!-- 리뷰 -->
      <div class="line"></div>
        <div>리뷰리뷰</div>
      <div class="line"></div>


      <!-- 뒤로가기 버튼 -->
      <div class="center-btn">
        <button class="back-btn" @click="goBack">목록</button>
      </div>

    </div>
  </div>
</template>

<script>
import SIcon from '@/components/Recommend/SeasonIcon.vue'
import SAccord from '@/components/Recommend/SimpleAccord.vue'
import SNote from '@/components/Recommend/SimpleNote.vue'
<<<<<<< HEAD
=======

import axios from 'axios'
const DJANGO_URL = process.env.VUE_APP_DJANGO_URL
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630

export default {
  name: "RecDetail",
  components: {
    SIcon,
    SAccord,
    SNote,
  },
  data() {
    return {
<<<<<<< HEAD
      // 일단 하드코딩
      perfumeInfo: {
        // perfume_id: this.$route.params.id,
        perfume_id: 11588,
        title: "Miss Dior Cherie Eau de Parfum",
        brand: "Christian Dior",
        accords: "fruity,patchouli,woody,earthy,sweet,citrus",
        gender: "women,men",
        longevity: 4,
        sillage: 2,
        daynight:	1,
        top: "strawberry",
        middle: "jasmine,rose",
        base: "vetiver,sandalwood,patchouli,oak moss,amber",
        rating_score: 4.3,
        winter: 22,
        spring: 84,
        summer: 48,
        autumn: 27,
      },
=======
      perfumeInfo: {},
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
      iconList: [
        {
          id: "longevity",
          color: "#fa9d81",
<<<<<<< HEAD
          // number: this.perfumeInfo.longevity,
          number: 80,
=======
          number: null,
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
        },
        {
          id: "sillage",
          color: "#f28e85",
<<<<<<< HEAD
          // number: this.perfumeInfo.sillage,
          number: 50,
=======
          number: null,
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
        },
        {
          id: "winter",
          color: "#78D6F0",
<<<<<<< HEAD
          // number: this.perfumeInfo.winter,
          number: 22,
=======
          number: null,
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
        },
        {
          id: "spring",
          color: "#9FE584",
<<<<<<< HEAD
          // number: this.perfumeInfo.spring,
          number: 84,
=======
          number: null,
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
        },
        {
          id: "summer",
          color: "#FFF574",
<<<<<<< HEAD
          // number: this.perfumeInfo.summer,
          number: 48,
=======
          number: null,
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
        },
        {
          id: "autumn",
          color: "#F9BE6E",
<<<<<<< HEAD
          // number: this.perfumeInfo.autumn,
          number: 27,
        },
      ],
      accordList: [],
    }
  },
  // axios 데이터 바인딩+로그인 구분 전
  created() {
    this.perfumeInfo.top = this.perfumeInfo.top.split(",");
    this.perfumeInfo.middle = this.perfumeInfo.middle.split(",");
    this.perfumeInfo.base = this.perfumeInfo.base.split(",");
    this.perfumeInfo.longevity = this.perfumeInfo.longevity * 20
    this.perfumeInfo.sillage = this.perfumeInfo.sillage * 25
    const aList = this.perfumeInfo.accords.split(",")
    for (let idx = 0; idx < 3; idx++) {
      // if (aList.length < idx) break
      this.accordList.push(aList[idx])
    }
    this.perfumeInfo.accords = aList.join(', ')
=======
          number: null,
        },
        {
          id: "day",
          color: "#FFD454",
          number: 82,
        },
      ],
    }
  },
  created() {
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
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
  },
  methods: {
    goBack() {
      this.$router.push({ name: 'Perfume'})
    },
<<<<<<< HEAD
=======
    getPerfumeInfo: async function (perfume_id) {
      const url = DJANGO_URL + `/api/detail/${perfume_id}`
      const res = await axios.get(url)
      if (res.status === 200) {
        return res
      }
    },
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
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
<<<<<<< HEAD
  // color: $main-color;
=======
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
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

<<<<<<< HEAD
// --------------------------------
=======
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
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

<<<<<<< HEAD
// --------------------------------
=======
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
.d-desc {
  font-size: $bodytitle-font-size;
  color: $dark-color;
  margin: 110px 0;
}
.d-content {
<<<<<<< HEAD
  margin: 50px 0;
=======
  margin: 60px 0;
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
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

<<<<<<< HEAD
// --------------------------------
=======
>>>>>>> 2a546c36ee003f59f973552ecb92e95f8beb9630
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