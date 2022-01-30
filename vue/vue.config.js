module.exports = {
  lintOnSave: false,
  outputDir: "../src/main/resources/static",
  indexPath: "../static/index.html",
  devServer: {
    proxy: {
      // 프록시 요청을 보낼 api의 시작 부분
      "/api": {
        // 프록시 요청을 보낼 서버의 주소
        target: "http://localhost:3000"
      }
    },
    overlay: false // 여기서 overlay: false는 오류를 더이상 화면에 표시하지 않겠다는 말임.
  },
  transpileDependencies: ["vuetify"]
};
