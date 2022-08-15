<template>
  <body class="flex items-center justify-center py-8">
    <div>
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
            lg:text-xl
            font-semibold
            leading-tight
            text-gray-800
            mr-8
          "
        >
          {{getListName(listId).listName}}
        </p>
        
        <button
          @click="
            showAddItem = !showAddItem;
            showTransferList = false;
          "
          class="
            focus:outline-none
            focus:ring-2
            focus:ring-indigo-700
            focus:bg-indigo-50
            flex
            cursor-pointer
            items-center
            justify-center
            px-3
            py-2.5
            border
            rounded
            border-gray-100
          "
        >
          <p
            class="
              focus:outline-none
              text-xs
              md:text-sm
              leading-none
              text-gray-600
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
      <div
        v-if="showTransferList"
        class="
          flex
          items-center
          border-b border-gray-200
          justify-between
          px-6
          py-3
        "
      >
        <transfer-list-component v-bind:listId="listId" :groupId="groupId" />
      </div>
      <show-list-items-component v-bind:listId="listId" />
    </div>
  </body>
</template>

<script>
import ShowListItemsComponent from "@/components/ShowListItemsComponent.vue";
import AddItemComponent from "@/components/AddItemComponent.vue";
import TransferListComponent from "@/components/TransferListComponent.vue";
import ShoppingListsService from "@/services/ShoppingListsService.js";

export default {
  name: "show-list-items",
  components: {
    AddItemComponent,
    ShowListItemsComponent,
    TransferListComponent,
  },
  data() {
    return {
      showAddItem: false,
      showTransferList: false,
      listId: 0,
      groupId: 0,
      lists: []
    };
  },
  created() {
    this.listId = this.$route.params.listId;
    this.groupId = this.$route.params.groupId;
    ShoppingListsService.getAll().then(
      (response) => 
        {this.lists = response.data
        })
  },
  methods: {
    getListName(listId) {
      return this.lists.find(
        (x) => 
      x.listId === listId
      )
    }
  }
};
</script>

<style>
</style>
