// 공지사항, 문의하기 게시판 목록
<template>
  <div id="BoardListRoot">
    <!-- <h1>공지사항목록들</h1> -->
    {{ notices }}
    <ul class="list-group list-group-flush">
      <li class="list-group-item">An item</li>
      <li class="list-group-item">A second item</li>
      <li class="list-group-item">A third item</li>
      <li class="list-group-item">A fourth item</li>
      <li class="list-group-item">And a fifth one</li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      notices:[]
    }
  },
  beforeCreate() {
    
    console.log("공지사항 목록들 디스패치");
    
    axios
      .get("http://localhost:8888/suscent/api/notices/") // user_id, password
      .then((res) => {
        console.log(res)
        console.log("목록 소환 성공");
        this.notices = res.data
        
      })
      .catch(() => {
        console.log("목록을 못 불러왔음");
      });
    
  },
  name: "BoardListView",
};
</script>

<style scoped>
h1 {
  margin-top: 200px;
}
</style>
