<template>
  <div>
    <ul v-for="item in filterItemsbyListId" v-bind:key="item.itemId">
      <li>{{ item.itemName }}</li>
      <li>{{ item.quantity }}</li>
      <li>{{ item.itemNote }}</li>
    </ul>
  </div>
</template>

<script>
import ItemService from "@/services/ItemService.js";
export default {
  name: "show-list-items-component",
  props: ["listId"],
  data() {
    return {
      items: [],
    };
  },
  created() {
    //console.log(this.listId);
    ItemService.getAllItems().then((response) => {
      this.items = response.data;
    });
  },
  computed: {
    filterItemsbyListId() {
      return this.items.filter((item) => item.listId === this.listId);
    },
  },
};
</script>

<style>
</style>
