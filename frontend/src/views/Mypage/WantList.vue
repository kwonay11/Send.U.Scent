// 관심목록 리스트 페이지
<template>
    <div id="WantListRoot">
        <page-title pageTitle="I want" />
            <div class="content-box mt-5 my-3">
                <p class="body-title">회원님이 관심을 가진 향수에요</p>
            <div class="have-list">
                <ul class="item-list">
                    <li class="item m-3"  v-for="(item, index) in wantList" :key="index">
                    <Prod :id="item.id" :imgUrl="item.imgUrl" :name="item.name" @click="addHave(item.id, item.name)"/>
                    </li>
                </ul>
            </div>
        </div>
        <Modal v-if="setModal" @flag="closeModal" :id="this.selectedProd.id" :name="this.selectedProd.name"/>
        <go-top />
    </div>
</template>

<script>
import PageTitle from '../../components/Header/PageTitle.vue';
import Prod from '../../components/SimpleProd.vue';
import Modal from '../../components/Modal.vue';
import GoTop from '../../components/GoTop.vue';
export default {
    name: "WantList",
    components: {
        PageTitle,
        Prod,
        Modal,
        GoTop,
    },
    methods: {
        addHave(id, name) {
            // alert(id + "번 향수 리뷰");
            this.setModal = true;
            this.selectedProd.id = id;
            this.selectedProd.name = name;
        },
        closeModal() {
            this.setModal = false;
        }
    },
    data() {
    return {
        setModal: false,
        selectedProd: {
            id: Number,
            name: String,
        },
        wantList : [
            {
                id: 1,
                imgUrl: '',
                name: 'Perfume_1'
            },
            {
                id: 2,
                imgUrl: '',
                name: 'Perfume_2'
            },
            {
                id: 3,
                imgUrl: '',
                name: 'Perfume_3'
            },
            {
                id: 4,
                imgUrl: '',
                name: 'Perfume_4'
            },
            {
                id: 5,
                imgUrl: '',
                name: 'Perfume_5'
            },
            {
                id: 6,
                imgUrl: '',
                name: 'Perfume_6'
            },
            {
                id: 7,
                imgUrl: '',
                name: 'Perfume_7'
            },
            {
                id: 8,
                imgUrl: '',
                name: 'Perfume_8'
            },
            {
                id: 9,
                imgUrl: '',
                name: 'Perfume_9'
            },
            {
                id: 10,
                imgUrl: '',
                name: 'Perfume_10'
            },
        ]
    }
    },
}
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";
* {
    font-family: $kor-font-family;
}
#WantListRoot {
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
}
.body-title {
    font-size: $body-subtitle-font-size;
    font-weight: bold;
}
.item-list {
    width: 800px;
    margin: 0 auto;
}
.item {
    width: 120px;
    display: inline-block;
}
</style>