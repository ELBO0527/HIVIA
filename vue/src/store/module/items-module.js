import axios from 'axios';

const state = {
  items: [],
  item: '',

  //item DTO
  brand: '',
  name: '',
  color: '',
  country: '',
  price: '',
  size: '',
  stock: '',
  stars: '',
};

const getters = {
  itemsList: state => state.items,
  updateitem: state => state.item,
};

const actions = {
  async fetchItems({ commit }) {
    const response = await axios.get('/item/user');
    commit('setItems', response.data.list);
  },
  async fetchOneItem({ commit }, id) {
    const response = await axios.get(`/item/user/${id}`);
    console.log(response.data.data.name);
    commit('setOneItem', response.data.data);
  },
  async addItems({ commit }, item) {
    const response = await axios.post('/item/', item, {
      headers: {
        'X-AUTH-TOKEN':
          'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzOSIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2NTQ4Mzc5MjgsImV4cCI6MTY1NDg0MTUyOH0.-jhqgBpokre6AzhVzbBAwWo1tLV7DLMEilfnh31LB_I',
      },
    });
    alert(response.data);
    commit('addNewItem', response.data.list);
  },
  async updateItem({ commit }, id, item) {
    const response = await axios.put(`/item/${id}`, {
      headers: {
        'X-AUTH-TOKEN':
          'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzOSIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2NTQ4NDQ2MTcsImV4cCI6MTY1NDg0ODIxN30.lapNm90Zhny-2zI8XRHSLKoX3g3fROAWvGe8vyd6bhI',
      },
    });
    console.log(response);
    console.log(id);
    console.log(response.data);

    commit('updateItem', response.data.data, id);
  },
  async deleteItem({ commit }, id) {
    await axios.delete(`/item/${id}`, {
      headers: {
        'X-AUTH-TOKEN':
          'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzOSIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE2NTQ4Mzc5MjgsImV4cCI6MTY1NDg0MTUyOH0.-jhqgBpokre6AzhVzbBAwWo1tLV7DLMEilfnh31LB_I',
      },
    });
    commit('removeItem', id);
  },
};

const mutations = {
  setItems: (state, items) => (state.items = items),
  setOneItem: (state, item) => (
    (state.item = item), console.log(state.item.name)
  ),
  addNewItem: (state, item) => state.items.unshift(item),
  updateItem: (state, item) => {
    state.items.filter(item => item.id !== id), state.items.unshift(item);
  },
  removeItem: (state, id) => (
    state.items.filter(item => item.id !== id),
    state.items.splice(item => item.id, 1)
  ),
};

export default {
  state,
  getters,
  actions,
  mutations,
};
