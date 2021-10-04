// 상품 리스트 + 필터
<template>
    <div id="ProdListViewRoot">
    <page-title pageTitle="Perfume"/>
      <div class="filter-box">
        <div class="inner-box">
          <form v-on:submit="onSubmitForm">
            <input class="search-bar" type="text" v-model="contents.title"> 
            <button class="button">
            <img src="../../assets/icons/find.png"/>            
            </button>
          </form>
            <div class="filter">
              <label class="title">|계절별</label>
              <div class="filter-check">
                <input type="checkbox" value="spring" onClick="setCheckBoxAsRadio(season, this);" v-model="season" />
                <label for="spring">봄</label>
                <br />
                <input type="checkbox" value="summer" onClick="setCheckBoxAsRadio(season, this);" v-model="season" />
                <label for="summer">여름</label>
                <br />
                <input type="checkbox" value="autumn" onClick="setCheckBoxAsRadio(season, this);" v-model="season" />
                <label for="autumn">가을</label>
                <br />
                <input type="checkbox" value="winter" onClick="setCheckBoxAsRadio(season, this);" v-model="season" />
                <label for="winter">겨울</label>
              </div>
              <label class="title">|시간별</label>
              <br />
              <div class="filter-check">
                <input type="checkbox" value="1" v-model="daynight" />
                <label for="night">밤</label>
                <br />
                <input type="checkbox" value="2" v-model="daynight" />
                <label for="day">낮</label>
              </div>       
              <label class="title">|성별</label>
              <br />
              <div class="filter-check">
                <input type="checkbox" value="men" v-model="gender"/>
                <label for="male">For him</label>
                <br />
                <input type="checkbox" value="women" v-model="gender"/>
                <label for="female">For her</label>
                <br />                
                <input type="checkbox" value="women,men" v-model="gender"/>
                <label for="female">For unisex</label>                
              </div>
              <br />             
              <button class="filter-btn" @click='checkArr()'>check</button>                
            </div>
            <br />
          </div>
      </div>
    <prod-list-multi :results="results"/>
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
    };
  },
  methods: {
  // 체크박스 하나만 체크되도록.
    setCheckBoxAsRadio(targetObj, inObj){
    var len = targetObj.length;
    
    if(len>1){ // 객체가 배열이라면. 배열이 아니면 그냥 체크박스로 작동
      for(var i=0; i<len; i++){
      if(targetObj[i] != inObj)
        targetObj[i].checked = false;
      }
    }
    }, 
    checkArr(){
        console.log(this.gender[0]);      
        http
        .get(
            `/listPage/filter`,
            { params: {daynight:this.daynight[0], gender:this.gender[0], season:this.season[0]}}
        )          
        .then((res) => {
          
            console.log(res);
            this.results = res.data;
          });
    },
    // searchArr(){
    //     http
    //     .get(
    //         `/listPage/filter/${title}`,this.title
    //     )          
    //     .then((res) => {
    //         console.log(res);
    //         console.log("받음");
    //         //this.$router.push({ name: "RecPerfume" });
    //       });
    // },    
    onSubmitForm(e){ 
      // form의 새로 고침 막기 
      e.preventDefault(); 
        console.log(this.contents.title);
        http
        .get(
            `/listPage/search/${this.contents.title}`
        )          
        .then((res) => {
            console.log(res);
            console.log("받음");
            //this.$router.push({ name: "RecPerfume" });
          });
    },
    defaultList(){
        http
        .get(
            `/listPage/default`
        )          
        .then((res) => {
            this.results = res.data;         
            console.log(res);
            console.log(this.results);
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
  height: 79%;   
  float: left;
  font-family: $kor-font-family;
  background-color: white;;
}
.filter-box .inner-box {
  width: 40%;  
  height: 70%;  
  margin-top: 10%;
  margin-left: 25%;
}
input.search-bar {
  width: 150px;
  height: 30px;
  box-sizing: border-box;
  border-radius: 10px;
  border: 4px solid black;
  border-width: 1px;  
  float: left;
  position: relative;
  top: 1.5px;
  background-color: white; 
}
.button{
  // display:inline-block;
  border: #f8f4f4;
}
.filter{
  float:left;
}
.title {
  margin: 20px 0 10px 0;
  font-size: 18px;
}
.filter-check{
  font-size: 15px;
}

.filter-btn{
  border-radius: 10px;
  border: #f8f4f4;
}


</style>