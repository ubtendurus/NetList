<template>
  <div class="flex items-center justify-center py-8 mr-auto ml-auto">
    <form id="createItemForm" @submit.prevent="updateItem()">
      <div class="flex flex-col md:mr-16">
        <label
          for="itemName"
          class="
            text-gray-800
            dark:text-gray-100
            text-sm
            font-bold
            leading-tight
            tracking-normal
            mb-2
          "
          >Item Name</label
        >
        <input
          id="itemName"
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
          v-model="item.itemName"
          required
          autofocus
          placeholder="Item Name"
        />
        <br />
        <label
          for="itemQuantity"
          class="
            text-gray-800
            dark:text-gray-100
            text-sm
            font-bold
            leading-tight
            tracking-normal
            mb-2
          "
          >Quantity</label
        >
        <input
          id="itemQuantity"
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
          name="itemQuantity"
          v-model="item.quantity"
          placeholder="Item Quantity"
          required
          autofocus
          type="number"
        />
        <br />
        <label
          for="itemNote"
          class="
            text-gray-800
            dark:text-gray-100
            text-sm
            font-bold
            leading-tight
            tracking-normal
            mb-2
          "
          >Note</label
        >
        <input
          id="itemNote"
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
          name="itemNote"
          v-model="item.itemNote"
          placeholder="Item Note"
          required
          autofocus
          type="text"
        />
        <button
          type="submit"
          class="
            mt-8
            ml-auto
            mr-auto
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
            Update Item
          </p>
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import itemService from "@/services/ItemService.js";
export default {
  name: "edit-item-component",
  props: ["itemId"],
  data() {
    return {
      item: {
        itemName: "",
        itemDescription: "",
        quantity: "",
        itemNote: "",
      },
    };
  },
  methods: {
    updateItem() {
      if (this.item.quantity >= 0) {
        itemService.updateItem(this.itemId, this.item).then(() => {
          this.$router.go(-1);
        });
      } else {
        alert("Quantity must be greater than 0");
      }
    },
  },
  created() {
    itemService.getItemById(this.itemId).then((item) => {
      this.item = item.data;
      this.selectedCategoryId = this.item.categoryId;
    });
    this.item.listId = this.$route.params.listId;
  },
};
</script>

<style>
</style>
