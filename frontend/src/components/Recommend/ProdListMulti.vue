// ProdList 에 들어 갈 상품 하나
<template>
    <div id="ProdOneRoot">
        <div class="perfume-page">
            <div class="perfume-container"> 
                <!-- <div class="accord-filter">
                    <div>ALL</div>
                    <a>ALL | </a>
                    <a>시트러스 | </a>
                    <a>우디 | </a>
                    <a>머스크 | </a>
                    <a>플로랄  </a>                
                </div> -->
                <div class="perfume-list"> 
                    <div class="card-list">
                        
                        <div class="card" v-for="p in paginatedData" :key="p.no">    
                        <router-link :to="`/recommend/detail/${p.perfume_id}`" style="color:black">
                            <img class="img"  :src="`https://fimgs.net/mdimg/perfume/375x500.${p.perfume_id}.jpg`" alt="perfume-image">
                            <br/>
                            <p class="title-txt">{{ p.title }}</p>
                            <p class="brand-txt">{{ p.brand }}</p>                    
                        </router-link>
                        </div>
                    </div>                  
                </div> 
                <br />
            </div>  
                <div class="btn-cover">
                    <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
                        이전
                        </button>
                        <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
                        <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn2" >
                            다음
                    </button>
                </div>
                </div>                   
        </div>   
</template>

<script>
export default {
    data(){
        return {
            pageNum: 0
        }        
    },    
    props:{
        results:Array,
        pageSize:{
            type: Number,
            required:false,
            default: 10
        },
    },
    methods: {
    nextPage () {
        this.pageNum += 1;
    },
    prevPage () {
        this.pageNum -= 1;
    }
    },
    computed: {
        pageCount () {
        let listLeng = this.results.length,
            listSize = this.pageSize,
            page = Math.floor(listLeng / listSize);
        if (listLeng % listSize > 0) page += 1;
        
        /*
        아니면 page = Math.floor((listLeng - 1) / listSize) + 1;
        이런식으로 if 문 없이 고칠 수도 있다!
        */
        sessionStorage.setItem("page",page);
        return page;
        },
        paginatedData () {
        const start = this.pageNum * this.pageSize,
                end = start + this.pageSize;
        return this.results.slice(start, end);
        }
    }        
}
</script>

<style lang="scss" scoped>
@import "@/styles/common.scss";
.perfume-page{
    width: 80%;
    height: 1000px;
    font-family: $kor-font-family;
    padding: 30px;
    margin: 10px 350px 10px 250px;  
    background-color: white;
}
.perfume-container{
    width: 1100px;
    height: 70%;
    font-family: $kor-font-family;
    padding: 30px;
    margin: 2px 200px 10px 110px;  
    
}

// .perfume-list{
//     font-family: $kor-font-family;
//     width: 1300px;
//     padding: 20px;
//     margin: 10px;
// }
.card{
    float: left;
    width:160px;
    height: 300px;
    margin: 20px;
    padding: 10px;
    font-family: $eng-font-family;
    font-size: $detail-font-size;
    // border-color:$main-color;
    border:none;

}

.img{
    width:120px;
    height:200px;
    display: block;
    margin : 0 auto ;
    
}
.btn-cover {
    width: 100%;
    margin-top: 3rem;
    text-align: center;
    height: 50px;
    padding-left: 12%;
    //margin-right: 1.2%;
//   right: 10%;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
  border-radius: 10px;
  background-color:$point-color;  
  border:none;
  color:white; 

}
.btn-cover .page-btn2 {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
  border-radius: 10px;
  background-color:$point-color;  
  border:none;
  color:white;
  
}
.btn-cover .page-count {
  padding: 0 1rem;
}
.title-txt{
    font-weight: bold;
}
.brand-txt{
    font-size: $smallest-font-size;
}
</style>