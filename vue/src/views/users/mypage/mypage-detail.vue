<template>
  <v-container
  class="pa-6 ma-2">
    <div>
    <v-row cols="6" md="6" sm="6">
      <v-col cols="12" md="6" sm="12">
        <h1>상품 상세 페이지</h1>
        <h1>상품 상세 페이지</h1>
        <h1>상품 상세 페이지</h1>
        <h1>상품 상세 페이지</h1>
        <h1>상품 상세 페이지</h1>
        <h1>상품 상세 페이지</h1>
        <h1>상품 상세 페이지</h1>
        <h1>상품 상세 페이지</h1>
        <h1>상품 상세 페이지</h1>
      </v-col>
      <v-col cols="6" md="6" sm="6">
        <h1>t2nter</h1>
        <v-col cols="12" md="6" sm="6">
        <v-btn
        class="ma-2"
        outlined
        color="indigo">
        장바구니에 담기
        </v-btn>
        <v-btn
        class="ma-2"
        outlined
        color="indigo">
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
         <v-card>
          <v-tabs
      v-model="tab"
      background-color="transparent"
      grow
    >
      <v-tab
        v-for="item in items"
        :key="item"
      >
        {{ item }}
      </v-tab>
    </v-tabs>

    <v-tabs-items v-model="tab">
      <v-tab-item
        v-for="item in items"
        :key="item"
      >
        <v-card
          flat
        >
          <v-card-text>{{ text }}</v-card-text>
        </v-card>
      </v-tab-item>
    </v-tabs-items>
    </v-card>
      </v-col>
    </v-row>
    </div>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
        tab: null,
        items: [
          'Appetizers', 'Entrees', 'Deserts', 'Cocktails',
        ],
        text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
    }
  }
}
</script>