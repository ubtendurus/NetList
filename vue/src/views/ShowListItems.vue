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
            text-sm
            lg:text-xl
            font-semibold
            leading-tight
            text-gray-800
          "
        >
          Item List
        </p>
        <button
          @click="
            showTransferList = !showTransferList;
            showAddItem = false;
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
            Transfer List
          </p>
        </button>
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
            Add item
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
    };
  },
  created() {
    this.listId = this.$route.params.listId;
    this.groupId = this.$route.params.groupId;
  },
};
</script>

<style>
</style>
