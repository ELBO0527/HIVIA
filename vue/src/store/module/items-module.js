import axios from 'axios'
import userModule from '@/store/module/users-module.js'

const state = { 
    items: [],
    item: "",

    //item DTO
    brand: "",
    name : "",
    color : "",
    country : "",
    price: "",
    size: "",
    stock: "",
    stars: ""
    
};

const getters = { 
    itemsList: state => state.items,
    updateitem : state => state.item,
};

const actions = { 
    
    async fetchItems({commit}){
    const getData = JSON.parse(localStorage.getItem("vuex"));
    const token = getData.userModule.accessToken;
      const response = await axios.get("/item/user/", { headers: { "X-AUTH-TOKEN" : token
      }});
    console.log(response.data.list)
    commit("setItems", response.data.list)
    },
    async fetchOneItem({commit},id){
    const getData = JSON.parse(localStorage.getItem("vuex"));
    const token = getData.userModule.accessToken;
    const response = await axios.get(`/item/user/${id}`,{ headers: { "X-AUTH-TOKEN" : token
    }})
        console.log(response.data.data.name)
        commit("setOneItem", response.data.data)
    },
    async addItems({commit}, item){
        const getData = JSON.parse(localStorage.getItem("vuex"));
        const token = getData.userModule.accessToken;
      const response = await axios.post("/item/", item, { headers: { "X-AUTH-TOKEN" : token
    }});
      alert(response.data)
      commit("addNewItem", response.data.list)
    },
    async updateItem({commit}, id, item){
        const getData = JSON.parse(localStorage.getItem("vuex"));
        const token = getData.userModule.accessToken;
        const response = await axios.put(`/item/${id}`, item, { headers: { "X-AUTH-TOKEN" : token
    }})
        console.log(response)
        console.log(id)
        console.log(response.data)
      
        commit("updateItem", response.data.data, id)
    },
    async deleteItem({commit}, id){
        const getData = JSON.parse(localStorage.getItem("vuex"));
        const token = getData.userModule.accessToken;
      await axios.delete(`/item/${id}`, { headers: { "X-AUTH-TOKEN" : token
    }});
      commit("removeItem", id)
    }
};

const mutations = { 
    setItems: (state, items) => (
        state.items = items
    ),
    setOneItem: (state, item) => (
        state.item = item,
        console.log(state.item.name)
    ),
    addNewItem: (state, item) => state.items.unshift(item),
    updateItem: (state, item) =>{
        state.items.filter(item => item.id !== id),
        state.items.unshift(item)
    }
    ,
    removeItem: (state, id) => (
        state.items.filter(item => item.id !== id),
        state.items.splice(item => item.id, 1)
    )
};

export default {
    state,
    getters,
    actions,
    mutations
}