<template>
  <v-container
  class="pa-6 ma-2">
    <div>
    <v-row cols="6" md="6" sm="6">
      <v-col cols="12" md="6" sm="12">
        <h1>마이 페이지</h1>
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