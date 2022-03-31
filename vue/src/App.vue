<template>
  <v-app>
    <Header />
    <v-content>
      <router-view></router-view>
    </v-content>
    <Footer />
  </v-app>
</template>

<script>
import Footer from "./components/layout/Footer.vue";
import Header from "./components/layout/Header.vue";

export default {
  components: { Footer, Header },
  name: "App"
};
</script>
