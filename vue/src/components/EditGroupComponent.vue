<template>
  <div class="flex items-center justify-center py-8 mr-auto ml-auto">
    <div class="flex flex-col md:mr-16">
      <form id="editGroupForm" @submit.prevent="updateGroup()">
        <div>
          <label
            for="groupName"
            class="
              text-gray-800
              dark:text-gray-100
              text-sm
              font-bold
              leading-tight
              tracking-normal
              mb-2
            "
            >Change Group Name:</label
          >
          <input
            id="groupName"
            v-model="group.groupName"
            required
            autofocus
            placeholder="Enter a new name for the group"
            class="
              text-gray-600
              dark:text-gray-400
              focus:outline-none focus:border focus:border-indigo-700
              dark:focus:border-indigo-700 dark:border-gray-700 dark:bg-gray-800
              bg-white
              font-normal
              w-64
              h-10
              flex
              items-center
              pl-3
              text-sm
              border-gray-300
              rounded
              border
              shadow
              mt-2
            "
            maxlength="25"
          />
          <br />
          <label
              for="groupOwner"
              class="
                text-gray-800
                dark:text-gray-100
                text-sm
                font-bold
                leading-tight
                tracking-normal
                mb-2
              "
              >Assign New Group Owner:</label
            >
          <div v-if="users.length > 0">
            <select
              id="groupOwner"
              class="
                text-gray-600
                dark:text-gray-400
                focus:outline-none focus:border focus:border-indigo-700
                dark:focus:border-indigo-700
                dark:border-gray-700
                dark:bg-gray-800
                bg-white
                font-normal
                w-64
                h-10
                flex
                items-center
                pl-3
                text-sm
                border-gray-300
                rounded
                border
                shadow
              "
              v-model="selectedOwnerId"
              @change="assignedOwnerId"
            >
              <option v-for="user in users" :key="user.id" :value="user.id">
                {{ user.username }}
              </option>
            </select>
          </div>
          <div v-else>
            <p class="text-base text-red-500 text-center mt-2">No Other Members In Group</p>
          </div>
          <button
            type="submit"
            class="
              mt-8
              ml-auto
              mr-auto
              focus:outline-none
              focus:ring-2
              focus:ring-indigo-400
              focus:bg-indigo-400
              flex
              cursor-pointer
              items-center
              justify-center
              px-3
              py-2.5
              border
              rounded
              border-gray-100
              bg-indigo-500
              text-white
            "
          >
            Update Group
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import GroupService from "@/services/GroupsService.js";
export default {
  name: "edit-group-component",
  data() {
    return {
      group: {
        groupName: "",
        ownerId: 0,
      },
      users: [],
      groupId: 0,
      selectedOwnerId: 0,
    };
  },
  methods: {
    updateGroup() {
      GroupService.updateGroup(this.groupId, this.group).then(() => {
        this.$router.push("/groups");
      });
    },
    getGroupUsers() {
      GroupService.getGroupUsers(this.groupId).then((response) => {
        this.users = response.data;
      });
    },
    getGroupById() {
      GroupService.getGroupById(this.groupId).then((response) => {
        this.group = response.data;
        this.selectedOwnerId = this.group.ownerId;
      });
    },
    assignedOwnerId() {
      this.group.ownerId = this.selectedOwnerId;
    },
  },
  created() {
    this.groupId = this.$route.params.groupId;
    this.getGroupUsers();
    this.getGroupById();
  },
};
</script>

<style>
</style>
