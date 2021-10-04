// 관심목록 리스트 페이지
<template>
    <div id="WantListRoot">
        <page-title pageTitle="I want" />
            <div class="content-box mt-5 my-3">
                <p class="body-title">회원님이 관심을 가진 향수에요</p>
            <div class="have-list">
                <ul class="item-list">
                    <li class="item m-3"  v-for="(item, index) in wantList" :key="index">
                    <Prod :id="item.id" :perfume_id="item.perfume_id" :name="item.title" @click.prevent="addHave(item.perfume_id, item.title)"/>
                    </li>
                </ul>
            </div>
        </div>
        <Modal v-if="setModal" @flag="closeModal" :id="this.selectedProd.id" :name="this.selectedProd.title"/>
        <go-top />
    </div>
</template>

<script>
import PageTitle from '../../components/Header/PageTitle.vue';
import Prod from '../../components/SimpleProd.vue';
import Modal from '../../components/Modal.vue';
import GoTop from '../../components/GoTop.vue';
import http from '../../utils/http-common.js'
import { mapState } from 'vuex';
export default {
    name: "WantList",
    components: {
        PageTitle,
        Prod,
        Modal,
        GoTop,
    },
    computed: {
        ...mapState(["userInfo"])
    },
    created() {
        this.user_No = this.userInfo.id;
        this.getList();
        this.getHaveList();
    },
    methods: {
        getList() {
            http
            .get("/like/list", { params: { user_id : this.user_No}})
            .then((res) => {
                if(res.data.result === "success") {
                this.wantList = res.data.wantlist
                // console.log(this.haveList)
                } else {
                alert("!데이터를 불러오는데 문제가 발생했습니다.")
                }
            })
        },
        getHaveList() {
            http
            .get("/have/list", { params: { user_id : this.user_No}})
            .then((res) => {
            if(res.data.result === "success") {
                this.haveList = res.data.havelist
                // console.log(this.haveList)
            } else {
                alert("!데이터를 불러오는데 문제가 발생했습니다.")
            }
            })
        },
        addHave(perfume_id, title) {
            // alert(id + "번 향수 리뷰");
            for (let i = 0; i < this.haveList.length; i++) {
                if(perfume_id === this.haveList[i].perfume_id) {
                    // 보유 목록에 이미 있으면
                    alert("이미 보유 중인 향수입니다.")
                    return;
                }
            }
            this.setModal = true;
            this.selectedProd.id = perfume_id;
            this.selectedProd.title = title;
            console.log(this.selectedProd)
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
                title: String,
            },
            wantList : [],
            haveList: [],
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