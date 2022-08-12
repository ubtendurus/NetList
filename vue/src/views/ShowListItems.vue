<template>
  <div>
    <div>
      <add-item-component />
    </div>
    <show-list-items-component />
  </div>
</template>

<script>
import ShowListItemsComponent from "@/components/ShowListItemsComponent.vue";
import AddItemComponent from "@/components/AddItemComponent.vue";
export default {
  name: "show-list-items",
  components: { AddItemComponent, ShowListItemsComponent },
  prop: ["listId"],
};
</script>

<style>
</style>
