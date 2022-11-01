import axios from 'axios';
import Vue from 'vue'
import Vuex from 'vuex'
import ItemsModule from '../store/module/items-module'
import userModule from '@/store/module/users-module.js'
import createPersistedState from "vuex-persistedstate"
import CartModule from './module/cart-module';

Vue.use(Vuex)


/*
const storageState = createPersistedState({
  paths: ['userModule']
});
*/

export default new Vuex.Store({
  state: {
    //drawer
    drawer : false,
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
   userModule: userModule,
   b: CartModule
  },
  plugins: [createPersistedState({userModule})]
})