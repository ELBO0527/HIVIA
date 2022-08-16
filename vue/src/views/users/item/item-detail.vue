<template>
  <v-container class="pa-6 ma-2">
    <div>
      <v-row cols="6" md="6" sm="6">
        <v-col cols="12" md="6" sm="12">
          <h1>상품 상세 페이지</h1>
          <v-carousel delimiter-icon="mdi-minus" hide-delimiter-background :show-arrows="false">
            <v-carousel-item v-for="(item,i) in itemPics" :key="i" :src="item.src"></v-carousel-item>
          </v-carousel>

        </v-col>
        <v-col cols="6" md="6" sm="6">
          <h2>상품 소개</h2>
          <v-col cols="12" md="6" sm="6">
            <v-row cols="12" md="12" sm="12">
              <v-col cols="6" md="6" sm="6">
                <v-span class="px">사이즈</v-span>
              </v-col>
              <v-col cols="12" md="6" sm="6">
                <v-combobox v-model="size" :items="items" outlined dense hide-details></v-combobox>
              </v-col>
            </v-row>
            <v-row cols="12" md="12" sm="12">
              <v-col cols="6" md="6" sm="6">
                <v-span class="pt-8">색상</v-span>
              </v-col>
              <v-col cols="6" md="6" sm="6">
                <v-span class="pt-8">파랑</v-span>
              </v-col>
            </v-row>
            <v-row cols="12" md="12" sm="12">
               <v-col cols="6" md="6" sm="6">
                <v-span class="pt-8">가격</v-span>
              </v-col>
               <v-col cols="6" md="6" sm="6">
                <v-span class="pt-8">3000원</v-span>
              </v-col>
            </v-row>
            <v-row cols="12" md="12" sm="12">
              <v-col cols="6" md="6" sm="6">
                <v-span class="pt-8">수량</v-span>
              </v-col>
              <v-col cols="6" md="6" sm="6">
                <v-text-field v-model="quantity" hide-details type="number" max-width="4" />
              </v-col>
            </v-row>
            <v-btn class="ma-2 mt-lg-12" outlined to="/cart" color="indigo">
              장바구니에 담기
            </v-btn>
            <v-btn class="ma-2" outlined to="/itemOrder" color="indigo">
              주문하기
            </v-btn>
          </v-col>
        </v-col>
      </v-row>
      <v-row>
        <v-col col="12" md="12" sm="12">
          <hr>
        </v-col>
        <v-col>
          <v-tabs v-model="tab" background-color="transparent" grow>
            <v-tab v-for="item in tabItems" :key="item">
              {{ item }}
            </v-tab>
          </v-tabs>

          <v-tabs-items v-model="tab">
            <v-tab-item v-for="item in tabItems" :key="item">
              <v-card flat>
                <v-card-text>{{ text }}</v-card-text>
              </v-card>
            </v-tab-item>
          </v-tabs-items>
        </v-col>
      </v-row>
    </div>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      itemPics: [
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/squirrel.jpg',
          },
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/sky.jpg',
          },
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/bird.jpg',
          },
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/planet.jpg',
          },
        ],
      quantity : "1",
       items: [
          '90',
          '95',
          '100',
          '105',
        ],
        tab: null,
        tabItems: [
          '상품 리뷰', '상품 문의', '판매자 소개', '배송/환불/AS/교환',
        ],
        text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
        
    }
  } ,
//  methods: {
//    ...mapActions(["fetchOneItem"]),
//  }
}
</script>