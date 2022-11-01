<template>
  <v-container
  class="d-flex" align-center justify-center>
    <div align-center justify-center>
      <v-card
    class="mx-auto"
    max-width="344"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <div class="text-overline mb-4">
          주문 완료
        </div>
        <v-list-item-title class="text-h5 mb-1">
          결제가 완료되었습니다!
        </v-list-item-title>
        <v-list-item-subtitle>안전하게 배송해 드리겠습니다.</v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>

    <v-row class="pa-4" align="center" justify="center">
    <v-card-actions>
      <v-btn
        outlined
        primary
        text
      >
        주문 내역 확인
      </v-btn>
      <v-btn
        outlined
        text
        to="/"
      >
        홈으로
      </v-btn>
    </v-card-actions>
  </v-row>
  </v-card>
    </div>
  </v-container>
</template>

<script>
export default {
  data(){
    return {

    }
  }
}
</script>