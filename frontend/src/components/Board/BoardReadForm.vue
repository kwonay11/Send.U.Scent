// 게시글 하나. QnA 일 때는 답변 div가 보여야 함
<template>
  <div id="BoardReadRoot">
    <div class="title-box">{{ this.noticeInfo.title }}</div>
    <br />
    <div class="contents-box">
      <br />
      {{ this.noticeInfo.contents }}
    </div>
    <br />
    <button type="button" class="btn btn-primary btn-lg" @click="goBack()">
      목록으로
    </button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "BoardRead",
  data() {
    return {
      noticeInfo: {},
    };
  },
  methods: {
    goBack() {
      window.history.back();
    },
    getNoticeInfo(notice_id) {
      axios
        .get(`https://j5c204.p.ssafy.io/suscent/api/notice/${notice_id}`)
        .then((res) => {
          // console.log(res);
          console.log("특정 공지 정보");
          // console.log(res.data);
          this.noticeInfo = res.data;
          // console.log(this.noticeInfo);
        })
        .catch(() => {
          console.log("공지를 못 불러왔음");
        });
    },
  },
  created() {
    const notice_id = parseInt(this.$route.params.id) + 1;
    // console.log(notice_id);
    this.getNoticeInfo(notice_id);
  },
};
</script>

<style lang="scss" scoped>
#BoardReadRoot {
  font-size: 25px;
  .title-box {
    border-bottom: 1px solid rgb(92, 92, 92);

    width: 100%;
    height: 50px;
  }
  .contents-box {
    border: 1px solid rgb(92, 92, 92);

    width: 100%;
    height: 300px;
  }
}
</style>
