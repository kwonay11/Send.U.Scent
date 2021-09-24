module.exports = {
  publicPath: "/",
  devServer: {
    proxy: {
      "/api": {
        target: "http://localhost:8000/"
      }
    }
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
