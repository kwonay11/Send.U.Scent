// 상단 Nav bar
<template>
  <div id="NavRoot">
    <div class="logo"><router-link to="/">Send.U.Scent</router-link></div>

    <div class="menu-item-rec">
      <a
        class="nav-link dropdown-toggle"
        href="#"
        id="navbarDarkDropdownMenuLink"
        role="button"
        data-bs-toggle="dropdown"
        aria-expanded="false"
      >
        Recommend
      </a>
      <ul
        class="dropdown-menu dropdown-menu-dark mt-3"
        aria-labelledby="navbarDarkDropdownMenuLink"
      >
        <li>
          <div class="drop-item">
            <router-link to="/recommend/perfume">Perfume</router-link>
          </div>
        </li>
        <li>
          <div class="drop-item">
            <router-link to="/recommend/mytest">Test For Me</router-link>
          </div>
        </li>
        <li>
          <div class="drop-item">
            <router-link to="/recommend/deartest">Test For Dear</router-link>
          </div>
        </li>
      </ul>
    </div>

    <div class="menu-item" style="padding: 20px">
      <router-link to="/about">About</router-link>
    </div>

    <div class="menu-item">
      <a
        class="nav-link dropdown-toggle"
        href="#"
        id="navbarDarkDropdownMenuLink"
        role="button"
        data-bs-toggle="dropdown"
        aria-expanded="false"
      >
        Community
      </a>

      <ul
        class="dropdown-menu dropdown-menu-dark mt-3"
        aria-labelledby="navbarDarkDropdownMenuLink"
      >
        <li>
          <div class="drop-item">
            <router-link to="/notice">Notice</router-link>
          </div>
        </li>
      </ul>
    </div>
    <div v-if="isLogin" class="menu-item" style="padding: 20px">
      <router-link to="/mypage"
        ><img
          src="@/assets/icons/mypage-btn.png"
          alt="mypage"
          style="width: 1vw"
      /></router-link>
    </div>

    <div
      v-if="isLogin"
      class="menu-item"
      style="margin-right: 2vw; padding: 20px"
    >
      <img
        src="@/assets/icons/Logout-btn.png"
        alt="logout"
        style="width: 1.2vw"
        @click="logoutChk()"
      />
    </div>
    <div v-else class="menu-item" style="margin-right: 2vw; padding: 20px">
      <router-link to="/login"
        ><img
          src="@/assets/icons/Login-btn.png"
          alt="login"
          style="width: 1.4vw"
      /></router-link>
    </div>
  </div>
</template>

<script>
import swal from "sweetalert";
import { mapState, mapMutations } from "vuex";
import http from "../../utils/http-common.js";
export default {
  computed: {
    ...mapState(["isLogin", "userInfo"]),
  },
  created() {
    this.loginChk();
  },
  methods: {
    loginChk() {
      if (localStorage.getItem("user_id") === null) {
        this.$store.commit("setIsLogined", false);
      } else {
        this.$store.commit("setIsLogined", true);
        this.getUser();
      }
    },
    logoutChk() {
      this.$store.dispatch("logout").then(() => {
        if (this.$route.path !== "/") this.$router.replace("/");
      });
    },
    getUser() {
      this.user_id = localStorage.getItem("user_id");
      http
        .get("/user/info", { params: { user_id: this.user_id } })
        .then((res) => {
          if (res.data.result === "success") {
            this.$store.commit("setUserInfo", res.data.user);
          } else {
            swal("에러가 발생했습니다.");
          }
        })
        .catch(() => {
          swal("에러 발생!");
        });
    },
  },
  data() {
    return {};
  },
};
</script>

<style lang="scss" scoped>
@import "../../styles/common.scss";

#NavRoot {
  background-color: #78949d;
  display: flex;
  align-items: center;
  justify-content: flex-end;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 10000;
  box-shadow: 1px 1px 7px 3px rgba(129, 127, 127, 0.849);
}
#NavRoot .logo a {
  font-family: $eng-font-family;
  font-size: $title-font-size;
  font-weight: bold;
  margin-left: 2vw;
  font-size: 2vw;
  text-decoration: none;
  position: absolute;
  top: 1.5vh;
  left: 0vw;
}
#NavRoot .menu-item {
  font-family: $eng-font-family;
  padding-top: 0.8%;
  padding-bottom: 0.8%;
  position: relative;
  text-align: center;
  border-bottom: 5px solid transparent;
  transition: 0.4s;
}

#NavRoot .menu-item.active,
#NavRoot .menu-item:hover {
  background-color: #4f4f4f;
  border-bottom-color: #ddc9c6;
}
#NavRoot .menu-item a {
  /* color: inherit; */
  text-decoration: none;
}
#NavRoot .drop-item {
  position: relative;
  text-align: center;
}
#NavRoot .drop-item.active,
#NavRoot .drop-item:hover {
  background-color: #ddc9c6;
  color: #4f4f4f;
}

#NavRoot .drop-item a {
  text-decoration: none;
}

#NavRoot a {
  //   font-weight: bold;
  color: white;
}

#NavRoot .menu-item a.router-link-exact-active {
  color: #ddc9c6;
}

.dropdown-toggle::after {
  // 삼각형
  display: none;
}

.dropdown-menu-dark {
  background-color: #4f4f4f;
}
.menu-item .dropdown-menu {
  z-index: 1000;
  min-width: 6rem;
  border-radius: 0;
  padding: 6%;
}

// 추천
#NavRoot .menu-item-rec {
  font-family: $eng-font-family;
  padding-top: 0.8%;
  padding-bottom: 0.8%;
  padding-left: 0.4%;
  padding-right: 0.4%;
  position: relative;
  text-align: center;
  border-bottom: 5px solid transparent;
  transition: 0.4s;
}
#NavRoot .menu-item-rec.active,
#NavRoot .menu-item-rec:hover {
  background-color: #4f4f4f;
  border-bottom-color: #ddc9c6;
}
#NavRoot .menu-item-rec a {
  /* color: inherit; */
  text-decoration: none;
}
#NavRoot .drop-item {
  position: relative;
  text-align: center;
}
#NavRoot .drop-item.active,
#NavRoot .drop-item:hover {
  background-color: #ddc9c6;
  color: #4f4f4f;
}

#NavRoot .drop-item a {
  text-decoration: none;
}

#NavRoot a {
  //   font-weight: bold;
  color: white;
}

#NavRoot .menu-item-rec a.router-link-exact-active {
  color: #ddc9c6;
}

.dropdown-toggle::after {
  // 삼각형
  display: none;
}

.dropdown-menu-dark {
  background-color: #4f4f4f;
}
.menu-item-rec .dropdown-menu {
  z-index: 1000;
  min-width: 7.5rem;
  border-radius: 0;
  padding: 6%;
}
</style>
