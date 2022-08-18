<template>
  <body class="flex items-center justify-center py-8">
    <div class="w-full max-w-7xl px-4">
      <p
        v-if="selectedGroupId != 0"
        class="
          text-gray-600
          dark:text-gray-100
          text-base
          font-semibold
          leading-tight
          tracking-normal
          mb-2
          ml-auto
          mr-auto
          text-center
        "
      >
        <em>Click on an item to edit its details.</em>
      </p>
      <div
        v-if="items.length === 0"
        class="border rounded-lg border pb-6 border-gray-200"
      >
        <p
          v-if="items.length === 0"
          class="
            text-gray-400
            dark:text-gray-100
            text-sm
            leading-tight
            tracking-normal
            ml-3
            mr-3
            mt-5
            text-center
          "
        >
          Your items will display here after creating them!
        </p>
      </div>
      <div
        class="border rounded-lg border pb-6 border-gray-200"
        v-if="items.length != 0"
      >
        <div class="px-6 pt-2 overflow-x-auto">
          <div
            class="flex items-center justify-end border-b border-gray-200 p-2"
            v-if="markAll"
          >
            <button
              class="
                text-lrg
                font-semibold
                leading-none
                text-right
                rounded
                border border-gray-800
                px-2
                py-2
                text-white
              "
              :class="{
                'text-white bg-red-700': markAll,
                'text-white bg-green-600': !markAll,
              }"
              @click.prevent="markAllUnDone()"
            >
              Mark All Undone
            </button>
          </div>
          <div
            class="flex items-center justify-end border-b border-gray-200 p-2"
            v-else
          >
            <button
              class="
                text-lrg
                font-semibold
                leading-none
                text-right
                rounded
                border border-gray-800
                px-2
                py-2
                text-white
              "
              :class="{
                'text-white bg-red-700': markAll,
                'text-white bg-green-600': !markAll,
              }"
              @click.prevent="markAllDone()"
            >
              Mark All Done
            </button>
          </div>
          <table class="w-full whitespace-nowrap">
            <tbody v-for="item in items" class="group" v-bind:key="item.itemId">
              <tr
                tabindex="0"
                class="focus:outline-none border-b border-gray-200"
              >
                <td class="p-5">
                  <div class="flex items-center">
                    <div class="rounded-sm p-1.5">
                      <img
                        width="56px"
                        height="56px"
                        src="https://img.icons8.com/clouds/452/forward.png"
                      />
                    </div>
                    <div class="pl-3">
                      <div class="flex items-center text-sm leading-none">
                        <p
                          class="font-semibold text-gray-800 text-lg"
                          :class="{ itemchecked: item.purchased }"
                        >
                          <router-link
                            :to="{
                              name: 'edit-item',
                              params: {
                                itemId: item.itemId,
                                groupId: item.groupId,
                              },
                            }"
                          >
                            {{ item.itemName }}</router-link
                          >
                        </p>
                        <p
                          class="text-indigo-700 ml-10"
                          :class="{ itemchecked: item.purchased }"
                        >
                          Quantity: {{ item.quantity }}
                        </p>
                      </div>
                      <p
                        class="
                          text-xs
                          md:text-sm
                          leading-none
                          text-gray-600
                          mt-1
                        "
                        :class="{ itemchecked: item.purchased }"
                      >
                        Note : {{ item.itemNote }}
                      </p>
                      <p
                        class="text-xs md:text-sm leading-none text-gray-600"
                        :class="{ itemchecked: item.purchased }"
                      >
                        Category :
                        {{ getCategoryName(item.categoryId).categoryName }}
                      </p>
                    </div>
                  </div>
                </td>
                <td class="pl-16">
                  <div>
                    <div
                      class="
                        flex
                        items-center
                        justify-center
                        px-2
                        py-1
                        mt-2
                        bg-green-100
                        rounded-full
                      "
                    >
                      <p
                        class="
                          text-sm
                          font-semibold
                          leading-none
                          text-right text-green-800
                        "
                        :class="{ itemchecked_button: item.purchased }"
                      >
                        <input
                          type="checkbox"
                          class="cursor-pointer"
                          id="isPurchased"
                          :value="item.itemId"
                          v-model="item.purchased"
                          @change.prevent="updateItem(item.itemId, item)"
                        />
                      </p>
                      <p
                        class="
                          ml-3
                          text-xs
                          font-semibold
                          leading-3
                          text-green-700
                        "
                        for="isPurchased"
                        v-if="item.purchased"
                      >
                        Done!
                      </p>
                      <p
                        class="
                          ml-3
                          text-xs
                          font-semibold
                          leading-3
                          text-green-700
                        "
                        for="isPurchased"
                        v-else
                      >
                        Done?
                      </p>
                    </div>

                    <div
                      class="
                        flex
                        items-center
                        justify-center
                        px-2
                        py-1
                        mt-2
                        bg-red-100
                        rounded-full
                        text-xs
                        font-semibold
                        cursor-pointer
                      "
                      @click.self="deleteItem(item.itemId)"
                    >
                      <p
                        class="text-xs leading-3 text-red-700 cursor-pointer"
                        @click.self="deleteItem(item.itemId)"
                      >
                        Delete Item
                      </p>
                    </div>
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
import ItemService from "@/services/ItemService.js";
export default {
  name: "show-list-items-component",
  props: ["listId"],
  data() {
    return {
      markAll: false,
      items: [],
      categories: [],
    };
  },
  created() {
    //console.log(this.listId);
    this.getAllItems();
    this.checkMarkAll();
    this.getAllCategories();
  },
  computed: {
    filterItemsbyListId() {
      return this.items.filter((item) => item.listId === this.listId);
    },
  },
  methods: {
    getAllCategories() {
      ItemService.getAllCategories().then((response) => {
        this.categories = response.data;
      });
    },
    //match category id with category name
    getCategoryName(categoryId) {
      return this.categories.find(
        (category) => category.categoryId === categoryId
      );
    },
    getAllItems() {
      ItemService.getAllItemByListId(this.listId).then((response) => {
        this.items = response.data;
      });
    },
    //update item in database when checkbox is checked
    updateItem(itemId, item) {
      //let itemId = event.target.value;
      //let isPurchased = event.target.checked;
      //find item in array by itemId
      //let item = this.items.find((item) => item.itemId === itemId);
      ItemService.updateItemPurchased(itemId, item);
    },
    //delete item from database
    deleteItem(itemId) {
      ItemService.deleteItem(itemId).then(() => {
        this.$router.go(this.$router.currentRoute);
      });
    },
    markAllDone() {
      this.items.forEach((item) => {
        item.purchased = true;
        this.updateItem(item.itemId, item);
      });
      this.markAll = true;
    },
    markAllUnDone() {
      this.items.forEach((item) => {
        item.purchased = false;
        this.updateItem(item.itemId, item);
      });
      this.markAll = false;
    },
    checkMarkAll() {
      ItemService.getAllItemByListId(this.listId).then((response) => {
        //check if all items are purchased
        if (response.data.every((item) => item.purchased === true)) {
          this.markAll = true;
        } else {
          this.markAll = false;
        }
      });
    },
  },
};
</script>

<style scoped>
.itemchecked {
  text-decoration: line-through;
  color: #ccc;
}
</style>
