<template>
  <div>
    <form id="createGroupForm" @submit.prevent="createGroup()">
      <label for="groupName">Group Name: </label>
      <input 
      type = "text" 
      id = "groupName"
      placeholder="Group Name" 
      v-model="groups.groupName" 
      required 
      autofocus />
      <button type="submit">Create Group</button>
    </form>
  </div>
</template>

<script>
import groupsService from '@/services/GroupsService.js'

export default {
    name: 'groups-component',
    data() {
      return {
        groups: {
          groupName: ""
        }
      }
    },
    methods: {
      createGroup() {
        groupsService.create(this.groups).then(
          (response) => {
            if (response.status === 201) {
              this.$router.push({name: "home"})
            }
            this.groups = response.data;
          }
        )
      }
    }

}
</script>

<style>

</style>