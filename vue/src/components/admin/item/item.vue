<template>
  <div>
    <v-data-table
      :headers="headers"
      :items="itemsList"
      class="elevation-1"
      show-select
      single-select
      v-model="selected"
    >
    </v-data-table>
    <v-btn color="primary" dark to="postitems">아이템 등록</v-btn>
    <v-btn
      color="primary"
      dark
      to="updateitems"
      @click="fetchOneItem(selected[0].id)"
      >아이템 수정</v-btn
    >
    <v-btn color="primary" dark @click="deleteItem(selected[0].id)"
      >아이템 삭제</v-btn
    >
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';

export default {
  data() {
    return {
      headers: [
        {
          text: '이름',
          align: 'start',
          sortable: false,
          value: 'name',
        },
        { text: '브랜드', value: 'brand' },
        { text: '색상', value: 'color' },
        { text: '제조국', value: 'country' },
        { text: '가격', value: 'price' },
        { text: '사이즈', value: 'size' },
        { text: '수량', value: 'stock' },
        { text: '별점', value: 'stars' },
      ],
      selected: [],
    };
  },
  methods: {
    ...mapActions(['fetchItems', 'deleteItem', 'fetchOneItem']),
  },
  computed: mapGetters(['itemsList']),
  mounted() {
    this.fetchItems();
  },
};
</script>
