<template>
  <v-container
  class="pa-6 ma-2" align="center" justify-center>
    <div>
    <v-row cols="12" md="6" sm="6">
      <v-col cols="12" md="12" sm="12" align="center" justify="center">
    <v-card
    class="mx-auto"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <div class="text-overline mb-4">
          장바구니
        </div>
        <v-simple-table>
        <thead>
        <tr>
          <th class="text-left">
            번호
          </th>
          <th class="text-left">
            Name
          </th>
          <th class="text-left">
            Calories
          </th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="item in desserts"
          :key="item.name"
        > <td>{{ item.name }}</td>
          <td>{{ item.name }}</td>
          <td>{{ item.calories }}</td>
        </tr>
      </tbody>
      </v-simple-table>
      </v-list-item-content>
    </v-list-item>

      <v-btn
        to="/itemOrder"
        outlined
        rounded
        text
      >
        주문하기
      </v-btn>
  </v-card>
      </v-col>
    </v-row>
    </div>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
        desserts: [
          {
            name: 'Frozen Yogurt',
            calories: 159,
          },
          {
            name: 'Ice cream sandwich',
            calories: 237,
          },
          {
            name: 'Eclair',
            calories: 262,
          },
          {
            name: 'Cupcake',
            calories: 305,
          },
          {
            name: 'Gingerbread',
            calories: 356,
          },
          {
            name: 'Jelly bean',
            calories: 375,
          },
          {
            name: 'Lollipop',
            calories: 392,
          },
          {
            name: 'Honeycomb',
            calories: 408,
          },
          {
            name: 'Donut',
            calories: 452,
          },
          {
            name: 'KitKat',
            calories: 518,
          },
        ],
    }
  }
}
</script>