<template>
  <div class="home" >
  <div class="py-6 bg-gray-100 flex justify-center">
    <router-link :to="{ name: 'groups' }"><button class="mx-2 my-2 bg-white w-30 transition duration-150 ease-in-out hover:border-gray-900 hover:text-gray-900 rounded border border-gray-800 text-gray-800 px-16 py-4 text-xl">

    Get Started
    </button></router-link>

  </div>
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
