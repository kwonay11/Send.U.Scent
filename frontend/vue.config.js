module.exports = {
  publicPath: "/",
  devServer: {
    port: 3000, // 3000포트에서 vue 개발 서버를 실행. sts와 8080 겹침
    // proxy: {
    //   "/api": {
    //     target: "http://localhost:8000/"
    //   }
    // }
  },
  css: {
    loaderOptions: {
      sass: {
        additionalData: `
          @import "@/styles/common.scss";
        `
      }
    }
  },
};
