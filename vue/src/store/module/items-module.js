import axios from 'axios'

const state = { 
    items: []
};

const getters = { 
    itemsList: state => state.items
};

const actions = { 
    async fetchItems({commit}){
      const response = await axios.get("/item/user");
      console.log(response.data.list)
      commit("setItems", response.data.list)
    },
    async fetchOneItem({commit,id}){
        const response = await axios.get(`item/user/${id}`)
        console.log(response.data.list)
        commit("setOneItem", response.data.list)
    },
    async addItems({commit}, item){
      const response = await axios.post("/item/", item, { headers : {"X-AUTH-TOKEN" : "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzOSIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2NTQ1OTY3MTIsImV4cCI6MTY1NDYwMDMxMn0.CdeUsu1ZqDZZq0Q2XvJCQZ562YKoElW67YoqDyCEOpY"}});
      alert(response.data)
      commit("addNewItem", response.data.list)
    },
    async deleteItem({commit}, id){
      await axios.delete(`/item/${id}`, { headers : {"X-AUTH-TOKEN" : "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzOSIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2NTQ1OTY3MTIsImV4cCI6MTY1NDYwMDMxMn0.CdeUsu1ZqDZZq0Q2XvJCQZ562YKoElW67YoqDyCEOpY"}});
      commit("removeItem", id)
    }
};

const mutations = { 
    setItems: (state, items) => (
        state.items = items
    ),
    setOneItem: (state, id) => (
        state.items.findindex(item => item.id == id)
    ),
    addNewItem: (state, item) => state.items.unshift(item),
    updateItem: (state,item, id) => state.items.unshift(item => item.id !==id),
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