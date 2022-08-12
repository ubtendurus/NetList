<template>
  <div>
    <ul v-for="item in items" :key="item.itemId">
      <li>{{ item.itemName }}</li>
    </ul>
  </div>
</template>

<script>
import ItemService from "@/services/ItemService.js";
export default {
  name: "show-list-items-component",
  data() {
    return {
      items: {
        itemName: "",
        itemDescription: "",
        categoryId: "",
        quantity: "",
        itemNote: "",
        isPurchased: "",
      },
    };
  },
  created() {
    ItemService.getAll(this.listId).then((response) => {
      this.items = response.data;
    });
  },
};
</script>

<style>
</style>
