<template>
  <div>
    <div>
      <add-item-component v-bind:listId="listId" />
    </div>
    <show-list-items-component v-bind:listId="listId" />
  </div>
</template>

<script>
import ShowListItemsComponent from "@/components/ShowListItemsComponent.vue";
import AddItemComponent from "@/components/AddItemComponent.vue";
export default {
  name: "show-list-items",
  components: { AddItemComponent, ShowListItemsComponent },
  data() {
    return {
      listId: 0,
    };
  },
  created() {
    this.listId = this.$route.params.listId;
  },
};
</script>

<style>
</style>
