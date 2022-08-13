<template>
  <div>
    <form @submit.prevent="createItem">
      <input disabled type="text" v-model="item.listId" />
      <label for="itemName">Item Name: </label>
      <input
        type="text"
        name="itemName"
        id="itemName"
        v-model="item.itemName"
        placeholder="Item Name"
      />
      <label for="itemQuantity">Item Quantity: </label>
      <input
        type="number"
        name="itemQuantity"
        id="itemQuantity"
        v-model="item.quantity"
        placeholder="Item Quantity"
      />
      <label for="itemDescription">Description: </label>
      <input
        type="text"
        name="itemDescription"
        id="itemDescription"
        v-model="item.itemDescription"
        placeholder="Description"
      />
      <label for="itemNote">Description: </label>
      <input
        type="text"
        name="itemNote"
        id="itemNote"
        v-model="item.itemNote"
        placeholder="Item Note"
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
  props: ["listId"],
  data() {
    return {
      selectedCategoryId: "",
      item: {
        itemName: "",
        itemDescription: "",
        categoryId: "",
        quantity: "",
        itemNote: "",
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
          this.$router.push("/shoppinglists");
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
    this.item.listId = this.$route.params.listId;
  },
};
</script>

<style>
</style>
