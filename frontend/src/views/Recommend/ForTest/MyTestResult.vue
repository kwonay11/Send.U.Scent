// 테스트 결과 페이지
<template>
    <div id="TestResultRoot">

    <div class="box">
        <div class="title fadeIn">Send you your Scent</div>
        <div class="subtitle fadeIn">{{$store.state.userInfo.nickname}}님에게 어울리는 향수에 대한
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

   
   
        <div class="dec fadeIn">{{$store.state.userInfo.nickname}}님이 좋아하실 만한 향수들이에요.</div>
        <div class="perfume">
            <div  v-for="(value,idx) in perfume_id" v-bind:key="idx">
                    <router-link :to="`/recommend/detail/${value}`">
                    <img class="img" :src="`https://fimgs.net/mdimg/perfume/375x500.${value}.jpg`" alt="perfume-image">
                    <p class="perfume_title">{{title[idx]}}</p>
                    </router-link>
                    
                </div>
           
            
        </div>

        <div class="dec2 fadeIn">{{$store.state.userInfo.nickname}}님과 비슷한 취향의 다른 사용자들이 선택한 향수들이에요.</div>
         <div class="perfume2">
            <div  v-for="(value,idx) in perfume_id2" v-bind:key="idx">
                    <router-link :to="`/recommend/detail/${value}`">
                    <img class="img" :src="`https://fimgs.net/mdimg/perfume/375x500.${value}.jpg`" alt="perfume-image">
                    <p class="perfume_title">{{title2[idx]}}</p>
                    </router-link>
                    
                </div>
          
        </div>
     </div>

     <go-top />
    </div>

    
</template>


<script>
import TagsBall from 'vue-tags-ball'
import axios from "axios"
import GoTop from '@/components/GoTop.vue';
import http from '../../../utils/http-common.js'
import { mapState } from 'vuex'
const DJANGO_URL = process.env.VUE_APP_DJANGO_URL
export default {
    name:'TestResult',
    components: {
      
        GoTop,
        "tags-ball":TagsBall
    
     
    },
    computed: {
        ...mapState(["isLogin"])
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
    

            accords_list : [],
            sorted_list : [],


            best_accord:[],
            best_accord1:'',
            best_accord2:'',
            best_accord3:'',
            best_accord4:'',
            best_accord5:'',
           

        }
    },
   
    methods:{
        updateRes() {
            // 회원일 때만 결과 저장해서 내 정보 업데이트
            if(this.isLogin) {
                const accords = localStorage.getItem("accords")
                const accord = accords.split(",")
                const Form = {
                    "user_id" : localStorage.getItem("user_id"),
                    "accord1" : accord[0],
                    "accord2" : accord[1],
                    "accord3" : accord[2],
                    "accord4" : accord[3],
                    "accord5" : accord[4],
                    "longevity" : localStorage.getItem("longevity"),
                    "silage" : localStorage.getItem("sillage"),
                    "season" : localStorage.getItem("season")
                }
                http.put('user/update/myscent', Form)
                    .then((res) => {
                        if(res.data.result === "success") {
                            console.log("저장 완료")
                        } else {
                            console.log("저장 실패")
                        }
                    })
                    .catch(() => {
                        console.log("axios 오류")
                    })
            } else {
                // 비회원일 땐 바로 결과 지워버림
                localStorage.removeItem("accords");
                localStorage.removeItem("longevity");
                localStorage.removeItem("sillage");
                localStorage.removeItem("season");
            }
        }
    
       
    },
    created(){
        axios.get(`${DJANGO_URL}/tests/getresult/`)
        .then((res)=>{
            // console.log(res.data)
            // console.log("데이터 받아옴")
            this.perfume_id = res.data.perfume_id
            this.title = res.data.title
            this.perfume_id2 = res.data.perfume_id2
            this.title2 = res.data.title2
            this.accords = res.data.accords
            this.sorted_list = res.data.sorted_accords
            



            this.best_accord1 = this.sorted_list[0][0];
            this.best_accord2 = this.sorted_list[1][0];
            this.best_accord3 = this.sorted_list[2][0];
            this.best_accord4 = this.sorted_list[3][0];
            this.best_accord5 = this.sorted_list[4][0];
 

            this.best_accord.push(this.best_accord1)
            this.best_accord.push(this.best_accord2)
            this.best_accord.push(this.best_accord3)
            this.best_accord.push(this.best_accord4)
            this.best_accord.push(this.best_accord5)

        
            localStorage.setItem("accords", this.best_accord),


            this.accords_list = Object.keys(this.accords)
        
            this.updateRes()
        })
        .catch(()=>{
            console.log("데이터 못받음")

        })
    
    }
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
    margin-left:1vw;
    margin-right:0.5vw;
    

    
    
}
.img{
    width: 54%;
    float: left;
    margin-left:0.5vw;
    margin-right:0.5vw;
    display:block;
    margin-bottom:1vh ;
    
}

.perfume_title{
     width:59%;
    color:black;
    font-family:$eng-font-family;
    font-size:$detail-font-size;
 
    display:block;
   
    

    
}
.ball{
    width: 30%;
    position: absolute;
    left:36%;
    top:41%;
    z-index: 22;
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