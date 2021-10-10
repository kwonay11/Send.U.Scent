// Footer
<template>
    <div id="FooterRoot">
        <div class="footer-box">
            <p class="logo">Send.U.Scent</p>
            <p class="info"><router-link to="/about">서비스소개</router-link></p>
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
    height:28vh;
}
.logo{
    font-family: $eng-font-family;
    font-size: $title-font-size;
    font-weight: bold;
    color:#78949D;
    padding-top: 5vh;
    padding-left: 5vh;
    font-size: 30px;
    display: flex;
    font-weight: bold;
}
.info{
    font-family:$kor-font-family;
    font-size:$smallest-font-size;
    color:white;
    margin-left: 5vh;
    margin-top: -2vh;;
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
    margin-top: 45px;
 
}

</style>