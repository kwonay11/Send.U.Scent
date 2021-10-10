// 상품 리스트 + 필터
<template>
    <div id="ProdListViewRoot">
    <page-title pageTitle="Perfume"/>
      <div class="filter-box">
          <form v-on:submit="onSubmitForm">
            <input class="search-bar" type="text" placeholder=" 향수 이름 or 브랜드" v-model="contents.title"> 
            <button class="button">
            <img class="find" 
            src="../../assets/icons/find.png"/>            
            </button>
          </form>
        <div class="inner-box">
            <div class="filter">
              <label class="title">|계절별</label>
              <div class="filter-check">
                <input type="checkbox" value="spring" v-model="season" />
                <label for="spring">봄&#127800;</label>
                <br />
                <input type="checkbox" value="summer" v-model="season" />
                <label for="summer">여름&#127817;</label>
                <br />
                <input type="checkbox" value="autumn" v-model="season" />
                <label for="autumn">가을&#127810;</label>
                <br />
                <input type="checkbox" value="winter" v-model="season" />
                <label for="winter">겨울&#127876;</label>
              </div>
              <label class="title">|시간별</label>
              <br />
              <div class="filter-check">
                <input type="checkbox" value="1" id="1" v-model="daynight" />
                <label for="day">낮&#127774;</label>
                <br />
                <input type="checkbox" value="2" id="2" v-model="daynight" />
                <label for="night">밤&#127769;</label>
              </div>       
              <label class="title">|성별</label>
              <br />
              <div class="filter-check">
                <input type="checkbox" value="men" v-model="gender"/>
                <label for="male">For him&#128102;</label>
                <br />
                <input type="checkbox" value="women" v-model="gender"/>
                <label for="female">For her&#128103;</label>
                <br />                
                <input type="checkbox" value="women,men" v-model="gender"/>
                <label for="female">For unisex&#128107;</label>                
              </div>
              <br />             
              <button class="filter-btn" @click='checkArr()'>check</button>                
            </div>
            <br />
          </div>
      </div>
      <div>
      <div/>
    <prod-list-multi :results="results" :counts="counts"/>
  </div> 
  </div>            
</template>

<script >
import ProdListMulti from './ProdListMulti.vue';
import http from "../../utils/http-common.js";
import PageTitle from '@/components/Header/PageTitle.vue';
export default {
  name: "ProdListView",
  props: {
    result: Array,
  },
  components:{
    PageTitle,    
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
    counts: 0,
    };
  },
  methods: {
    checkArr(){
        http
        .get(
            `/listPage/filter`,
            { params: {daynight:this.daynight[0], gender:this.gender[0], season:this.season[0]}}
        )          
        .then((res) => {
            this.results = res.data;
            this.counts = res.data.length;
          });
    },   
    onSubmitForm(e){ 
        e.preventDefault(); 
        http
        .get(
            `/listPage/search/${this.contents.title}`
        )          
        .then((res) => {
            this.results = res.data; 
            this.counts = res.data.length;
          });
    },
    defaultList(){
        http
        .get(
            `/listPage/default`
        )          
        .then((res) => {
            this.results = res.data;         
            this.counts = res.data.length;
});
    },    
  },
  created(){
    this.defaultList();
  },
};
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";

#ProdListViewRoot {
  font-family: $kor-font-family;
  color: $black-color;
}
.filter-box {
  width: 20%;
  height: 87.8%;   
  float: left;
  padding-left:1vh;
  font-family: $kor-font-family;
  background-color: #f8f4f4;
  padding-top: 4%;
}
.filter-box .inner-box {
  
  width: 40%;  
  height: 70%;  
  margin-top: 10%;
  margin-left: 20%;
  background-color: #f8f4f4;
}
input.search-bar {
  width: 180px;
  height: 30px;
  box-sizing: border-box;
  border-radius: 10px;
  border: 4px solid $main-color;
  border-width: 1px;  
  // float: left;

  position: relative;
  top: 15px;
  background-color: white; 

}
input::placeholder{
  font-size:$detail-font-size;
  font-family: $kor-font-family;
}
.find{
  position: absolute;
  float: right;
  width:1.8%;
}
.button{
  border: #f8f4f4;
}
.filter{
  width: 20vh;
  text-align: left;
}
.title {
  font-family: $kor-font-family;
  color:$main-color;
  margin: 20px 0 10px 0;
  font-size: $body-font-size;
  font-weight: bold;
  text-align: left;
}
.filter-check{
  font-size: 15px;
  text-align: left;
}

.filter-btn{
  border-radius: 10px;
  background-color:$point-color;
  color:white;
  border-width: 2px;
  border-color :white;

}
.filter-check input[type="checkbox"]:checked {
        background-color: $point-color;
        border-color: rgba(255, 255, 255, 0.3);
        color: white;
    }


</style>