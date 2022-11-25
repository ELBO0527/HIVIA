import axios from 'axios';
import router from '@/router';

const state = {
  items: [],
  item: '',
  itemPrice : 0,
  totalPrice: 0
};

const getters = {
  cartList: state => state.items,
  updateitem: state => state.item,
  isNull(state) {
    return state.item == '' ? false : true;
  },
};

const actions = {
  async fetchCart({ commit }) {
    const getData = JSON.parse(localStorage.getItem('vuex'));
    const token = getData.userModule.accessToken;
    const response = await axios.get('/cart/', {
      headers: { 'X-AUTH-TOKEN': token },
    });
    console.log(response.data.list);
    commit('setCart', response.data.list);
  },
  
  
  async addCart({ commit }, name, item) {
    const getData = JSON.parse(localStorage.getItem('vuex'));
    const token = getData.userModule.accessToken;
    const response = await axios.post(`/cart/${name}`, item, {
      headers: { 'X-AUTH-TOKEN': token },
    });
    console.log(response);
    console.log(name);
    console.log(response.data.list);
    alert(response.data);
    commit('addNewItemInCart', response.data.data);
    router.push('item');
  },

  async updateCart({ commit }, id, item) {
    const getData = JSON.parse(localStorage.getItem('vuex'));
    const token = getData.userModule.accessToken;
    const response = await axios.put(`/cart/${id}`, item, {
      headers: { 'X-AUTH-TOKEN': token },
    });
    console.log(response);
    console.log(id);
    console.log(response.data);

    commit('updateCartItem', response.data.data, id);
  },

  async deleteCart({ commit }, id) {
    const getData = JSON.parse(localStorage.getItem('vuex'));
    const token = getData.userModule.accessToken;
    await axios.delete(`/cart/${id}`, { headers: { 'X-AUTH-TOKEN': token } });
    commit('removeCartItem', id);
  },
};

const mutations = {
  setCart: (state, items) => (state.items = items),
  setOneCart: (state, item) => (
    (state.item = item), console.log(state.item.name)
  ),
  addNewItemInCart: (state, item) => state.items.unshift(item),
  updateCartItem: (state, id, item) => {
    state.items.filter(item => item.id !== id),
      state.items.splice(item => item.id, 1),
      state.items.unshift(item);
  },
  removeCartItem: (state, id) => (
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
