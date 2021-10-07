// 게시글 하나. QnA 일 때는 답변 div가 보여야 함
<template>
  <div id="WriteFormRoot">
    <form>
      <div class="mb-3">
        <label class="form-label">제목</label>
        <input
          :placeholder="this.noticeInfo.title"
          v-model="title"
          type="text"
          class="form-control"
        />
      </div>
      <div class="mb-3">
        <label class="form-label">내용</label>
        <input
          :placeholder="this.noticeInfo.contents"
          v-model="contents"
          id="content-form"
          type="text"
          class="form-control"
        />
      </div>

      <button
        type="button"
        class="btn btn-primary"
        @click.self.prevent="modify({ user, title, contents })"
      >
        수정완료
      </button>
      <button
        type="button"
        class="btn btn-danger"
        @click.self.prevent="goBack()"
      >
        취소
      </button>
    </form>
  </div>
</template>

<script>
import axios from "axios";
import router from "../../router/index";

export default {
  name: "ModifyForm",
  data() {
    return {
      noticeInfo: {},
      user: "admin",
      title: "",
      contents: "",
    };
  },
  methods: {
    modify(writeObj) {
      axios
        .put("http://localhost:8888/suscent/api/notices/modify/", writeObj) // user_id, password
        .then((res) => {
          console.log("생성 성공");
          // console.log(res);
          router.push({ name: "BoardListView" });
        })
        .catch(() => {
          console.log("실패");
        });
    },
    goBack() {
      window.history.back();
    },
    getNoticeInfo(notice_id) {
      axios
        .get(`http://localhost:8888/suscent/api/notice/${notice_id}`)
        .then((res) => {
          console.log(res);
          console.log("특정 공지 정보");
          console.log(res.data);
          this.noticeInfo = res.data;
          console.log(this.noticeInfo);
        })
        .catch(() => {
          console.log("공지를 못 불러왔음");
        });
    },
  },
  created() {
    console.log(this.$route.params.id);
    const notice_id = parseInt(this.$route.params.id) + 1;
    console.log(notice_id);
    this.getNoticeInfo(notice_id);
  },
};
</script>

<style lang="scss" scoped>
#content-form {
  height: 300px;
}
</style>
