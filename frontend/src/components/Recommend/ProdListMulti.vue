// ProdList 에 들어 갈 상품 하나
<template>
    <div id="ProdOneRoot">
        <div class="perfume-page">
            <div class="perfume-container"> 
                <div class="perfume-list"> 
                <p class="counts"> &#10003; 총 {{this.counts}}개 향수 검색</p>    
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
                <div class="btn-cover">
                        <p></p>
                        <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">이전</button>
                        <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
                        <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn2">다음</button>
                </div>
           </div>  
        </div>                   
        </div>   
</template>

<script>
export default {
    data(){
        return {
            pageNum: 0,
            //counts:0,    
        }        
    },    
    props:{
        results:Array,
        pageSize:{
            type: Number,
            required:false,
            default: 10
        },
        counts:Number,
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
        //sessionStorage.setItem("page",page);
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
.counts{
    text-align: left;
    
}
.perfume-page{
    width: 70%;
    height: 1000px;
    top:50%;
    position: inherit;
    font-family: $kor-font-family;
    padding: 30px;
    margin: 10px 350px 10px 250px;  
    background-color: white;
}
.perfume-container{
    width: 1100px;
    height: 75%;
    font-family: $kor-font-family;
    padding: 20px;
    margin: 29px 200px 10px 100px;  
    
}
.perfume-list{
    margin: 10px;
}
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
// .btn-cover {
//     width: 100%;
//     text-align: center;
//     height: 50px;
// }
.btn-cover .page-btn {
    margin-top: 20px;
    width: 5rem;
    height: 2rem;
    letter-spacing: 0.5px;
    border-radius: 10px;
    background-color:$point-color;  
    border:none;
    color:white; 

}
.btn-cover .page-btn2 {
    margin-top: 20px;
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