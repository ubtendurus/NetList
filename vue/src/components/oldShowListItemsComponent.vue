<template>
  <div>
    <form @change.prevent="updateItem">
      <table>
        <tr v-for="item in filterItemsbyListId" v-bind:key="item.itemId">
          <td>
            <p :class="{ itemchecked: item.purchased }">{{ item.itemName }}</p>
          </td>
          <td>
            <p :class="{ itemchecked: item.purchased }">{{ item.quantity }}</p>
          </td>
          <td>
            <p :class="{ itemchecked: item.purchased }">{{ item.itemNote }}</p>
          </td>
          <td>
            <p :class="{ itemchecked: item.purchased }">{{ item.itemId }}</p>
          </td>
          <td>
            <input
              type="checkbox"
              id="isPurchased"
              :value="item.itemId"
              v-model="item.purchased"
              @change.prevent="updateItem"
            />
          </td>
          <td for="isPurchased" v-if="item.purchased">
            <svg
              style="color: rgb(68, 255, 0)"
              xmlns="http://www.w3.org/2000/svg"
              xmlns:xlink="http://www.w3.org/1999/xlink"
              width="20"
              zoomAndPan="magnify"
              viewBox="0 0 30 30.000001"
              height="20"
              preserveAspectRatio="xMidYMid meet"
              version="1.0"
            >
              <defs>
                <clipPath id="id1">
                  <path
                    d="M 2.328125 4.222656 L 27.734375 4.222656 L 27.734375 24.542969 L 2.328125 24.542969 Z M 2.328125 4.222656 "
                    clip-rule="nonzero"
                    fill="#44ff00"
                  ></path>
                </clipPath>
              </defs>
              <g clip-path="url(#id1)">
                <path
                  fill="#44ff00"
                  d="M 27.5 7.53125 L 24.464844 4.542969 C 24.15625 4.238281 23.65625 4.238281 23.347656 4.542969 L 11.035156 16.667969 L 6.824219 12.523438 C 6.527344 12.230469 6 12.230469 5.703125 12.523438 L 2.640625 15.539062 C 2.332031 15.84375 2.332031 16.335938 2.640625 16.640625 L 10.445312 24.324219 C 10.59375 24.472656 10.796875 24.554688 11.007812 24.554688 C 11.214844 24.554688 11.417969 24.472656 11.566406 24.324219 L 27.5 8.632812 C 27.648438 8.488281 27.734375 8.289062 27.734375 8.082031 C 27.734375 7.875 27.648438 7.679688 27.5 7.53125 Z M 27.5 7.53125 "
                  fill-opacity="1"
                  fill-rule="nonzero"
                ></path>
              </g>
            </svg>
          </td>
        </tr>
        <tr>
          <td></td>
        </tr>
      </table>
    </form>
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
    //update item in database when checkbox is checked
    updateItem(event) {
      let itemId = event.target.value;
      //let isPurchased = event.target.checked;
      ItemService.updateItemPurchased(itemId);
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
