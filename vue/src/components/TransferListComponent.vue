<template>
  <div>
    <label
      for="user-name"
      class="block text-sm font-medium leading-5 text-gray-700"
    >
      Select user</label
    >
    <select name="user-name" id="user-name">
      <option v-for="user in users" v-bind:key="user.userId">
        {{ user.userName }}
        Test
      </option>
    </select>
  </div>
</template>

<script>
//import groupsService from '@/services/GroupsService.js'
//import usersService from '@/services/UsersService.js'

export default {
  name: "transfer-list-component",
  //props: ["listId"],
  data() {
    return {
      listId: 0,
      groupId: 0,
    };
  },
  created() {
    this.listId = this.$route.params.listId;
    this.groupId = this.$route.params.groupId;
  },
};
</script>

<style>
</style>
