import router from '@/router';

const userModule = {
  state: {
    id: '',
    passwd: '',
    token: '',
  },
  mutations: {
    login: function(state, payload) {
      console.log(payload.id);
      console.log(payload.email);
      console.log(payload.token);
      state.id = payload.id;
      state.email = payload.email;
      state.token = payload.token;
    },
    loginCheck: function(state) {
      if (!state.token) {
        router
          .push({
            name: 'Signin',
          })
          .catch(error => {
            console.log(error);
          });
      }
    },
  },
};

const state = {
  items: [],
  item: '',
};

const getters = {};

const actions = {
  async login({ commit }, user) {
    const response = await axios.post('/sign/signin', user);
    console.log(response.data);
    commit('addNewItem', response.data);
  },
};

const mutations = {
  loginAdd: (state, item) => state.items.unshift(item),
};

export default {
  state,
  getters,
  actions,
  mutations,
  userModule,
};
