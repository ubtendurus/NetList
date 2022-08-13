<template>
  <div>
    <form id="createListForm" @submit.self="createList()">
      <label for="listName">List Name: </label>
      <input
        type="text"
        id="listName"
        placeholder="List Name"
        v-model="lists.listName"
        required
        autofocus
      />
      <label for="group">Select a Group:</label>

      <select name="group" id="groups" v-model="lists.groupId">
        <option
          :value="group.groupId"
          v-for="group in groups"
          v-bind:key="group.groupId"
        >
          {{ group.groupName }}
        </option>
      </select>
      <button type="submit">Create List</button>
    </form>
  </div>
</template>

<script>
import shoppingListsService from "@/services/ShoppingListsService.js";
import groupsService from "@/services/GroupsService.js";

export default {
  name: "shopping-lists-component",
  data() {
    return {
      lists: {
        listName: "",
        groupId: "",
      },
      groups: {},
    };
  },

  methods: {
    createList() {
      shoppingListsService.create(this.lists).then((response) => {
        if (response.status === 201) {
          this.$router.push({ name: "shopping-lists" });
        }
        this.lists = response.data;
      });
    },
  },
  created() {
    groupsService.getAll().then((response) => {
      this.groups = response.data;
    });
  },
};
</script>

<style>
</style>
