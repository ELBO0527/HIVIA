<template>
  <v-app>
    <!-- drawer 삽입 -->
    <div class="d-none d-lg-block">
      <v-navigation-drawer clipped permanent app>
        <v-list nav dense>
          <v-list-item>
            <v-list-item-title class="title">카테고리</v-list-item-title>
          </v-list-item>
          <v-divider></v-divider>
          <v-list-item-group v-model="selectedItem" color="primary">
            <v-list-item
              v-for="(item, i) in items"
              :key="i"
              dense
              router
              :to="item.route"
            >
              <v-list-item-icon>
                <v-icon v-text="item.icon"></v-icon>
              </v-list-item-icon>
              <v-list-item-content>
                <v-list-item-title v-text="item.text"></v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list-item-group>
        </v-list>
      </v-navigation-drawer>
    </div>
    <div class="d-flex">
    <router-view></router-view>
  </div>
  </v-app>
</template>

<script>
import { mapActions,mapGetters} from 'vuex';
export default {
  name: "App",
  data() {
    return{
    selectedItem: 1,
    quantity : 1,
      total : 0,
    items: [
      { text: "dashboard", icon: "mdi-clock", route: '/item' },
      { text: "item", icon: "mdi-flag", route: "/item/itemdetail" },
      { text: "user", icon: "mdi-flag", route: "/admin/user" },
      { text: "category", icon: "mdi-flag", route: "/admin/category" }
    ]
    }
  },
  methods: {
    ...mapActions(["fetchOneItem"]),
  },
    
    computed: mapGetters(["itemsList"]),
};
</script>
