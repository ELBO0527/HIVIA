<template>
  <v-container
  class="pa-6 ma-2" align="center" justify-center>
    <div>
      <v-card>
      <v-card-title>
        <h1>장바구니</h1>
      </v-card-title>
      <v-data-table
      :headers="headers"
      :items="cartList"
      class="elevation-1"
      single-select
    >
    </v-data-table>
    <h3>총 주문 가격 : {{this.itemPrice}} 원</h3>
    <v-btn
        to="/itemOrder"
        outlined
        rounded
        text
      >
        주문하기
      </v-btn>
  </v-card>
  </div>
  </v-container>
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
          value: 'item.name',
        },
        { text: '색상', value: 'item.color' },
        { text: '가격', value: 'item.price' },
        { text: '사이즈', value: 'item.size' },
        { text: '수량', value: 'quantity' },
        { text: '삭제', value: 'quantity' },
      ],
      itemPrice : 0
    }
  },
  methods: {
    ...mapActions(['fetchCart']),
  },
  computed: 
  mapGetters(['cartList']),
  mounted() {
    this.fetchCart();
    //장바구니 가격 총 가격
    for(var i =0; i<this.$store.state.b.items.length; i++) {
      this.itemPrice += this.$store.state.b.items[i].item.price * this.$store.state.b.items[i].quantity;
      this.$store.state.b.itemPrice = this.itemPrice;
    }
    console.log(this.$store.state.b.itemPrice)
  },
}
</script>