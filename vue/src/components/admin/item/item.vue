<template>
  <div>
    <v-data-table :headers="headers" :items="items" class="elevation-1" show-select single-select v-model="selected">
    </v-data-table>
    <v-btn color="primary" dark to="postitems"
      >아이템 등록</v-btn
    >
     <v-btn color="primary" dark to="updateitems" @click="fetchOneItem()"
      >아이템 수정</v-btn
    >
    <v-btn color="primary" dark @click="deleteItem()"
      >아이템 삭제</v-btn
    >
    <!-- to="/admin/item/updateitems"  -->
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
          value: 'name'
        },
        { text: "브랜드", value: 'brand' },
        { text: "색상", value: 'color' },
        { text: "제조국", value: 'country' },
        { text: "가격", value: 'price' },
        { text: "사이즈", value: 'size' },
        { text: "수량", value: 'stock' },
        { text: "별점", value: 'stars'}
      ],
      items: [],
      selected: [],
    };
  },
  methods: {
    fetchItem() {
      axios
        .get("http://localhost:8080/item/")
        .then(response => {
          this.items = response.data.list;
        })
        .catch(error => {
          console.log(error);
        });
    }, 
    fetchOneItem(){
    axios
    .get("http://localhost:8080/item/"+ this.selected[0].id)
    .then(response => {
      console.log(response)

    })
    .catch(error => {
      console.log(error)
    })
  },
  deleteItem(){
    axios.delete("http://localhost:8080/item/" + this.selected[0].id)
    .then(response => {
      console.log(response);
      alert(response.data.msg);
      this.fetchItem();
    })
    .catch(response =>{
      alert(response.data.msg)
    })
  }
  },
  mounted() {
    this.fetchItem();
  }
};
</script>
