// 상품 리스트 + 필터
<template>
    <div id="ProdListViewRoot">
      <div class="filter-box">
        <div class="inner-box">
          <div>
          <form v-on:submit="onSubmitForm">
            <input type="text" v-model="contents.title"> 
            <button>검색</button> 
          </form>
          </div>
          <div id="text-line">
            <label id="text-line2">Filter</label>
            <div class="filter">
              <label id="title">|계절별</label>
              <div class="filter-check">
                <input type="checkbox" value="spring" v-model="season" />
                <label for="spring">봄</label>
                <br />
                <input type="checkbox" value="summer" v-model="season" />
                <label for="summer">여름</label>
                <br />
                <input type="checkbox" value="autumn" v-model="season" />
                <label for="autumn">가을</label>
                <br />
                <input type="checkbox" value="winter" v-model="season" />
                <label for="winter">겨울</label>
              </div>
              <br />
              <label id="title">|시간별</label>
              <br />
              <div class="filter-check">
                <input type="checkbox" value="1" v-model="daynight" />
                <label for="night">밤</label>
                <br />
                <input type="checkbox" value="2" v-model="daynight" />
                <label for="day">낮</label>
              </div>       
              <br />
              <br />
              <label id="title">|성별</label>
              <br />
              <div class="filter-check">
                <input type="checkbox" value="men" v-model="gender"/>
                <label for="male">남성</label>
                <br />
                <input type="checkbox" value="women" v-model="gender"
                />
                <label for="female">여성</label>
              </div>
              <button @click='checkArr()'>check</button>                
            </div>
            <br />
          </div>
        </div>
      </div>
    <prod-list-multi :results="results"/>
  </div>          
</template>

<script >
import axios from "axios";
import ProdListMulti from './ProdListMulti.vue';
//import { API_BASE_URL } from "../utils/config.js";
export default {
  name: "ProdListView",
  props: {
    result: Array,
  },
  components:{
    ProdListMulti
  },
  data() {
    return {
    contents:{
      title: '',
    },
    daynight:[],
    gender: [],
    season: [],
    results:[],
    };
  },
  methods: {
    checkArr(){
        axios
        .get(
            `${API_BASE_URL}/listPage/filter`,
            { params: {daynight:this.daynight[0], gender:this.gender[0], season:this.season[0]}}
        )          
        .then((res) => {
            console.log(res);
            this.results = res.data;
          });
    },
    searchArr(){
        axios
        .get(
            [`${API_BASE_URL}/listPage/filter/${title}`,this.title]
        )          
        .then((res) => {
            console.log(res);
            console.log("받음");
            //this.$router.push({ name: "RecPerfume" });
          });
    },    
    onSubmitForm(e){ 
      // form의 새로 고침 막기 
      e.preventDefault(); 
        console.log(this.contents.title);
        axios
        .get(
            `${API_BASE_URL}/listPage/filter/${this.contents.title}`
        )          
        .then((res) => {
            console.log(res);
            console.log("받음");
            //this.$router.push({ name: "RecPerfume" });
          });
    },
  },
  created(){
        axios
        .get(
            `${API_BASE_URL}/listPage/default`
        )          
        .then((res) => {
            this.results = res.data;         
            console.log(res);
            console.log(this.results);
          });
    },
};
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";
.filter-box {
  float: left;
  font-family: NanumGothic;
  background-color: #f8f4f4;
}
.filter-box .inner-box {
  margin: 20px 20px 20px 40px;
  float: left;
}
.filter-check {
  font-size: 15px;
}
#title {
  margin: 20px 0 20px 0;
  font-size: 20px;
}
>>>>>>> Stashed changes
#text-line {
  float: left;
}
#text-line2 {
  font-size: 25px;
  float: left;
}
input {
  background: white;
  box-sizing: border-box;
  border-radius: 10px;
  border: 4px solid white;
  float: left;
}
#search-bar {
  background: white;
  box-sizing: border-box;
  border-radius: 10px;
  border: 4px solid white;
}
</style>