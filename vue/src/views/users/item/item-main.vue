<template>
  <div class="pt-3">
    <v-row>
      <v-col cols="12" md="12">
        <v-row class="ma-n3">
          <v-col cols="12">
            <!-- 상품 목록 -->
            <v-container>
              <h2>전체</h2>
              <v-list-item-subtitle>상세분류</v-list-item-subtitle>
              <v-row>
                <v-col
                  v-for="(item2, n) in items2"
                  :key="n"
                  class="d-flex child-flex"
                  cols="4"
                  ><v-card
                    class="mx-auto my-4"
                    max-width="374"
                    @click="fetchOneItem(item2.id)"
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
                      :lazy-src="
                        `https://picsum.photos/10/6?image=${n * 5 + 10}`
                      "
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
                        </v-row> </template
                    ></v-img>

                    <v-card-title>{{ item2.name }}</v-card-title>
                    <v-card-text>
                      <v-row align="center" class="mx-0">
                        <v-rating
                          :value="item2.stars"
                          color="amber"
                          dense
                          half-increments
                          readonly
                          size="14"
                        ></v-rating>

                        <div class="grey--text ms-4">{{ item2.stars }} (0)</div>
                      </v-row>
                      <div class="my-4 text-subtitle-1">
                        <h3 class="blue--text">{{ item2.price }}원</h3>
                        • 상품 소개
                      </div>
                      <div>
                        상품소개.
                      </div>
                      <v-btn
                        color="primary"
                        class="mt-2"
                        @click="fetchOneItem(item2.id)"
                      >
                        상세보기</v-btn
                      >
                    </v-card-text>
                  </v-card>
                </v-col>
              </v-row>
            </v-container>
          </v-col>
          <v-col>
            <v-pagination :length="6"></v-pagination>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';
import axios from 'axios';

export default {
  data() {
    return {
      page: 1,
      v0: true,
      selectedItem: 0,
      items2: [],
    };
  },
  methods: {
    ...mapActions(['fetchOneItem']),
    fetchItem() {
      axios
        .get('/item/user')
        .then(response => {
          this.items2 = response.data.list;
        })
        .catch(error => {
          console.log(error);
          alert(error.response.data.msg);
        });
    },
  },
  mounted() {
    this.fetchItem();
  },
};
</script>
