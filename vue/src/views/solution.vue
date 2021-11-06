<template>
<div class="pa-3">
  <v-row>
    <v-col
    cols="6"
    md="3">
    <v-card
    left
    class="mx-auto"
    width="250"
    tile
  >
    <v-navigation-drawer permanent>
      <v-list>
        <v-list-item link>
          <v-list-item-content>
            <v-list-item-title class="text-h6">
              솔루션 전체
            </v-list-item-title>
            <v-list-item-subtitle>원하는 솔루션을 검색하세요</v-list-item-subtitle>
          </v-list-item-content>

          <v-list-item-action>
            <v-icon>mdi-menu-down</v-icon>
          </v-list-item-action>
        </v-list-item>
      </v-list>
      <v-divider></v-divider>
      <v-list
        nav
        dense
      >
        <v-list-item-group
          v-model="selectedItem"
          color="primary"
        >
          <v-list-item
            v-for="(item, i) in items"
            :key="i"
          >
            <v-checkbox></v-checkbox>
            <v-list-item-content>
              <v-list-item-title v-text="item.text"></v-list-item-title>
              <v-list-item-subtitle> 세부품목 설명</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
  </v-card>
</v-col>

      <v-col
        cols="24"
        md="8"
      >
        <v-row class="ma-n3">
<!-- 첫 줄 두번째 구분 -->
 <v-col
 cols="12"
 md="8">
 </v-col>

<!-- 첫줄 세번째 구분 -->
<v-col cols="12" md="4">
    <v-form>
    <v-container>
      <v-row>
        <v-col cols="12">
          <v-text-field
            v-model="message"
            outlined
            clearable
            label="내용"
            type="text"
            hide-details
            >
            <template v-slot:append>
              <v-fade-transition leave-absolute>
                <v-progress-circular
                  v-if="loading"
                  size="24"
                  color="info"
                  indeterminate
                ></v-progress-circular>
              </v-fade-transition>
            </template>
            <template v-slot:append-outer>
                  <v-btn
                  color="primary"
                  v-bind="attrs"
                  v-on="on"
                  >
                  검색
                  </v-btn>
            </template>
          </v-text-field>
        </v-col>
      </v-row>
    </v-container>
  </v-form>
</v-col>

<!-- 카테고리슬라이더 -->
  <v-col cols="24">
     <v-sheet
    class="mx-auto"
    max-width="1000"
  >
    <v-slide-group
      multiple
      show-arrows
    >
      <v-slide-item
        v-for="n in 25"
        :key="n"
        v-slot="{ active, toggle }"
      >
        <v-btn
          class="mx-2"
          :input-value="active"
          active-class="purple white--text"
          depressed
          rounded
          @click="toggle"
        >
          카테고리 {{ n }}
        </v-btn>
      </v-slide-item>
    </v-slide-group>
  </v-sheet>
<v-col
        class="d-flex"
        cols="12"
        md="4">
<v-container>
  <v-sheet
  color="grey lighten-3"
  class="d-flex"
  height="300"
  width="900">
  </v-sheet>
</v-container>
</v-col>
    <v-divider class="ma-2"></v-divider>
    <!-- 상품 목록 -->
    <v-container>
      <h2>전체</h2>
      <v-list-item-subtitle>상세분류</v-list-item-subtitle>
      <v-row>
    <v-col
      v-for="n in 9"
      :key="n"
      class="d-flex child-flex"
      cols="4"
    ><v-card
    :loading="loading"
    class="mx-auto my-4"
    max-width="374"
  >
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>

    <v-img
      height="250"
      :src="`https://picsum.photos/500/300?image=${n * 5 + 10}`"
      :lazy-src="`https://picsum.photos/10/6?image=${n * 5 + 10}`"
      aspect-ratio="1"
      class="grey lighten-2"
    >
    <template v-slot:placeholder>
          <v-row
            class="fill-height ma-0"
            align="center"
            justify="center"
          >
            <v-progress-circular
              indeterminate
              color="grey lighten-5"
            ></v-progress-circular>
          </v-row>
        </template></v-img>

    <v-card-title>A 솔루션</v-card-title>
    <v-card-text>
      <v-row
        align="center"
        class="mx-0"
      >
        <v-rating
          :value="4.5"
          color="amber"
          dense
          half-increments
          readonly
          size="14"
        ></v-rating>

        <div class="grey--text ms-4">
          4.5 (413)
        </div>
      </v-row>
      <div class="my-4 text-subtitle-1">
         <h3 class="blue--text">8800원</h3>
         • 응용sw
      </div>
      <div>Small plates, salads & sandwiches - an intimate setting with 12 indoor seats plus patio seating.</div>
      <v-btn
      color="primary"
      class="mt-2"
      to="/details">
      상세보기</v-btn>
    </v-card-text>
  </v-card>
    </v-col>
  </v-row>
    </v-container>
  </v-col>
<v-col>
    <v-pagination
    v-model="page"
    :length="6"
    ></v-pagination>
</v-col>
</v-row>
</v-col>
</v-row>
</div>
</template>

<script>
export default {
  data: () => ({
    return: {
      page: 1
    },
    v0: true,
    selectedItem: 0,
    items: [
      { text: '일반 사무용SW' },
      { text: '콘텐츠 관련 SW' },
      { text: 'ERP/ERM' },
      { text: 'CRM' },
      { text: 'SCM/SRM' },
      { text: 'Collaboration SW' },
      { text: '엔지니어링․과학용 SW' }
    ]
  }),

  methods: {
    clickMe () {
      this.loading = true
      this.message = 'Wait for it...'
      setTimeout(() => {
        this.loading = false
        this.message = 'You have clicked me!'
      }, 2000)
    }
  }
}
</script>
