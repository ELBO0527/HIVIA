import axios from 'axios'
import router from '@/router'

const userModule = {
    state : {
        id : "",
        accessToken : ""
    },
    getters : {
        isLogin(state){
            return state.accessToken == '' ? false : true;
        }
    },
    mutations : {
       setId(state, id){
        state.id = id;
       },
       setAccessToken(state, accessToken){
        state.accessToken = accessToken;
       },
       reset(state){
            state.id = '',
            state.accessToken = ''
       }
    },
    actions : {
        //로그인
        async doLogin({commit}, saveData){
            let result = false;
            let resultErr = null;
            try{
                let res = await axios.post("/sign/signin", saveData);
                if(res.data.sucess == true){
                    console.log("성공");
                    commit('setId', saveData.id);
                    commit('setAccessToken', res.data.data);
                    result = true;
                } else{
                    console.log("실패");
                    let err = new Error("401");
                    err.response = {data:{"success": false, "errormessage": "실패"}}
                    resultErr = err;
                }
            }catch(err){
                console.log(err);
            }
        },
        doLogout({commit}){
            commit('reset');
        }
    }
}

const state = { 
    users: [],
    alert: false    
};

const getters = { 
};

const actions = { 
    async fetchItems({commit}){
      const response = await axios.get("/item/user");
      commit("setItems", response.data.list)
    },
    async fetchOneItem({commit},id){
        const response = await axios.get(`/item/user/${id}`)
        console.log(response.data.data.name)
        commit("setOneItem", response.data.data)
    },
    async doLogin(){
            console.log("test");
    },
    async addUser({commit}, users){
      const response = await axios.post("/sign/signup", users);
      commit("addNewUser", response.data)
      alert(response.data.msg)
      router.push("/signin")
    },
    async updateItem({commit}, id, item){
        const response = await axios.put(`/item/${id}`, { headers : {"X-AUTH-TOKEN" : "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzOSIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2NTQ4NDQ2MTcsImV4cCI6MTY1NDg0ODIxN30.lapNm90Zhny-2zI8XRHSLKoX3g3fROAWvGe8vyd6bhI"}})
        console.log(response)
        console.log(id)
        console.log(response.data)
      
        commit("updateItem", response.data.data, id)
    },
    async deleteItem({commit}, id){
      await axios.delete(`/item/${id}`,  { headers : {"X-AUTH-TOKEN" : "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzOSIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2NTQ4Mzc5MjgsImV4cCI6MTY1NDg0MTUyOH0.-jhqgBpokre6AzhVzbBAwWo1tLV7DLMEilfnh31LB_I"}});
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
    addNewUser: (state, user) => state.users.unshift(user),
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
    userModule,    
    state,
    getters,
    actions,
    mutations
}