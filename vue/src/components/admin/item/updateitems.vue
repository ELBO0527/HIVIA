<template>
  <v-card color="blue-grey darken-1" dark>
    <template v-slot:progress>
      <v-progress-linear
        absolute
        color="green lighten-3"
        height="4"
        indeterminate
      ></v-progress-linear>
    </template>
    <v-img
      height="200"
      src="https://cdn.vuetifyjs.com/images/cards/dark-beach.jpg"
    >
      <v-row>
        <v-col class="text-right" cols="12">
          <v-menu bottom left transition="slide-y-transition">
            <template v-slot:activator="{ on, attrs }">
              <v-btn icon v-bind="attrs" v-on="on">
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </template>
            <v-list>
              <v-list-item>
                <v-list-item-action>
                  <v-icon>mdi-cog</v-icon>
                </v-list-item-action>
                <v-list-item-content>
                  <v-list-item-title>Update</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list>
          </v-menu>
        </v-col>
        <v-row class="pa-4" align="center" justify="center">
          <v-col class="text-center">
            <h3 class="text-h5">
              {{ updateitem.name }}
              {{ $store.state.a.item.id }}
            </h3>
          </v-col>
        </v-row>
      </v-row>
    </v-img>
    <v-form>
      <v-container>
        <v-row>
          <v-col cols="12" md="6">
            <v-text-field
              v-model="$store.state.a.item.name"
              filled
              color="blue-grey lighten-2"
              label="상품명"
            >{{updateitem.name}}</v-text-field>
          </v-col>
          <v-col cols="12" md="6">
            <v-text-field
              v-model="$store.state.a.item.price"
              filled
              color="blue-grey lighten-2"
              label="가격"
            >{{updateitem.price}}</v-text-field>
          </v-col>
          <v-col cols="12">
            <v-text-field
              v-model="$store.state.a.item.stock"
              filled
              color="blue-grey lighten-2"
              label="재고량"
            >{{updateitem.stock}}</v-text-field>
          </v-col>
          <v-col cols="12">
            <v-text-field
              v-model="$store.state.a.item.brand"
              filled
              color="blue-grey lighten-2"
              label="브랜드"
            >{{updateitem.brand}}</v-text-field>
          </v-col>
          <v-col cols="12">
            <v-text-field
              v-model="$store.state.a.item.country"
              filled
              color="blue-grey lighten-2"
              label="생산국가"
            >{{updateitem.country}}</v-text-field>
          </v-col>
          <v-col cols="12">
            <v-text-field
              v-model="$store.state.a.item.size"
              filled
              color="blue-grey lighten-2"
              label="사이즈"
            >{{updateitem.size}}</v-text-field>
          </v-col>
          <v-col cols="12">
            <v-text-field
              v-model="$store.state.a.item.id"
              filled
              color="blue-grey lighten-2"
              label="id"
            ></v-text-field>
          </v-col>
        
          </v-col>
        </v-row>
      </v-container>
    </v-form>
    <v-divider></v-divider>
    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn
        color="blue-grey darken-3"
        depressed
      >
        <v-icon left>
          mdi-update
        </v-icon>
        취소
      </v-btn>
       <v-btn
        color="blue-grey darken-3"
        depressed
        @click="changeItem(updateitem.id)"
      >
        <v-icon left>
          mdi-update
        </v-icon>
        수정
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import { mapActions, mapGetters, mapState } from 'vuex';

export default {
  data() {
    const srcs = {
      1: "https://cdn.vuetifyjs.com/images/lists/1.jpg",
      2: "https://cdn.vuetifyjs.com/images/lists/2.jpg",
      3: "https://cdn.vuetifyjs.com/images/lists/3.jpg",
      4: "https://cdn.vuetifyjs.com/images/lists/4.jpg",
      5: "https://cdn.vuetifyjs.com/images/lists/5.jpg"
    };
    return {
      name: "",
      price: "",
      brand: "",
      stock: "",
      stars: 0,
      country: "",
      color: "",
      size: "",
    };
  },

  methods: {
    ...mapActions(["updateItem","fetchOneItem"]),
      changeItem() {
      this.updateItem()
      }
    },
    computed:{
      ...mapGetters(["updateitem"]),
      ...mapState([
          
      ])
    },
};
</script>
