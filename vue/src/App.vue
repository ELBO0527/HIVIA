<template>
  <v-app>
   <v-card class="overflow-hidden">
    <!--앱바-->
    <v-app-bar
      color="white"
    >
    <v-spacer></v-spacer>

        <v-btn
          text
          color="black"
          dark
          v-bind="attrs"
          v-on="on"
          to="/"
        >
        Ksolution
        </v-btn>

    <v-spacer></v-spacer>

      <!-- 회사소개 -->
        <v-btn
          text
          color="primary"
          dark
          v-bind="attrs"
          v-on="on"
          to="/company"
        >
        회사소개
        </v-btn>

    <!-- 첫번째 드롭박스 -->
    <div class="text-center">
    <v-menu
     open-on-hover
     offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          text
          color="primary"
          dark
          v-bind="attrs"
          v-on="on"
          to="/solution"
        >
        솔루션 검색
        </v-btn>
      </template>
      <v-list>
        <v-list-item
          v-for="(item, index) in items"
          :key="index"
          to="/solution"
        >
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </div>

  <!-- 상품버튼 -->
        <v-btn
          text
          color="primary"
          dark
          v-bind="attrs"
          v-on="on"
          to="/help"
        >
        문의하기
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
        <v-btn icon>
        <v-icon>mdi-heart</v-icon>
      </v-btn>
      <v-spacer></v-spacer>
    <v-btn
          class="ma-2"
          color="primary"
          outlined
          to="/signin"
        >로그인</v-btn>
        <v-btn
          color="primary"
          dark
          v-bind="attrs"
          v-on="on"
          to="/signup"
        >회원가입</v-btn>
</v-app-bar>
   </v-card>

    <router-view></router-view>
    <!--footer -->
  <v-card>
     <v-footer
    dark
    padless
  >
    <v-card
      flat
      tile
      class="indigo lighten-1 white--text text-center"
    >
      <v-card-text>
        <v-btn
          v-for="icon in icons"
          :key="icon"
          class="mx-4 white--text"
          icon
        >
          <v-icon size="24px">
            {{ icon }}
          </v-icon>
        </v-btn>
      </v-card-text>

      <v-card-text class="white--text pt-0">
        Phasellus feugiat arcu sapien, et iaculis ipsum elementum sit amet. Mauris cursus commodo interdum. Praesent ut risus eget metus luctus accumsan id ultrices nunc. Sed at orci sed massa consectetur dignissim a sit amet dui. Duis commodo vitae velit et faucibus. Morbi vehicula lacinia malesuada. Nulla placerat augue vel ipsum ultrices, cursus iaculis dui sollicitudin. Vestibulum eu ipsum vel diam elementum tempor vel ut orci. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
      </v-card-text>

      <v-divider></v-divider>

      <v-card-text class="white--text">
        {{ new Date().getFullYear() }} — <strong>ITDesk</strong>
      </v-card-text>
    </v-card>
  </v-footer>
  </v-card>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    model: null,
    icons: [
      'mdi-facebook',
      'mdi-twitter',
      'mdi-linkedin',
      'mdi-instagram'
    ],
    items: [
      { title: '전체보기' },
      { title: 'HP' },
      { title: 'Microsoft' },
      { title: 'Kakao' }
    ]
  })
}
</script>
