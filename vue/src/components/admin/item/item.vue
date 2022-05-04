<template>
  <v-data-table
    :headers="headers"
    :items="items"
    class="elevation-1"
  >
    <template v-slot:item.stock="{ item }">
      <v-chip
        :color="getColor(item.stock)"
        dark
        @click="fetchItem()"
      >
        {{ item.stock }}
      </v-chip>
    </template>
  </v-data-table>
</template>

<script>
import axios from 'axios';
  export default {
    data () {
      return {
        headers: [
          {
            text: '이름',
            align: 'start',
            sortable: false,
            value: 'name',
          },
          { text: '브랜드', value: 'brand' },
          { text: '색상', value: 'color' },
          { text: '제조국', value: 'country' },
          { text: '가격', value: 'price' },
          { text: '사이즈', value: 'size' },
          { text: '수량', value: 'stock' },
        ],
        items : [
          {
            name : "",
            brand : "",
            color : "",
            country: "",
            price : "",
            size : "",
            stock: ""
          }
        ]
        ,
      }
    },
    methods: {
      getColor (calories) {
        if (calories > 400) return 'red'
        else if (calories > 200) return 'orange'
        else return 'green'
      },
       fetchItem() {
        axios.get('http://localhost:8080/item/')
        .then(function(response){
          console.log(response)
          this.items = response.data.list;
        })
        .catch(function(error){
          console.log(error)
        });
      }
    },
    created(){
      this.fetchItem()
    }
    
  }
</script>