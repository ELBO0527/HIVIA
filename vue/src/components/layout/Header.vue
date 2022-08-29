<template>
  <v-card class="overflow-hidden">
    <!--앱바-->
    <v-app-bar clipped-left app color="white">
      <v-spacer></v-spacer>

      <v-btn text color="black" dark to="/">
        SHOPPINGMALL
      </v-btn>

      <v-spacer></v-spacer>

      <!-- 회사소개 -->
      <!-- <v-btn text color="primary" dark v-bind="attrs" v-on="on" to="/company">
        회사소개
      </v-btn> -->

      <!-- 첫번째 드롭박스 -->
      <div class="text-center">
        <v-menu open-on-hover offset-y>
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              text
              color="primary"
              dark
              v-bind="attrs"
              v-on="on"
              to="/item"
            >
              컬렉션
            </v-btn>
          </template>
          <v-list>
            <v-list-item
              v-for="(item, index) in items"
              :key="index"
              to="/item"
            >
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </div>

      <!-- 상품버튼 -->
      <!-- <v-btn text color="primary" dark v-bind="attrs" v-on="on" to="/help">
        문의하기
      </v-btn> -->

      <v-btn text color="primary" dark v-bind="attrs" v-on="on" to="/admin">
        관리자 페이지
      </v-btn>

      <!--검색바-->
      <v-spacer></v-spacer>
      <v-spacer></v-spacer>
      <v-text-field
        label="검색"
        placeholder="검색"
        solo
        dense
        prepend-inner-icon="mdi-magnify"
        hide-details
      ></v-text-field>
      <v-spacer></v-spacer>
      <!-- 아이콘-->
      <v-btn icon to="/signin">
        <v-icon>mdi-heart</v-icon>
      </v-btn>
      <v-spacer></v-spacer>
      <v-avatar v-if="isLogin" to="/mypage">
          <img src="https://i.pravatar.cc/64">
      </v-avatar>
      <v-btn v-if="isLogin" class="ma-2" color="primary" outlined to="/signin" @click="Logout()">로그아웃</v-btn>
      <div v-else>
      <v-btn class="ma-2" color="primary" outlined to="/signin">로그인</v-btn>
      <v-btn color="primary" dark to="/signup"
        >회원가입</v-btn
      >
      </div>
    </v-app-bar>
  </v-card>
</template>

<script>
export default {
  data(){
  return{
    attrs: "",
    on: "",
    items: []
    }
  },
  methods : {
		Logout() {
			this.$store.dispatch("doLogout");
			this.$router.push('/');
		}
	},

	computed : {
		isLogin() {
			return this.$store.getters['isLogin'];
		}
	}


};

</script>
