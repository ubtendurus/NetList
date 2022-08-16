<template>
  <body class="flex items-center justify-center py-8">
    <div class="groups w-1/2">
      <div
        class="
          flex
          items-center
          border-b border-gray-200
          justify-between
          px-6
          py-3
        "
      >
        <p
          tabindex="0"
          class="
            focus:outline-none
            text-sm
            lg:text-xl
            font-semibold
            leading-tight
            text-gray-800
          "
        >
          Groups
        </p>
        <button
          @click="
            showAddGroupForm = !showAddGroupForm;
            showJoinGroupForm = false;
          "
          class="
            focus:outline-none
            focus:ring-2
            focus:ring-indigo-700
            focus:bg-indigo-50
            flex
            cursor-pointer
            items-center
            justify-center
            px-3
            py-2.5
            border
            rounded
            border-gray-100
            ml-10
            mr-10
          "
        >
          <p
            class="
              focus:outline-none
              text-xs
              md:text-sm
              leading-none
              text-gray-600
            "
          >
            Create Group
          </p>
        </button>
        <button
          @click="
            showJoinGroupForm = !showJoinGroupForm;
            showAddGroupForm = false;
          "
          class="
            focus:outline-none
            focus:ring-2
            focus:ring-indigo-700
            focus:bg-indigo-50
            flex
            cursor-pointer
            items-center
            justify-center
            px-3
            py-2.5
            border
            rounded
            border-gray-100
          "
        >
          <p
            class="
              focus:outline-none
              text-xs
              md:text-sm
              leading-none
              text-gray-600
            "
          >
            Join Group
          </p>
        </button>
      </div>
      <div
        v-if="showJoinGroupForm"
        class="
          flex
          items-center
          border-b border-gray-200
          justify-center
          px-6
          py-3
          mr-auto
          ml-auto
          mt-5
        "
      >
        <form id="joinGroupForm" @submit.prevent="joinGroup()">
          <label
            for="groupKey"
            class="
              text-gray-800
              dark:text-gray-100
              text-base
              font-bold
              leading-tight
              tracking-normal
              mb-2
              mr-auto
              ml-auto
            "
          >
            Invite Code</label
          >
          <input
            id="groupKey"
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
              mr-auto
              ml-auto
              mb-5
            "
            v-model="groups.groupKey"
            required
            autofocus
            placeholder="Invite Code"
          />
          <button
            type="submit"
            class="
              ml-auto
              mr-auto
              focus:outline-none
              focus:ring-2
              focus:ring-indigo-700
              focus:bg-indigo-50
              flex
              cursor-pointer
              items-center
              justify-center
              px-3
              py-2.5
              border
              rounded
              border-gray-100
              mb-5
            "
          >
            <p
              class="
                focus:outline-none
                text-xs
                md:text-sm
                leading-none
                text-gray-600
              "
            >
              Join Group
            </p>
          </button>
        </form>
      </div>
      <div
        v-if="showAddGroupForm"
        class="
          flex
          items-center
          border-b border-gray-200
          justify-between
          px-6
          py-3
        "
      >
        <groups-component></groups-component>
      </div>
      <div class="list-groups">
        <groups-user-component />
      </div>
    </div>
  </body>
</template>

<script>
import GroupsComponent from "@/components/GroupsComponent.vue";
import groupsService from "@/services/GroupsService.js";
import GroupsUserComponent from "@/components/GroupsUserComponent.vue";
export default {
  name: "groups",
  data() {
    return {
      showAddGroupForm: false,
      showJoinGroupForm: false,
      groups: [],
    };
  },
  components: {
    GroupsComponent,
    GroupsUserComponent,
  },
  created() {
    groupsService.getAll().then((response) => {
      this.groups = response.data;
    });
  },
  methods: {
    joinGroup() {
      groupsService.joinGroup(this.groups.groupKey).then((response) => {
        if (response.status === 202) {
          this.$router.go(this.$router.currentRoute);
        }
        this.groups = response.data;
      });
    },
  },
};
</script>

<style>
</style>
