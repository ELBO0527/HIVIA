import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import '@mdi/font/css/materialdesignicons.css'
import axios from 'axios';
import VueKakaoSdk from 'vue-kakao-sdk'

Vue.prototype.$axios = axios;
Vue.config.productionTip = false

const apiKey = 	"40b2d36982df1e74ba0f8bc9afa8845f";
new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')

Vue.use(VueKakaoSdk, { apiKey });
