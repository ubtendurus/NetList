<template>
  <body class="flex items-center justify-center py-8">
    <div class="groups">
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
          @click="showAddGroupForm = !showAddGroupForm"
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
            Add Group
          </p>
        </button>
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
};
</script>

<style>
</style>
