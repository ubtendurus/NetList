<template>
  <div>
    <form id="createListForm" @submit.prevent="createList()">
      <label for="listName">List Name: </label>
      <input
        type="text"
        id="listName"
        placeholder="List Name"
        v-model="lists.listName"
        required
        autofocus
      />
      <button type="submit">Create List</button>
    </form>
  </div>
</template>

<script>
import shoppingListsService from "@/services/ShoppingListsService.js";

export default {
  name: "shopping-lists-component",
  data() {
    return {
      lists: {
        listName: "",
      },
    };
  },

  methods: {
    createList() {
      shoppingListsService.create(this.lists).then((response) => {
        if (response.status === 201) {
          this.$router.push({ name: "home" });
        }
        this.lists = response.data;
      });
    },
  },
};
</script>

<style>
</style>
