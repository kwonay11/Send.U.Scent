// 테스트 결과 페이지
<template>
    <div id="TestResultRoot">

    <div class="box">
        <div class="title fadeIn">Send you your Scent</div>
        <div class="subtitle fadeIn">{{$route.query.name}}님에게 어울리는 향수에 대한
        </div>
        <div class="best fadeIn">
            <p >가장 잘 맞는 향은, </p>
            {{best_accord1}},&nbsp;{{best_accord2}},&nbsp;{{best_accord3}}
        </div>
        <div class="wordcloud">
            <img src="@/assets/images/perfume3.png" alt="" class="my-2" style="width:58%;">
            <tags-ball class="ball" v-bind:style='{"border":"0px black"}' :tags='accords_list'/>
            <div class="ac_dec">
                <p style="font-weight:bold">Accords</p>

            <div v-for="(value,idx) in sorted_list" v-bind:key="idx">
                <div>{{value[0]}} - {{value[1]}}회</div>
                </div>
            </div>
          
        </div>

   
   
        <div class="dec fadeIn"> {{$route.query.name}}님이 좋아하실 만한 향수들이에요.</div>
        <div class="perfume">
   
            <div  v-for="(value,idx) in perfume_id" v-bind:key="idx">
                <router-link :to="`/recommend/detail/${value}`">
                <img class="img" :src="`https://fimgs.net/mdimg/perfume/375x500.${value}.jpg`" alt="perfume-image">
                 <div class="perfume_title">{{title[idx]}}</div>
                </router-link>
            </div>
        </div>
        <div class="dec2 fadeIn"> {{$route.query.name}}님이 이런 향수도 좋아하실 수 있어요.</div>
        <div class="perfume2">
            <div  v-for="(value,idx) in perfume_id2" v-bind:key="idx">
                    <router-link :to="`/recommend/detail/${value}`">
                    <img class="img" :src="`https://fimgs.net/mdimg/perfume/375x500.${value}.jpg`" alt="perfume-image">
                    <p class="perfume_title">{{title2[idx]}}</p>
                    </router-link>
                </div>
          
        </div>
     </div>
    </div>

    
</template>


<script>
import TagsBall from 'vue-tags-ball'
import axios from "axios"
const DJANGO_URL = process.env.VUE_APP_DJANGO_URL
export default {
    name:'DearTestResult',
    components: {
        "tags-ball":TagsBall
    
     
    },
    data() {
        return{ 
            perfume_id : [],
            title : [],
            perfume_id2 : [],
            title2 : [],
            accords : [],
            accords_len : 0,
            setModal: false,
            selectedProd: {
                id: Number,
                name: String,
            },

            accords_list : [],
            sorted_list : [],


            best_accord:[],
            best_accord1:'',
            best_accord2:'',
            best_accord3:'',
           
           

            
            
           

          
           

        }
    },
   
    methods:{
        
        addHave(id, name) {
            this.setModal = true;
            this.selectedProd.id = id;
            
        },
        closeModal() {
            this.setModal = false;
        },
        modal(){
            this.setModal = true;
        },
         
      
    
       
    },
    created(){
        axios.get(`${DJANGO_URL}/tests/getresult/`)
        .then((res)=>{
            console.log(res.data)
            console.log("데이터 받아옴")
            // console.log(res.data.perfume_id)
            this.perfume_id = res.data.perfume_id
            this.title = res.data.title
            this.perfume_id2 = res.data.perfume_id2
            this.title2 = res.data.title2
            this.accords = res.data.accords
            this.sorted_list = res.data.sorted_accords

            this.best_accord1 = this.sorted_list[0][0];
            this.best_accord2 = this.sorted_list[1][0];
            this.best_accord3 = this.sorted_list[2][0];

            this.best_accord.push(this.best_accord1)
            this.best_accord.push(this.best_accord2)
            this.best_accord.push(this.best_accord3)

        
            localStorage.setItem("accords", this.best_accord),


            this.accords_list = Object.keys(this.accords)
        
           
        

        })
        .catch(()=>{
            console.log("데이터 못받음")

        })


    },
}


