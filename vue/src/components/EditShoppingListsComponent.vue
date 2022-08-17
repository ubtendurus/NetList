<template>
  <div class="flex items-center justify-center py-8 mr-auto ml-auto">
    <div class="flex flex-col md:mr-16">
      <form id="editListForm" @submit.prevent="updateList()">
        <div>
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
            >Change List Name:</label
          >
          <input
            id="listName"
            v-model="list.listName"
            required
            autofocus
            maxlength="25"
            placeholder="Enter a new name for the list"
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
          />
          <br />
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
              text-white
            "
          >
            Update List
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import ShoppingListsService from "@/services/ShoppingListsService.js";
export default {
  name: "edit-list-component",
  data() {
    return {
      listId: 0,
      list: [],
    };
  },
  methods: {
    updateList() {
      ShoppingListsService.updateList(this.listId, this.list).then(() => {
        this.$router.push({
          // name: "show-list-items",
          name: "shopping-lists",
          params: { listId: this.listId },
        });
      });
    },
    getListById() {
      ShoppingListsService.getListById(this.listId).then((response) => {
        this.list = response.data;
      });
    },
  },
  created() {
    this.listId = this.$route.params.listId;
    this.getListById();
  },
};
</script>

<style>
</style>
