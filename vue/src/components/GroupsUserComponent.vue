<template>
  <body class="flex items-center justify-center py-8">
    <div class="w-full max-w-2xl px-4">
      <div class="border rounded-lg border pb-6 border-gray-200">

        <div class="px-6 pt-6 overflow-x-auto">
          <table class="w-full whitespace-nowrap">
            <tbody v-for="group in groups" class="group" v-bind:key="group.id">
              <tr tabindex="0" class="focus:outline-none">
                <td>
                  <div class="flex items-center">
                    <div class="bg-gray-100 rounded-sm p-2.5">
                      <img
                        width="28px"
                        height="28px"
                        src="..\assets\imgs\icons8-checklist-100.png"
                      />
                    </div>
                    <div class="pl-3">
                      <div class="flex items-center text-sm leading-none">
                        <p class="font-semibold text-gray-800">
                          {{ group.groupName }}
                        </p>
                        <p class="text-indigo-700 ml-3">
                          (Group Key will be here)
                        </p>
                      </div>
                      <p
                        class="
                          text-xs
                          md:text-sm
                          leading-none
                          text-gray-600
                          mt-2
                        "
                      >
                        //TODO IDEA: Group Desc? Maybe
                      </p>
                    </div>
                  </div>
                </td>
                <td class="pl-16">
                  <div>
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
                          :to="{ name: 'group', params: { groupId: group.id } }"
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
                      <p class="text-xs leading-3 text-red-700">Delete</p>
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
      groups: [],
    };
  },
  methods: {},
  created() {
    groupsService.getAll().then((response) => {
      this.groups = response.data;
    });
  },
};
</script>

<style>
.checkbox:checked + .check-icon {
  display: flex;
}
</style>
