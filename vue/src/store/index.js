import axios from 'axios';
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)


export default new Vuex.Store({
  state: {
    //login & jwt
  
    //item DTO
  name:"",
  brand : "",
  color :"",
  country:"",
  price : "",
  size:"",
  stock: "" ,
  stars : "",
    //
  items:[],

    //
  },
  mutations: {
    setItem(state, payload){
      state.name = payload;
      state.brand = payload;
      state.color = payload;
      state.country = payload;
      state.price = payload;
      state.size = payload;
      state.stock = payload;
      state.stars = payload;    
    },
    setItems(state,payload){
      state.items = payload;
    }
   
  },
  actions: {
    async getAllItems({commit}){

    }
  },
  modules: {
  }
})