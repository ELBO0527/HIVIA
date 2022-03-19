<template>
  <v-app>
    <!-- drawer 삽입 -->
    <div style="position : static">
    <v-navigation-drawer clipped permanent app>
      <v-list nav dense>
        <v-list-item>
          <v-list-item-title class="title">ADMIN #1</v-list-item-title>
        </v-list-item>
        <v-divider></v-divider>
        <v-list-item-group v-model="selectedItem" color="primary">
          <v-list-item v-for="(item, i) in items" :key="i"
          dense
          router :to="item.route">
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
    <v-content app>
    <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
export default {
  name: "App",
  data: () => ({
    selectedItem: 1,
    items: [
      { text: "dashboard", icon: "mdi-clock", route:"/admin" },
      { text: "post", icon: "mdi-account", route: "/admin/postitems"},
      { text: "Conversions", icon: "mdi-flag", route: "/admin/postitems/test" }
    ]
  })
};
</script>
