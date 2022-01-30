<template>
  <v-app>
    <Header />
    <router-view></router-view>
    <Footer />
  </v-app>
</template>

<script>
import Footer from "./components/layout/Footer.vue";
import Header from "./components/layout/Header.vue";

export default {
  components: { Footer, Header },
  name: "App",

  data: () => ({
    model: null,
    icons: ["mdi-facebook", "mdi-twitter", "mdi-linkedin", "mdi-instagram"],
    items: [
      { title: "전체보기" },
      { title: "HP" },
      { title: "Microsoft" },
      { title: "Kakao" },
    ],
  }),
};
</script>
