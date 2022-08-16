<template>
  <body class="flex items-center justify-center py-8">
    <div class="w-full max-w-2xl px-4">
      <div
        class="border rounded-lg border pb-6 border-gray-200"
        v-if="groups.length != 0"
      >
        <div class="px-6 pt-6 overflow-x-auto">
          <table class="w-full whitespace-nowrap">
            <tbody v-for="group in groups" class="group" v-bind:key="group.id">
              <tr
                tabindex="0"
                class="focus:outline-none border-b border-gray-200"
              >
                <td class="p-4">
                  <div class="flex items-center">
                    <div class="bg-gray-100 rounded-sm p-2.5">
                      <img
                        width="28px"
                        height="28px"
                        src="https://img.icons8.com/clouds/344/checklist.png"
                      />
                    </div>
                    <div class="pl-3">
                      <div class="flex items-center text-lg leading-none">
                        <p class="font-semibold text-gray-800">
                          {{ group.groupName }}
                        </p>
                      </div>
                      <p
                        class="
                          text-xs
                          md:text-sm
                          leading-none
                          text-gray-600
                          mt-2
                          text-indigo-700
                        "
                      >
                        Invite Code: {{ group.groupKey }}
                      </p>
                    </div>
                  </div>
                </td>
                <td class="pl-16">
                  <div v-if="group.ownerId === $store.state.user.id">
                    <div
                      class="
                        flex
                        items-center
                        justify-center
                        px-2
                        py-1
                        mt-2
                        bg-green-100
                        rounded-full
                      "
                    >
                      <p
                        class="
                          text-sm
                          font-semibold
                          leading-none
                          text-right text-green-800
                        "
                      >
                        <router-link
                          :to="{
                            name: 'edit-group',
                            params: { groupId: group.groupId },
                          }"
                          >Edit</router-link
                        >
                      </p>
                    </div>
                    <div
                      class="
                        flex
                        items-center
                        justify-center
                        px-2
                        py-1
                        mt-2
                        bg-red-100
                        rounded-full
                      "
                    >
                      <p
                        class="text-xs leading-3 text-red-700 cursor-pointer"
                        @click.self="deleteGroup(group.groupId)"
                      >
                        Delete
                      </p>
                    </div>
                  </div>
                  <div v-else>
                    <div
                      class="
                        flex
                        items-center
                        justify-center
                        px-2
                        py-1
                        mt-2
                        bg-red-100
                        rounded-full
                      "
                    >
                      <p
                        class="text-xs leading-3 text-red-700 cursor-pointer"
                        @click.self="deleteGroup(group.groupId)"
                      >
                        Leave
                      </p>
                    </div>
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
import groupsService from "@/services/GroupsService.js";
export default {
  name: "groups-user",
  data() {
    return {
      groups: {
        groupName: "",
        groupKey: "",
        ownerId: "",
      },
    };
  },
  methods: {
    deleteGroup(groupId) {
      groupsService.deleteGroup(groupId).then((response) => {
        if (response.status === 204) {
          this.$router.go(this.$router.currentRoute);
        } else {
          alert("Error deleting group");
        }
      });
    },
  },
  created() {
    groupsService.getAll().then((response) => {
      this.groups = response.data;
      this.groups.sort(function (a, b) {
        if (a.groupName.toLowerCase() < b.groupName.toLowerCase()) {
          return -1;
        }
        if (a.groupName.toLowerCase() > b.groupName.toLowerCase()) {
          return 1;
        }
        return 0;
      });
    });
  },
};
</script>

<style>
.checkbox:checked + .check-icon {
  display: flex;
}
</style>
