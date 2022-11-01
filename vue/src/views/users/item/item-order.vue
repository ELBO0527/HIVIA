<template>
  <v-container class="pa-2" align-center justify-center>
    <div class="pa-2" align-center justify-center>
    <v-row cols="12" md="12">
      <v-col cols="12" md="12" sm="8">
        <h2 align-center>주문하기</h2>
      </v-col>
    </v-row>
    <v-row cols="12" md="12" sm="6">
      <v-col cols="12" md="12" sm="8">
        <v-card class="pa-3">
          <v-cardtitle class="ma-4">주문자 정보</v-cardtitle>
          <v-row class="ma-4">
        <v-col
          cols="12"
          sm="12"
        >
          <v-text-field
            v-model="title"
            :rules="rules"
            counter="25"
            hint="This field uses counter prop"
            label="주문자 이름"
          ></v-text-field>
        </v-col>
        <v-col
          cols="12"
          sm="12"
        >
          <v-text-field
            v-model="description"
            :rules="rules"
            counter
            maxlength="25"
            hint="This field uses maxlength attribute"
            label="주소"
          ></v-text-field>
        </v-col>
        <v-col
          cols="12"
          sm="12"
        >
          <v-text-field
            v-model="needs"
            :rules="rules"
            counter="25"
            hint="This field uses counter prop"
            label="상세주소"
          ></v-text-field>
        </v-col>
        <v-col
          cols="12"
          sm="12"
        >
          <v-text-field
            v-model="description"
            :rules="rules"
            counter
            maxlength="25"
            hint="This field uses maxlength attribute"
            label="요구사항"
          ></v-text-field>
        </v-col>
      </v-row>
        </v-card>

      </v-col>
    </v-row>
  </div>
  <div>
    <v-row cols="12" md="12">
      <v-col cols="12" md="12" sm="8">        
        <v-card>
      <v-card-title>
        <h1 class="ma-2">상품 정보</h1>
      </v-card-title>
      <v-data-table
      :headers="headers"
      :items="cartList"
      class="elevation-1"
    >
    </v-data-table>
   </v-card>
      </v-col>
    </v-row>
  </div>
  <div>
    <v-row cols="12" md="12" sm="6">
      <v-col cols="12" md="12" sm="8">        
        <v-card class="pa-3">
          <h1 class="ma-2">결제하기</h1>
            <v-row class="pa-3">
              <v-col>
                <h2>상품 총 가격</h2>
              </v-col>
              <v-col>
              {{this.$store.state.b.itemPrice}}원
            </v-col>
            </v-row>
            <v-row class="pa-3">
              <v-col>
                <h2>배달비</h2>
              </v-col>
              <v-col>
              {{this.deliveryFee}}원
            </v-col>
            </v-row>
          <v-divider></v-divider>
          <v-row class="mt-2 pa-3">
            <v-col>
              <h2>총 주문 금액</h2>
            </v-col>
            <v-col>
              {{this.totalPrice}}원
            </v-col>
          </v-row>
          <v-row class="mt-3 pa-6" cols="12" md="12" sm="8">
            <div  align-center justify-center>
            <v-btn color="primary" @click="postOrder()" to="/itemOrderConfirmed">결제하기</v-btn>
            </div>
         </v-row>
        </v-card>
      </v-col>
    </v-row>
  </div>
  </v-container>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';

export default {
  data(){
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
      ],
      needs: this.needs,
      itemPrice : this.$store.state.b.itemPrice,
      deliveryFee: 3000,
      totalPrice : 0,
      }
  },
  methods: {
    ...mapActions(['fetchCart']),
    postOrder(userName) {
    const getData = JSON.parse(localStorage.getItem("vuex"));
    const token = getData.userModule.accessToken;
        userName = this.$store.state.userModule.id;
        
        const data = {
          needs : this.needs,
          price : this.totalPrice,
          deliveryFee : this.deliveryFee,
          totalPrice : this.totalPrice + this.deliveryFee
    	};

        this.$axios.post(`/order/${userName}`, data,{ headers: { "X-AUTH-TOKEN" : token
    }})
             .then(response => {
              this.$router.push({
                        name: "cart"
                    });
                    alert(response.data.msg)
                 console.log(response.data);
             })
             .catch(function (error) {
                console.log(error.response)
                    alert(response.data.msg)
             })
    },
  },
  computed: 
  mapGetters(['cartList']),  
  mounted() {
    this.fetchCart();
    this.totalPrice = this.itemPrice + this.deliveryFee;
  }
}
</script>