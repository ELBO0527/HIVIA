import axios from 'axios';
import Vue from 'vue'
import Vuex from 'vuex'
import ItemsModule from '../store/module/items-module'
import userModule from '@/store/module/users-module.js'

Vue.use(Vuex)


export default new Vuex.Store({
  state: {
    //login & jwt
  
    //item DTO

    //
  },
  mutations: {
    
  },
  actions: {
  },
  modules: {
   a: ItemsModule,
   userModule: userModule
  }
})