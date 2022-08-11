import axios from 'axios';
import Vue from 'vue'
import Vuex from 'vuex'
import ItemsModule from '../store/module/items-module'
import userModule from '@/store/module/users-module.js'
import createPersistedState from "vuex-persistedstate"

Vue.use(Vuex)


/*
const storageState = createPersistedState({
  paths: ['userModule']
});
*/

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
  },
  plugins: [createPersistedState()]
})