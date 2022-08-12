<template>
  <div>
    <form @submit.prevent="createItem">
      <label for="itemName">Item Name: </label>
      <input
        type="text"
        name="itemName"
        id="itemName"
        v-model="item.itemName"
        placeholder="Item Name"
      />
      <label for="itemDescription">Description: </label>
      <input
        type="text"
        name="itemDescription"
        id="itemDescription"
        v-model="item.itemDescription"
        placeholder="Description"
      />
      <label for="itemCategory">Category: </label>
      <select v-model="selectedCategoryId" @change="assignCategoryId">
        <option
          :value="category.categoryId"
          v-for="category in categories"
          v-bind:key="category.categoryId"
        >
          {{ category.categoryName }}
        </option>
      </select>
      <button type="submit">Add Item</button>
    </form>
  </div>
</template>

<script>
import itemService from "@/services/ItemService.js";
export default {
  name: "add-item-component",
  data() {
    return {
      selectedCategoryId: "",
      item: {
        itemName: "",
        itemDescription: "",
        categoryId: "",
      },
      categories: {
        categoryId: "",
        categoryName: "",
      },
    };
  },
  methods: {
    createItem() {
      itemService.createItem(this.item).then((response) => {
        if (response.status === 201) {
          this.$router.push({ name: "groups" });
        }
      });
    },
    assignCategoryId() {
      this.item.categoryId = this.selectedCategoryId;
    },
  },
  created() {
    itemService.getAllCategories().then((response) => {
      this.categories = response.data;
    });
  },
};
</script>

<style>
</style>
