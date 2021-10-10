// 추천 및 내가 가진, 관심 목록에 들어갈 향수 정보 하나
<template>
    <div id="SimpleProdRoot">
        <!-- 관심 목록에서는 좋아요 on, off -->
        <div class="like-btn-group" v-if="listIs==='like'">
            <button v-if="likeActive" class="like-on-btn" @click.stop="cancelLike(this.id, this.name)">
                <img src="@/assets/icons/heart-on-btn.png">
            </button>
            <button v-if="!likeActive" class="like-on-btn" @click.stop="addLike(this.perfume_id)">
                <img src="@/assets/icons/heart-off-btn.png">
            </button>
        </div>
        <!-- 가지고 있는 목록에서는 목록 추가, 제거 -->
        <div class="like-btn-group" v-if="listIs==='have'">
            <button class="have-btn" @click.stop="cancelHave(this.id, this.name)">
                <i class="fas fa-minus-square"></i>
            </button>
        </div>
        <!-- 보유 향수 검색일 때 -->
        <div v-if="listIs === 'search'">
            <div class="item-img">
                <img :src="`https://fimgs.net/mdimg/perfume/375x500.${this.perfume_id}.jpg`" :alt="this.name">
            </div>
            <span class="item-name" @click.stop="goToDetail(this.perfume_id)">{{this.name}}</span>
        </div>
        <div v-else>
            <div class="item-img">
                <img :src="`https://fimgs.net/mdimg/perfume/375x500.${this.perfume_id}.jpg`" :alt="this.name">
            </div>
            <span class="item-name" @click.stop="goToDetail(this.perfume_id)">{{this.name}}</span>
        </div>
    </div>
</template>

<script>
import swal from 'sweetalert';
import http from '../utils/http-common.js'
import { mapState } from 'vuex';
export default {
    props : [
        "id",
        "name",
        "perfume_id",
        "listIs",
    ],
    computed: {
        ...mapState(["userInfo"])
    },
    methods: {
        cancelLike(id, name) {
            http.delete('/like/delete', { params : {id : id}})
                .then((res) => {
                    if(res.data.result === "success") {
                        this.likeActive = false
                    } else {
                        swal("데이터를 처리하던 중 문제가 발생했습니다.")
                    }
                })
        },
        addLike(v) {
            const Form = {
                "user_id" : this.userInfo.id,
                "perfume_id" : v
            }
            http.post('/like/insert', Form)
                .then((res) => {
                    if(res.data.result === "success") {
                        this.likeActive = true
                        this.$router.go()
                    } else {
                        swal("데이터를 처리하던 중 문제가 발생했습니다.")
                    }
                })
        },
        cancelHave(id, name) {
            if(confirm("삭제 시 모든 기록이 삭제됩니다. 삭제하시겠습니까?")) {
                http.delete('/have/delete', { params : {id : id}})
                    .then((res) => {
                        if(res.data.result === "success") {
                            swal(name + " 향수를 가지고 있는 목록에서 삭제했습니다.")
                            this.$router.go()
                        } else {
                            swal("데이터를 처리하던 중 문제가 발생했습니다.")
                        }
                    })
            }
        },
        goToDetail(v) {
            this.$router.push(`/recommend/detail/${v}`)
        },
    },
    data() {
        return {
            likeActive: true,
        }
    },
}
</script>

<style lang="scss" scoped>
@import "../styles/common.scss";
span, p {
  font-family: $kor-font-family;
}
#SimpleProdRoot {
    width: 100%;
    display: flex;
    flex-direction: column;
    flex-wrap: nowrap;
    align-content: center;
    justify-content: center;
    align-items: center;
}
.item-list {
    width: 910px;
    margin: 0 auto;
}
.item {
    width: 150px;
    display: inline-block;
}
.item-img {
    width: 110px;
    height: 130px;
    margin: 0 auto;
}
.item-img > img {
    width: 100%;
    height: 100%;
}
.item-name {
    font-size: $body-font-size;
}
.like-btn-group {
    position: relative;
    right: -40px;
    top: 20px;
}
.like-on-btn, .have-btn {
    background: none;
    border: none;
    width: 35px;
    height: 25px;
}
.like-on-btn > img {
    width: 100%;
}
.have-btn {
    font-size: $body-font-size;
    color: $point-color;
}
</style>