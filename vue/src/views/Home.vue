<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <!-- <router-link :to="{ name: 'groups' }">Create a Group</router-link> -->
    <!--<groups-component></groups-component>-->
    <!-- <shopping-lists-component /> -->
    <add-item-component />
  </div>
</template>

<script>
//import GroupsComponent from "@/components/GroupsComponent.vue";
//import ShoppingListsComponent from "@/components/ShoppingListsComponent.vue";
import AddItemComponent from "@/components/AddItemComponent.vue";

export default {
  name: "home",
  components: {
    //GroupsComponent,
    //ShoppingListsComponent,
    AddItemComponent,
  },
};
</script>
