<template>
  <v-container
  class="d-flex pa-2" align-center justify-center>
    <div
    class="d-flex pa-2" align-center justify-center>
      <v-row
      cols="12" md="12">
        <v-col
        cols="12" md="12"
        class="my-2">
        <h1>장바구니</h1>
      <v-card
      rounded-lg
      >
      <v-data-table
      :headers="headers"
      :items="cartList"
      class="elevation-1"
      single-select
      show-select
      v-model="selected"
    >
      <template v-slot:item.delete>
        <v-dialog v-model="dialogDelete" max-width="500px">
          <v-card class="pa-3">
            <v-card-sub-title justify-center align-center class="text-h5 ma-3">상품을 장바구니에서 삭제하시겠습니까?</v-card-sub-title>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click.stop="dialogDelete = false">취소</v-btn>
              <v-btn color="blue darken-1" text @click="deleteCartItem(id)">확인</v-btn>
              <v-spacer></v-spacer>
            </v-card-actions>
          </v-card>
        </v-dialog>
      <v-btn
      outlined
      @click="deleteCartItem(selected[0].id)"
      >
        삭제하기
      </v-btn>
    </template>
    </v-data-table>
    
  </v-card>
        </v-col>
        <v-col>
  <v-card
  class="pa-2 my-2"
      rounded-lg>
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
</v-col>
    </v-row>
  </div>
  </v-container>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';

export default {
  data() {
    return {
      dialogDelete: false,
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
        { text: '삭제', value: 'delete', sortable: false },
      ],
      itemPrice : 0,
      selected: [],
    }
  },
  methods: {
    ...mapActions(['fetchCart']),

    deleteCartItem(id) {

    const getData = JSON.parse(localStorage.getItem("vuex"));
    const token = getData.userModule.accessToken;

        this.$axios.delete(`/cart/${id}`, { headers: { "X-AUTH-TOKEN" : token
    }})
             .then(response => {
              this.$router.push({
                        name: "cart"
                    });
                    alert(response.data.msg)
                 console.log(response);
             })
             .catch(function (error) {
                console.log(error.response)
                alert(error.response.data.msg)
             })
    }
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