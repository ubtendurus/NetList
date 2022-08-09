<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <groups-component></groups-component>
    <shopping-lists-component/>

  </div>
</template>

<script>
import GroupsComponent from '@/components/GroupsComponent.vue'
import ShoppingListsComponent from '@/components/ShoppingListsComponent.vue'


export default {
  name: "home",
  components: {
    GroupsComponent,
    ShoppingListsComponent
  
  }
}
</script>
