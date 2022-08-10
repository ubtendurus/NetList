<template>
  <!--list shopping list-->
  <div>
    <shopping-lists-user-component/>
  </div>
</template>

<script>
import ShoppingListsUserComponent from '@/components/ShoppingListsUserComponent.vue';
export default {
  name: "shopping-lists",
  components: {
    ShoppingListsUserComponent
  },
};
</script>

<style>
</style>
