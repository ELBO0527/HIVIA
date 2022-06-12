import axios from 'axios';

const state = {
  items: [],
};

const getters = {
  itemsList: state => state.items,
};

const actions = {
  async fetchItems({ commit }) {
    const response = await axios.get('/item/user');
    console.log(response.data.list);
    commit('setItems', response.data.list);
  },
  async fetchOneItem({ commit }, id) {
    const response = await axios.get(`item/user/${id}`);
    console.log(response.data.list + 'test');
    commit('setItems', response.data.list);
  },
  async addItems({ commit }, item) {
    const response = await axios.post('/item/', item, {
      headers: {
        'X-AUTH-TOKEN':
          'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMDAzIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY1NDY3NzQwNywiZXhwIjoxNjU0NjgxMDA3fQ.8blsXTWIpV_xOnmXjJCqN11OlPGm_B9XWWsbiy9CN_4',
      },
    });
    alert(response.data);
    commit('addNewItem', response.data.list);
  },
  async deleteItem({ commit }, id) {
    await axios.delete(`/item/${id}`, {
      headers: {
        'X-AUTH-TOKEN':
          'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMDAzIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY1NDY3NzQwNywiZXhwIjoxNjU0NjgxMDA3fQ.8blsXTWIpV_xOnmXjJCqN11OlPGm_B9XWWsbiy9CN_4',
      },
    });
    commit('removeItem', id);
  },
};

const mutations = {
  setItems: (state, items) => (state.items = items),
  setOneItem: (state, id) => state.items.findindex(item => item.id == id),
  addNewItem: (state, item) => state.items.unshift(item),
  updateItem: (state, item, id) => state.items.unshift(item => item.id !== id),
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
