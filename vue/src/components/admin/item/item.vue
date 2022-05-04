<template>
  <div>
    <v-data-table :headers="headers" :items="items" class="elevation-1">
    </v-data-table>
    <v-btn color="primary" dark v-bind="attrs" v-on="on" to="/admin/postitems"
      >아이템 등록</v-btn
    >
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      headers: [
        {
          text: "이름",
          align: "start",
          sortable: false,
          value: "name"
        },
        { text: "브랜드", value: "brand" },
        { text: "색상", value: "color" },
        { text: "제조국", value: "country" },
        { text: "가격", value: "price" },
        { text: "사이즈", value: "size" },
        { text: "수량", value: "stock" }
      ],
      items: []
    };
  },
  methods: {
    fetchItem() {
      axios
        .get("http://localhost:8080/item/")
        .then(response => {
          console.log(response);
          this.items = response.data.list;
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  mounted() {
    this.fetchItem();
  }
};
</script>
