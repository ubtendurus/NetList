<template>
  <body class="flex items-center justify-center py-8">
    <div class="w-1/2">
      <div
        class="
          flex
          items-center
          border-b border-gray-200
          justify-between
          px-6
          py-3
        "
      >
        <p
          tabindex="0"
          class="
            focus:outline-none
            text-2xl
            lg:text-2xl
            font-semibold
            leading-tight
            text-gray-800
            mr-8
          "
        >
          {{ getListName(listId).listName }}
        </p>

        <button
          @click="
            showAddItem = !showAddItem;
            showTransferList = false;
          "
          class="
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
            Add Item
          </p>
        </button>
      </div>
      
      <div
        v-if="showAddItem"
        class="
          flex
          items-center
          border-b border-gray-200
          justify-between
          px-6
          py-3
        "
      >
        <add-item-component v-bind:listId="listId" />
      </div>
      
      <show-list-items-component v-bind:listId="listId" />
    </div>
  </body>
</template>

<script>
import ShowListItemsComponent from "@/components/ShowListItemsComponent.vue";
import AddItemComponent from "@/components/AddItemComponent.vue";
import ShoppingListsService from "@/services/ShoppingListsService.js";

export default {
  name: "show-list-items",
  components: {
    AddItemComponent,
    ShowListItemsComponent,
  },
  data() {
    return {
      listName: "",
      showAddItem: false,
      showTransferList: false,
      listId: 0,
      groupId: 0,
      lists: [],
    };
  },
  created() {
    this.listId = this.$route.params.listId;
    this.groupId = this.$route.params.groupId;
    this.getAllLists();
    //list name
    //this.listName = this.getListName(this.listId).listName;
  },
  methods: {
    //get list name and set list name
    getListName(listId) {
      return this.lists.find((list) => list.listId == listId);
    },
    getAllLists() {
      ShoppingListsService.getAll().then((response) => {
        this.lists = response.data;
      });
    },
  },
};
</script>

<style>
</style>
