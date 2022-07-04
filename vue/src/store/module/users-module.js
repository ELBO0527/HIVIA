import axios from 'axios'
import router from '@/router'


const state = { 
    users: [],
    alert: false,
    id : "",
    accessToken : "",
    userInfo: []
};

const getters = { 
    isLogin(state){
        return state.accessToken == '' ? false : true;
    }
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

    async doLogin({commit}, userInfo){
        let result = false;
        let resultErr = null;
        try{
            let res = await axios.post("/sign/signin", userInfo);
            if(res.data.success == true){
                console.log(userInfo);
                console.log(res.data.data);
                commit('setId', userInfo.id);
                commit('setAccessToken', res.data.data);
                axios.defaults.headers.common['X-AUTH-TOKEN']= res.data.data;
                result = true;
            } else{
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
        delete axios.defaults.headers.common['X-AUTH-TOKEN'];
    },
    async addUser({commit}, users){
      const response = await axios.post("/sign/signup", users);
      commit("addNewUser", response.data);
      alert(response.data.msg);
      router.push("/signin");
    },
};

const mutations = { 
    addNewUser: (state, user) => state.users.unshift(user),
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
};

export default { 
    state,
    getters,
    actions,
    mutations
}