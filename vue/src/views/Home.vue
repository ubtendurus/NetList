<template>
  <div class="home">
    <div class="py-6 bg-gray-100 flex justify-center flex-col">
      <div 
      class="
        mb-5
        mt-5
        ml-auto
        mr-auto
        lg:text-6xl
        md:text-5xl
        text-4xl
        font-black
        leading-10
        text-center text-gray-800
        dark:text-white">
        <img
          width="250"
          viewBox="0 0 188 74"
          fill="none"
          style="border-radius: 1000px"
          src="https://img.icons8.com/clouds/344/checklist.png"
        />
        NetList
      </div>
      <div class="ml-auto mr-auto">
        <router-link :to="{ name: 'groups' }">
          <button
            class="
              mx-2
              my-2
              bg-white
              w-30
              transition
              duration-150
              ease-in-out
              hover:border-gray-900 hover:text-gray-900
              rounded
              border border-gray-800
              text-black
              px-16
              py-4
              text-2xl
              bg-blue-300
              focus:ring-2
              focus:ring-blue-100
              focus:bg-blue-100
            "
          >
            Click Here to Get Started

          </button>
          </router-link>
        </div>
        
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
