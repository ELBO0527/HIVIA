<template>
  <v-app>
    <!-- drawer 삽입 -->
    <div style="position : fixed">
      <v-navigation-drawer clipped permanent app>
        <v-list nav dense>
          <v-list-item>
            <v-list-item-title class="title">ADMIN PAGE</v-list-item-title>
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
    <router-view></router-view>
  </v-app>
</template>

<script>
export default {
  name: "App",
  data() {
    return{
    selectedItem: 1,
    items: [
      { text: "dashboard", icon: "mdi-clock", route: '/admin' },
      { text: "item", icon: "mdi-flag", route: "/admin/item" },
      { text: "user", icon: "mdi-flag", route: "/admin/user" },
      { text: "category", icon: "mdi-flag", route: "/admin/category" }
    ]
    }
  }
};
</script>