</script>


<style lang="scss" scoped>
@import "@/styles/common.scss";
#TestResultRoot{
    background-color: $sub-color;
    background-size: 100%;
    width: 100%;
    height: 280vh;
}
.box{
  background-color: white;
  position: relative;
  width:80%;
  left: 9.8%;
  height: 100%;

}
.res{
    z-index: 300;
    position:absolute;
    top:20vh;
    left:10vw;
    color:rgb(9, 31, 23);
}
.title{
    color:$heart-color;
    font-family:$eng-font-family;
    font-size:$title-font-size;
    position: absolute;
    top: 7%;
    width: 100%;
    font-weight: bold;

}
.subtitle{
    
    position: absolute;
    top: 10%;
    width: 100%;
    color:black;
    font-family:$kor-font-family;
    font-size:$subtitle-font-size;
    font-weight: bold;
    z-index: 1;
    margin-top:2vh;
    height:10vh;

}
.wordcloud{
    position: absolute;
    top: 20%;
    width: 100%;
    color:black;

}
.dec{
    font-family:$kor-font-family;
    font-size:$bodytitle-font-size;
    position: absolute;
    top: 57%;
    width: 100%;
    color:black;
    font-weight: bold;
    

}
.dec2{
    font-family:$kor-font-family;
    font-size:$bodytitle-font-size;
    position: absolute;
    top: 78%;
    width: 100%;
    color:black;
    font-weight: bold;
    

}
.perfume{
     display: flex;
    position: relative;
     top: 63%;
     width: 100%;
     height:10vh;
     padding-left: 6vw;
    margin-left:1vw;
    margin-right:0.5vw;

    
    
}
.perfume2{
    display: flex;
    position: relative;
     top: 80%;
     width: 100%;
     height:10vh;
     padding-left: 6vw;
    //  float: left;
    margin-left:1vw;
    margin-right:0.5vw;
    

    
    
}
.img{
    // position: relative;
    width: 54%;
    float: left;
    margin-left:0.5vw;
    margin-right:0.5vw;
    display:block;
    margin-bottom:1vh ;
    
}

.perfume_title{
    // display: flex;
    // position: absolute;
    // float:left;
    // left:-10vw;
     width:59%;
    color:black;
    font-family:$eng-font-family;
    font-size:$body-font-size;
 
    display:block;
   
    

    
}
.ball{
    width: 30%;
    position: absolute;
    left:36%;
    top:41%;
    z-index: 22;
//     color:$main-color !important;
//     font-family:$eng-font-family;
}
.ac_dec{
    border:2px $main-color solid;
    border-radius: 20px;
    float:left;
    color:$main-color;
    font-family:$eng-font-family;
   
    margin-left:7%;
    position:absolute;
    top:23%;
    padding: 1.3%;

}
.best{
    position: absolute;
    top: 15%;
    width: 100%;
    color:$point-color;
    font-family:$eng-font-family;
    font-size:$subtitle-font-size;
    font-weight: bold;
    z-index: 1;
    margin-top:2vh;
    height:10vh;
}

@keyframes fadeIn {
  from { opacity: 0; }
  to { opacity: 1; }
}
@keyframes fadeOut {
  from { opacity: 1; }
  to { opacity: 0; }
}
// 크롬은 웹킷
@-webkit-keyframes fadeIn {
  from {opacity: 0;}
  to {opacity: 1;}
}
@-webkit-keyframes fadeOut {
  from {opacity: 1;}
  to {opacity: 0;}
}
.fadeIn {
  animation: fadeIn;
  animation-duration: 2s;
}
.fadeOut {
  animation: fadeOut;
  animation-duration: 1s;
}

</style>