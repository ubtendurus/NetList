<template>
  <div class="flex items-center justify-center py-8 mr-auto ml-auto">
    <form id="createListForm" @submit.self="createList()">
      <div class="flex flex-col md:mr-16">
        <label
          for="listName"
          class="
            text-gray-800
            dark:text-gray-100
            text-sm
            font-bold
            leading-tight
            tracking-normal
            mb-2
          "
          >List Name:</label
        >
        <input
          id="listName"
          class="
            text-gray-600
            dark:text-gray-400
            focus:outline-none focus:border focus:border-indigo-700
            dark:focus:border-indigo-700 dark:border-gray-700 dark:bg-gray-800
            bg-white
            font-normal
            w-64
            h-10
            flex
            items-center
            pl-3
            text-sm
            border-gray-300
            rounded
            border
            shadow
          "
          v-model="lists.listName"
          required
          autofocus
          placeholder="List Name"
        />
        <br />
        <label
          for="group"
          class="
            text-gray-800
            dark:text-gray-100
            text-sm
            font-bold
            leading-tight
            tracking-normal
            mb-2
          "
          >Select Group to Create List For:</label
        >
        <select
          id="groups"
          class="
            text-gray-600
            dark:text-gray-400
            focus:outline-none focus:border focus:border-indigo-700
            dark:focus:border-indigo-700 dark:border-gray-700 dark:bg-gray-800
            bg-white
            font-normal
            w-64
            h-10
            flex
            items-center
            pl-3
            text-sm
            border-gray-300
            rounded
            border
            shadow
          "
          name="group"
          v-model="lists.groupId"
          required
        >
          <option
            :value="group.groupId"
            v-for="group in groups"
            v-bind:key="group.groupId"
          >
            {{ group.groupName }}
          </option>
        </select>
        <button
          type="submit"
          class="
            mt-8
            ml-auto
            mr-auto
            focus:outline-none
            focus:ring-2
            focus:ring-indigo-400
            focus:bg-indigo-400
            flex
            cursor-pointer
            items-center
            justify-center
            px-3
            py-2.5
            border
            rounded
            border-gray-100
            bg-indigo-500
          "
        >
          <p
            class="
              focus:outline-none
              text-xs
              md:text-sm
              leading-none
              text-white
            "
          >
            Create
          </p>
        </button>
      </div>
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
          this.$router.push({
            name: "shopping-lists",
            params: { listId: response.data.listId },
          });
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
