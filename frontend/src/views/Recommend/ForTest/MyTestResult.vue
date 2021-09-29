// 테스트 결과 페이지
<template>
    <div id="TestResultRoot">

    <div class="box">
        <div class="title">Send you your Scent</div>
        <div class="subtitle">000님에게 어울리는 향수는,</div>
        <div class="wordcloud">
            <img src="@/assets/images/perfume3.png" alt="" class="my-2" style="width:58%;">
            <tags-ball class="ball" v-bind:style='{"border":"0px black"}' :tags='accords_list'/>
            <!-- <div class="ac_dec">

            <div v-for="(value,idx) in accords" v-bind:key="idx">
                <div>{{idx}}:{{value}}회</div>
                </div>
            </div> -->
          
        </div>

   
   
        <div class="dec"> 회원님이 좋아하실 만한 향수들이에요.</div>
        <div class="perfume">
   
            <div  v-for="(value,idx) in perfume_id" v-bind:key="idx">
                <router-link to="`/recommend/detail/${value}`">
                <img class="img" :src="`https://fimgs.net/mdimg/perfume/375x500.${value}.jpg`" alt="perfume-image">
                 <div class="perfume_title">{{title[idx]}}</div>
                </router-link>
            </div>
        </div>
        <div class="dec2"> 회원님과 비슷한 취향의 다른 사용자들이 선택한 향수들이에요.</div>
        <div class="perfume2">
            <div  v-for="(value,idx) in perfume_id2" v-bind:key="idx">
                    <router-link :to="`/recommend/detail/${value}`">
                    <img class="img" :src="`https://fimgs.net/mdimg/perfume/375x500.${value}.jpg`" alt="perfume-image">
                    <p class="perfume_title">{{title2[idx]}}</p>
                    </router-link>
                    <div @click="modal()">
                        <img v-if="!setModal" src="@/assets/icons/heart-on-btn.png" alt="hert-on">
                        <img v-else src="@/assets/icons/heart-off-btn.png" alt="hert-off">
                    </div>
                        <ModalLike v-if="setModal" @flag="closeModal" :id="`${value}`" :name="`${title2[idx]}`"/>
                </div>
          
        </div>
     </div>
    </div>

    
</template>


<script>
import TagsBall from 'vue-tags-ball'
import axios from "axios"
import ModalLike from '@/components/ModalLike.vue';
const DJANGO_URL = process.env.VUE_APP_DJANGO_URL
export default {
    name:'TestResult',
    components: {
        ModalLike,
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
        axios.get(`${DJANGO_URL}/scent/tests/getresult/`)
        .then((res)=>{
            console.log(res.data)
            console.log("데이터 받아옴")
            // console.log(res.data.perfume_id)
            this.perfume_id = res.data.perfume_id
            this.title = res.data.title
            this.perfume_id2 = res.data.perfume_id2
            this.title2 = res.data.title2
            this.accords = res.data.accords
            this.accords_len = Object.keys(this.accords).length
            this.accords_list = Object.keys(this.accords)
            console.log(this.accords_list)

            for (let i = 0; i < this.accords_len; i++) {

                const name = Object.keys(this.accords)[i]
                const count = Object.values(this.accords)[i]
                // console.log(name)
                // console.log(count)
                 
            }
           
        

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
    top: 13%;
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
    font-size:$detail-font-size;
 
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
   
    margin-left:10%;
    position:absolute;
    top:50%;
    padding: 2px;

}


</style>