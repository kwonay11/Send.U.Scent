// 404 Not Found 페이지
<template>
    <div id="NotFoundRoot">
        <div class="nf-box shadow-lg">
            <div class="content-left">
                <p class="title">Oops!</p>
                <p class="content-text">
                    이런, 찾으려는 주소가 맞나요? <br>
                    요청한 페이지를 찾을 수 없어요 :( <br>
                </p>
                <div class="btn-box">
                    <router-link to="/" class="go-btn">메인 페이지로</router-link>
                </div>
            </div>
            <div class="content-right">
                <img src="../assets/images/not-found.jpg" alt="404 Not Found">
            </div>
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
@import "../styles/common.scss";
* {
    font-family: $kor-font-family;
}
#NotFoundRoot {
    width: 100%;
    height: 100%;
    overflow: hidden;
    position: absolute;
    top: 0;
    left: 0;
    background: $main-color;
}
.nf-box {
    width: 80vw;
    max-width: 900px;
    height: 60vh;
    background: white;
    position: relative;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    align-content: center;
    justify-content: flex-end;
    align-items: center;
    padding: 20px;
}
.content-left {
    width: 40%;
    text-align: left;
}
.title {
    font-size: 6em;
    font-weight: 800;
}
.content-text {
    font-size: 1.4em;
}
.btn-box {
    width: 140px;
    height: 40px;
    background: $point-color;
    border-radius: 50px;
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    align-content: center;
    justify-content: center;
    align-items: center;
}
.btn-box:hover {
    background: $heart-color;
}
.go-btn {
    font-size: $body-font-size;
    color: $white-color;
}
.content-right {
    width: 50%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
}
.content-right > img {
    width: 100%;
    height: 80%;
}
</style>