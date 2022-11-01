<template>
  <v-card class="overflow-hidden">
    <!--앱바-->
    <v-app-bar clipped-left app color="white">
      <v-app-bar-nav-icon class="d-flex d-sm-none" @click="drawer = !drawer"></v-app-bar-nav-icon>
      <v-btn class="d-none d-sm-flex" text color="black" dark to="/">
        SHOPPINGMALL
      </v-btn>

      <v-spacer></v-spacer>

      <!-- 회사소개 -->
      <!-- <v-btn text color="primary" dark v-bind="attrs" v-on="on" to="/company">
        회사소개
      </v-btn> -->

      <!-- 첫번째 드롭박스 -->
      <div class="d-none d-sm-flex text-center">
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
      </div>

      <!-- 상품버튼 -->
      <!-- <v-btn text color="primary" dark v-bind="attrs" v-on="on" to="/help">
        문의하기
      </v-btn> -->

      <v-btn class="d-none d-sm-flex" text color="primary" dark v-bind="attrs" v-on="on" to="/admin">
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
      <v-btn icon to="/cart">
        <div 
          v-if="isNull"
          >
          <v-icon>mdi-cart</v-icon>
      </div>
        <div
        v-else
        >
          <v-badge
          color="green"
          content="1"
        >
        <v-icon>mdi-cart</v-icon>
        </v-badge>
        </div>
      </v-btn>
      <v-btn icon to="/signin">
        <v-icon>mdi-heart</v-icon>
      </v-btn>
      <v-spacer></v-spacer>
      <v-avatar class="d-none d-sm-flex mx-2" v-if="isLogin">
          <img src="https://i.pravatar.cc/64">
      </v-avatar>

      <v-btn v-if="isLogin" class="d-none d-sm-flex" text to="/mypage">
        <span>{{this.$store.state.userModule.id}}님</span>
      </v-btn>
      <v-btn v-if="isLogin" class="d-none d-sm-flex ma-2" color="primary" outlined to="/signin" @click="Logout()">로그아웃</v-btn>
      <div v-else>
        <v-row>
      <v-btn class="d-none d-sm-flex ma-2" color="primary" outlined to="/signin">로그인</v-btn>
      <v-btn class="d-none d-sm-flex my-2 primary" dark to="/signup"
        >회원가입</v-btn
      >
    </v-row>
      </div>
    </v-app-bar>

    <v-navigation-drawer
      class=""
      v-model="drawer"
      absolute
      temporary
    >
      <v-list
        nav
        dense
      >
        <v-list-item-group
          active-class="deep-purple--text text--accent-4"
        >
          <v-list-item>
            <v-list-item-title>Foo</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Bar</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Fizz</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Buzz</v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>

  </v-card>

  
</template>

<script>
export default {
  data(){
  return{
    drawer: this.$store.state.drawer,
    attrs: "",
    on: "",
    items: [],
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
		},
    isNull(){
      console.log(this.$store.getters['isNull'])
      return this.$store.getters['isNull'];
    }
	},

  watch: {
      group () {
        this.drawer = false
      },
    },

};

</script>
