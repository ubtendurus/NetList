<template>
  <div>
    <edit-item-component :itemId="itemId"></edit-item-component>
  </div>
</template>

<script>
import EditItemComponent from "../components/EditItemComponent.vue";

export default {
  name: "edit-item",
  components: { EditItemComponent },
  data() {
    return {
      itemId: this.$route.params.itemId,
    };
  },
};
</script>

<style>
</style>
