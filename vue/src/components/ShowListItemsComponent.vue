<template>
  <div>
    <table>

      <tr v-for="item in filterItemsbyListId" v-bind:key="item.itemId">
        <td>{{ item.itemName }}</td>
        <td>{{ item.quantity }}</td>
        <td>{{ item.itemNote }}</td>
        <td>{{ item.itemId }}</td>
        <td>
          <form>
            <label for="isPurchased">Purchased</label>
            <input type="checkbox" id="isPurchased" v-model="item.isPurchased" @change.prevent="updateItem"/>
          </form>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
import ItemService from "@/services/ItemService.js";
export default {
  name: "show-list-items-component",
  props: ["listId"],
  data() {
    return {
      items: [],
    };
  },
  created() {
    //console.log(this.listId);
    ItemService.getAllItems().then((response) => {
      this.items = response.data;
    });
  },
  computed: {
    filterItemsbyListId() {
      return this.items.filter((item) => item.listId === this.listId);
    },
  },
  methods: {
    updateItem() {
      ItemService.updateItem(this.item).then((response) => {
        this.item = response.data;
      })
    }
  }
};
</script>

<style>
</style>
