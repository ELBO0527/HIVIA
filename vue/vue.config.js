module.exports = {
  lintOnSave: false,
  outputDir: "../src/main/resources/static",
  indexPath: "../static/index.html",
  devServer: {
    proxy: "http://localhost:8081"
  },
  transpileDependencies: ["vuetify"]
};
