<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <groups-component></groups-component>
    

  </div>
</template>

<script>
import GroupsComponent from '@/components/GroupsComponent.vue'

export default {
  name: "home",
  components: {
    GroupsComponent
  }
}
</script>
