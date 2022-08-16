<template>
  <div>
    <edit-list-component :listId="listId" />
  </div>
</template>

<script>
import EditListComponent from "../components/EditShoppingListsComponent.vue";

export default {
  name: "edit-list",
  components: { EditListComponent },
  data() {
    return {
      listId: this.$route.params.listId,
    };
  },
};
</script>

<style>
</style>
