<template>
  <div class="flex items-center justify-center py-8 mr-auto ml-auto">
    <form id="createItemForm" @submit.self="createItem()">
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
            placeholder:italic
          "
          v-model="item.itemName"
          required
          maxlength="35"
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
            placeholder:italic
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
            placeholder:italic
          "
          name="itemNote"
          v-model="item.itemNote"
          placeholder="Item Note"
          required
          maxlength="20"
          autofocus
          type="text"
        />
        <br />
        <label
          for="itemCategory"
          class="
            text-gray-800
            dark:text-gray-100
            text-sm
            font-bold
            leading-tight
            tracking-normal
            mb-2
          "
          >Category</label
        >
        <select
          id="itemCategory"
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
          v-model="selectedCategoryId"
          @change="assignCategoryId"
          required
        >
          <option
            :value="category.categoryId"
            v-for="category in categories"
            v-bind:key="category.categoryId"
          >
            {{ category.categoryName }}
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
      if (this.item.quantity >= 0) {
        itemService.createItem(this.item).then(() => {
          this.$router.go(this.$router.currentRoute, {
            params: { listId: this.item.listId },
          });
        });
      } else {
        alert("Quantity must be greater than 0");
      }
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
