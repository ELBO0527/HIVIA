<template>
  <div class="pa-3">
    <v-row>
      <v-col cols="6" md="3">
        <v-card left class="mx-auto" width="250" tile>
        </v-card>
      </v-col>

      <v-col cols="24" md="8">
        <v-row class="ma-n3">
          <!-- 첫 줄 두번째 구분 -->
          <v-col cols="12" md="8"> </v-col>

          <!-- 첫줄 세번째 구분 -->
          <v-col cols="12" md="4">
            <v-form>
              <v-container>
                <v-row>
                  <v-col cols="12">
                    <v-text-field
                      outlined
                      clearable
                      label="내용"
                      type="text"
                      hide-details
                    >
                      <template v-slot:append-outer>
                        <v-btn color="primary"  >
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
            <v-sheet class="mx-auto" max-width="1000">
              <v-slide-group multiple show-arrows>
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
            <v-col class="d-flex" cols="12" md="4">
              <v-container>
                <v-sheet
                  color="grey lighten-3"
                  class="d-flex"
                  height="300"
                  width="900"
                >
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
                  v-for="(item2, n) in items2"
                  :key="n"
                  class="d-flex child-flex"
                  cols="4"
                  ><v-card
                    class="mx-auto my-4"
                    max-width="374"
                  to="/details"
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

                    <v-card-title>{{item2.name}}</v-card-title>
                    <v-card-text>
                      <v-row align="center" class="mx-0">
                        <v-rating
                          :value=item2.stars
                          color="amber"
                          dense
                          half-increments
                          readonly
                          size="14"
                        ></v-rating>

                        <div class="grey--text ms-4">
                          {{item2.stars }} (413)
                        </div>
                      </v-row>
                      <div class="my-4 text-subtitle-1">
                        <h3 class="blue--text">{{item2.price}}원</h3>
                        • 상품 소개
                      </div>
                      <div>
                        상품소개.
                      </div>
                      <v-btn color="primary" class="mt-2" to="/details">
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
import axios from "axios";

export default {
  data() {
    return {
      page: 1,
      v0: true,
    selectedItem: 0,
    items2: [],
    }
  },

  methods: {
   fetchItem() {
      axios
        .get("http://localhost:8080/item/")
        .then(response => {
          console.log(response.data.list)
          this.items2 = response.data.list;
          console.log(this.items2[0].name)
          console.log(this.items2.length)
        })
        .catch(error => {
          console.log(error);
        });
    },
  },
    mounted() {
    this.fetchItem();
  },

};
</script>
