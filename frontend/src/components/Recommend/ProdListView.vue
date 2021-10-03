// 상품 리스트 + 필터
<template>
    <div id="ProdListViewRoot">
    <div class="filter-box">
      <div class="inner-box">
        <br />
        <div>
        <form v-on:submit="onSubmitForm">
          <input type="text" v-model="contents.title"> 
          <button>검색</button> </form>
          <!-- <button @click='searchArr()'>이름 검색</button> -->
        </div>
        <br />
        <div id="text-line">
          <br />
          <label id="text-line2">Filter</label>

          <div class="filter">
            <br />
            <label id="title">|계절별</label>
            <br />
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
            <!-- <button @click='checkArr()'>check</button>      -->
             <button @click='checkArr()'>check</button>                
          </div>
          <br />
          <!-- <span>체크한 이름: {{ checkedNames }}</span> -->
        </div>
      </div>
    </div>
        <div id="ProdListViewRoot">
        
        </div>
    <!-- <div class="perfume-list">
      <div class="card-list">
        <div class="card">
          <div class="img">
            <img src="" alt="" />
          </div>
          <div>
            <p>향수이름</p>
            <p>향수 accord</p>
            <p>향수 note</p>
          </div>
        </div>
      </div>
    </div> -->
  </div>          
</template>

<script >
import axios from "axios";
import ProdListOneVue from './ProdListOne.vue';
export default {
  name: "ProdListView",
  data() {
    return {
    contents:{
      title: '',
    },
    daynight:[],
    gender: [],
    season: [],
    
    
    };
  },
  methods: {
    //버튼 만들어서 누르면 넘기기
    checkArr(){
        axios
        .get(
            `http://localhost:8080/sus/listPage/filter`,
            { params: {daynight:this.daynight[0], gender:this.gender[0], season:this.season[0]}}
        )          
        .then((res) => {
            console.log(res);
            console.log("받음");
            this.$router.push(ProdListOneVue);
          });
    },
    searchArr(){
        axios
        .get(
            [`http://localhost:8080/sus/listPage/filter/${title}`,this.title]
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
            `http://localhost:8080/sus/listPage/filter/${this.contents.title}`
        )          
        .then((res) => {
            console.log(res);
            console.log("받음");
            //this.$router.push({ name: "RecPerfume" });
          });
      },
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
.perfume-list {
  // 상위 요소의 너비보다 하위 요소의 너비가 더 클 경우 줄바꿈
  flex-wrap: wrap;
  margin: 20px 20px 20px 25%;
  width: 100%;
  height: 100%;
  //float: left;
}
.perfume-list .card-list .card {
  border: 1px solid #eee;
  border-radius: 5px;
  height: 350px;
  width: 250px;
  padding: 5px;
  margin: 20px 20px 20px 20px;
  background-color: #e5e5e5;
  font-family: NanumGothic;
}
</style>