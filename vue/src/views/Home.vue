<template>
  <div class="home">
    <!-- <h1>Home</h1>
    <p>You must be authenticated to see this</p> -->
    <front-1-component />
    <front-2-component />
    <front-3-component />
    <!-- <router-link :to="{ name: 'groups' }">Create a Group</router-link> -->
    <!--<groups-component></groups-component>-->
    <!-- <shopping-lists-component /> -->
    <!-- <add-item-component /> -->
  </div>
</template>

<script>
//import GroupsComponent from "@/components/GroupsComponent.vue";
//import ShoppingListsComponent from "@/components/ShoppingListsComponent.vue";
//import AddItemComponent from "@/components/AddItemComponent.vue";
import front1Component from "@/components/FrontPageComponent1.vue";
import front2Component from "@/components/FrontPageComponent2.vue";
import front3Component from "@/components/FrontPageComponent3.vue";

export default {
  name: "home",
  components: {
    front1Component,
    front2Component,
    front3Component,
    //GroupsComponent,
    //ShoppingListsComponent,
    //AddItemComponent,
  },
};
</script>
