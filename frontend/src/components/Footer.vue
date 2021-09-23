// Footer
<template>
    <div id="FooterRoot">
        <div class="footer-box">
            <p class="logo">Send.U.Scent</p>
            <p class="info"><router-link to="/about">서비스소개 &nbsp;|&nbsp; 팀소개&nbsp;| &nbsp;</router-link>
            사이트맵</p>
            <p class="team">Developed by TEAM. C204</p>
        </div>
    </div>
</template>

<script>
export default {
    name:'Footer',

}
</script>


<style lang="scss" scoped>
@import "@/styles/common.scss";

#FooterRoot{
    background:#242424;
    height:200px;
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
}
.footer-box {
    width: 100%;
    height: 100%;
}
.logo{
    font-family: $eng-font-family;
    font-size: $title-font-size;
    font-weight: bold;
    color:#78949D;
    padding-top: 5vh;
    padding-left: 5vh;
    font-size: 30px;
    // height: 100px;
    display: flex;
    font-weight: bold;
}
.info{
    font-family:$kor-font-family;
    font-size:$smallest-font-size;
    color:white;
    margin-left: 5vh;
    margin-top: -2vh;;
    // height: 100px;
    display: flex;
    
}
.info a{
    color:white;
    text-decoration: none;
}
.team{
    font-family: $eng-font-family;
    font-size: $detail-font-size;
    color:white;
    // margin: -4vh;
    margin-top: 45px;
 
}

</style>