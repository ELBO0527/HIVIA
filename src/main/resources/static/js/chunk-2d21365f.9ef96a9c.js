(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d21365f"],{ad06:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("v-data-table",{staticClass:"elevation-1",attrs:{headers:e.headers,items:e.itemsList,"show-select":"","single-select":""},model:{value:e.selected,callback:function(t){e.selected=t},expression:"selected"}}),a("v-btn",{attrs:{color:"primary",dark:"",to:"postitems"}},[e._v("아이템 등록")]),a("v-btn",{attrs:{color:"primary",dark:"",to:"updateitems"},on:{click:function(t){return e.fetchOneItem(e.selected[0].id)}}},[e._v("아이템 수정")]),a("v-btn",{attrs:{color:"primary",dark:""},on:{click:function(t){return e.deleteItem(e.selected[0].id)}}},[e._v("아이템 삭제")])],1)},c=[],l=a("5530"),n=a("2f62"),r={data:function(){return{headers:[{text:"이름",align:"start",sortable:!1,value:"name"},{text:"브랜드",value:"brand"},{text:"색상",value:"color"},{text:"제조국",value:"country"},{text:"가격",value:"price"},{text:"사이즈",value:"size"},{text:"수량",value:"stock"},{text:"별점",value:"stars"}],selected:[]}},methods:Object(l["a"])({},Object(n["b"])(["fetchItems","deleteItem","fetchOneItem"])),computed:Object(n["c"])(["itemsList"]),mounted:function(){this.fetchItems()}},o=r,i=a("2877"),u=a("6544"),d=a.n(u),m=a("8336"),v=a("8fea"),f=Object(i["a"])(o,s,c,!1,null,null,null);t["default"]=f.exports;d()(f,{VBtn:m["a"],VDataTable:v["a"]})}}]);
//# sourceMappingURL=chunk-2d21365f.9ef96a9c.js.map