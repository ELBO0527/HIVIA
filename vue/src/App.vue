<template>
  <v-app>
<<<<<<< Updated upstream
    <Header />
    <v-content>
      <router-view></router-view>
    </v-content>
    <!-- <Footer /> -->
=======
    <div style="position : fixed">
      <Header />
    </div>
    <div style="top : 500px">
      <router-view class="mt-15"></router-view>
    </div>
    <Footer />
>>>>>>> Stashed changes
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
