<template>
  <v-card color="blue-grey darken-1" dark :loading="isUpdating">
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
              <v-list-item @click="isUpdating = true">
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
              {{ name }}
            </h3>
          </v-col>
        </v-row>
      </v-row>
    </v-img>
    <v-form>
      <v-container>
        <v-row>
          <v-col cols="12" md="12">
            <v-file-input
  show-size
  truncate-length="15"
></v-file-input>
          </v-col>
          <v-col cols="12" md="6">
            <v-text-field
              v-model="name"
              filled
              color="blue-grey lighten-2"
              label="상품명"
            ></v-text-field>
          </v-col>
          <v-col cols="12" md="6">
            <v-text-field
              v-model="price"
              filled
              color="blue-grey lighten-2"
              label="가격(원)"
            ></v-text-field>
          </v-col>
          <v-col cols="12">
            <v-text-field
              v-model="stock"
              filled
              color="blue-grey lighten-2"
              label="재고량"
            ></v-text-field>
          </v-col>
          <v-col cols="12">
            <v-text-field
              v-model="brand"
              filled
              color="blue-grey lighten-2"
              label="브랜드"
            ></v-text-field>
          </v-col>
          <v-col cols="12">
            <v-text-field
              v-model="country"
              filled
              color="blue-grey lighten-2"
              label="생산국가"
            ></v-text-field>
          </v-col>
          <v-col cols="12">
            <v-text-field
              v-model="size"
              filled
              color="blue-grey lighten-2"
              label="사이즈"
            ></v-text-field>
          </v-col>
          <v-col cols="12">
            <v-autocomplete
              v-model="friends"
              :disabled="isUpdating"
              :items="people"
              filled
              chips
              color="blue-grey lighten-2"
              label="Select"
              item-text="name"
              item-value="name"
              multiple
            >
              <template v-slot:selection="data">
                <v-chip
                  v-bind="data.attrs"
                  :input-value="data.selected"
                  close
                  @click="data.select"
                  @click:close="remove(data.item)"
                >
                  <v-avatar left>
                    <v-img :src="data.item.avatar"></v-img>
                  </v-avatar>
                  {{ data.item.name }}
                </v-chip>
              </template>
              <template v-slot:item="data">
                <template v-if="typeof data.item !== 'object'">
                  <v-list-item-content v-text="data.item"></v-list-item-content>
                </template>
                <template v-else>
                  <v-list-item-avatar>
                    <img :src="data.item.avatar" />
                  </v-list-item-avatar>
                  <v-list-item-content>
                    <v-list-item-title
                      v-html="data.item.name"
                    ></v-list-item-title>
                    <v-list-item-subtitle
                      v-html="data.item.group"
                    ></v-list-item-subtitle>
                  </v-list-item-content>
                </template>
              </template>
            </v-autocomplete>
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
        @click="postItem()"
      >
        <v-icon left>
          mdi-update
        </v-icon>
        등록
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import axios from "axios";
import { mapActions } from 'vuex';

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
      autoUpdate: true,
      friends: ["Sandra Adams", "Britta Holt"],
      isUpdating: false,
      name: "",
      price: "",
      brand: "",
      stock: "",
      stars: 0,
      country: "",
      color: "",
      size: "",
      people: [
        { header: "Group 1" },
        { name: "Sandra Adams", group: "Group 1", avatar: srcs[1] },
        { name: "Ali Connors", group: "Group 1", avatar: srcs[2] },
        { name: "Trevor Hansen", group: "Group 1", avatar: srcs[3] },
        { name: "Tucker Smith", group: "Group 1", avatar: srcs[2] },
        { divider: true },
        { header: "Group 2" },
        { name: "Britta Holt", group: "Group 2", avatar: srcs[4] },
        { name: "Jane Smith ", group: "Group 2", avatar: srcs[5] },
        { name: "John Smith", group: "Group 2", avatar: srcs[1] },
        { name: "Sandra Williams", group: "Group 2", avatar: srcs[3] }
      ],
    };
  },

  watch: {
    isUpdating(val) {
      if (val) {
        setTimeout(() => (this.isUpdating = false), 3000);
      }
    }
  },

  methods: {
    ...mapActions(["addItems"]),

    remove(item) {
      const index = this.friends.indexOf(item.name);
      if (index >= 0) this.friends.splice(index, 1);
    },
    postItem() {
      this.addItems({
          name : this.name, 
          price : this.price,
          brand : this.brand,
          size : this.size,
          color : this.color,
          country : this.country,
          stars : this.stars,
          stock : this.stock})
      }
    }
};
</script>
