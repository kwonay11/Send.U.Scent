// 공지사항, 문의하기 글쓰기
<template>
  <div id="WriteFormRoot">
    <form>
      <div class="mb-3">
        <label class="form-label">제목</label>
        <input v-model="title" type="text" class="form-control" />
      </div>
      <div class="mb-3">
        <label class="form-label">내용</label>
        <input
          v-model="contents"
          id="content-form"
          type="text"
          class="form-control"
        />
      </div>

      <button
        type="button"
        class="btn btn-primary"
        @click.self.prevent="write({ user, title, contents })"
      >
        생성
      </button>
    </form>
  </div>
</template>

<script>
import axios from "axios";
import router from "../../router/index";

export default {
  name: "WriteForm",
  data() {
    return {
      user: "admin",
      title: "",
      contents: "",
    };
  },
  methods: {
    write(writeObj) {
      axios
        .post("https://j5c204.p.ssafy.io/suscent/api/notices/write/", writeObj) // user_id, password
        .then((res) => {
          console.log("생성 성공");
          // console.log(res);
          router.push({ name: "BoardListView" });
        })
        .catch(() => {
          console.log("실패");
        });
    },
  },
};
</script>

<style lang="scss" scoped>
#content-form {
  height: 300px;
}
</style>
