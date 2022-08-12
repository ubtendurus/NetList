<template>
  <div>
    <div>
      <add-item-component />
      TEST
    </div>
    <!-- <show-list-items-component /> -->
  </div>
</template>

<script>
//import ShowListItemsComponent from "@/components/ShowListItemsComponent.vue";
import AddItemComponent from "@/components/AddItemComponent.vue";
export default {
  name: "showlistitems",
  components: { AddItemComponent },
  //prop: ["listId"],
};
</script>

<style>
</style>
