<template>
  <body class="flex items-center justify-center py-8">
    <div class="w-full max-w-2xl px-4">
      <div
        class="border rounded-lg border pb-6 border-gray-200"
        v-if="items.length != 0"
      >
        <div class="px-6 pt-6 overflow-x-auto">
          <div class="flex items-center justify-end">
            <button
              class="text-lrg font-semibold leading-none text-right"
              :class="{ 'text-gray-600': markAll, 'text-green-800': !markAll }"
              @click.prevent="markAllDone()"
            >
              {{ markAll ? "Unmark All" : "Mark All" }}
            </button>
          </div>
          <table class="w-full whitespace-nowrap">
            <tbody v-for="item in items" class="group" v-bind:key="item.itemId">
              <tr tabindex="0" class="focus:outline-none">
                <td>
                  <div class="flex items-center">
                    <div class="bg-gray-100 rounded-sm p-2.5">
                      <img
                        width="28px"
                        height="28px"
                        src="..\assets\imgs\icons8-checklist-100.png"
                      />
                    </div>
                    <div class="pl-3">
                      <div class="flex items-center text-sm leading-none">
                        <p
                          class="font-semibold text-gray-800"
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
                          class="text-indigo-700 ml-3"
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
                          mt-2
                        "
                        :class="{ itemchecked: item.purchased }"
                      >
                        {{ item.itemNote }}
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
                      >
                        <input
                          type="checkbox"
                          id="isPurchased"
                          :value="item.itemId"
                          v-model="item.purchased"
                          @change.prevent="updateItem"
                        />
                      </p>
                      <p for="isPurchased" v-if="item.purchased">Completed</p>
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
                      "
                    >
                      <p
                        class="text-xs leading-3 text-red-700 cursor-pointer"
                        @click.self="deleteItem(item.itemId)"
                      >
                        Delete
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
    };
  },
  created() {
    //console.log(this.listId);
    this.getAllItems();
    this.checkMarkAll();
  },
  computed: {
    filterItemsbyListId() {
      return this.items.filter((item) => item.listId === this.listId);
    },
  },
  methods: {
    checkMarkAll() {
      this.items.forEach((item) => {
        if (item.purchased) {
          this.markAll = true;
        } else {
          this.markAll = false;
        }
      });
    },
    getAllItems() {
      ItemService.getAllItemByListId(this.listId).then((response) => {
        this.items = response.data;
      });
    },
    //update item in database when checkbox is checked
    updateItem(event) {
      let itemId = event.target.value;
      //let isPurchased = event.target.checked;
      ItemService.updateItemPurchased(itemId);
    },
    //delete item from database
    deleteItem(itemId) {
      ItemService.deleteItem(itemId).then(() => {
        this.$router.go(this.$router.currentRoute);
      });
    },
    markAllDone() {
      this.items.forEach((item) => {
        if (this.markAll) {
          item.purchased = false;
          ItemService.updateItemPurchased(item.itemId);
        } else {
          item.purchased = true;
          ItemService.updateItemPurchased(item.itemId);
        }
      });
      this.markAll = !this.markAll;
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