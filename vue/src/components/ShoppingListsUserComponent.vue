<template>
  <div class="md:mr-16">
    <label
      for="group"
      class="
        text-gray-800
        dark:text-gray-100
        text-sm
        font-bold
        leading-tight
        tracking-normal
        mb-2
        mt-5
      "
      >Select a Group:</label
    >
    <select
      name="group"
      id="groups"
      v-model="selectedGroupId"
      class="
        opacity-100
        bg-white
        dark:bg-gray-800
        shadow
        rounded
        mt-2
        w-48
        py-1
        absolute
      "
    >
      <option
        :value="group.groupId"
        v-for="group in groups"
        v-bind:key="group.groupId"
        class="
          text-gray-600
          dark:text-gray-400 dark:hover:bg-gray-700
          text-sm
          leading-3
          tracking-normal
          py-3
          hover:bg-gray-100
          px-3
          font-normal
        "
      >
        {{ group.groupName }}
      </option>
    </select>
    <body class="flex items-center justify-center py-8">
      <div class="w-full max-w-2xl px-4" v-if="selectedGroupId != 0">
        <div class="border rounded-lg border pb-6 border-gray-200">
          <div class="px-6 pt-6 overflow-x-auto">
            <table class="w-full whitespace-nowrap">
              <tbody
                v-for="list in filterListsbyGroupId"
                v-bind:key="list.id"
                class="group"
              >
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
                            {{ list.listName }}
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
                            :to="{ name: 'list', params: { groupId: list.id } }"
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
  </div>
</template>

<script>
import ShoppingListsService from "@/services/ShoppingListsService.js";
import groupsService from "@/services/GroupsService.js";

export default {
  name: "shopping-lists-user",
  data() {
    return {
      lists: {
        listName: "",
        groupId: "",
      },
      selectedGroupId: "0",
      groups: {},
    };
  },
  computed: {
    filterListsbyGroupId() {
      return this.lists.filter((list) => list.groupId === this.selectedGroupId);
    },
  },
  created() {
    ShoppingListsService.getAll().then((response) => {
      this.lists = response.data;
      this.lists.sort(function (a, b) {
        if (a.listName.toLowerCase() < b.listName.toLowerCase()) {
          return -1;
        }
        if (a.listName.toLowerCase() > b.listName.toLowerCase()) {
          return 1;
        }
        return 0;
      });
    });
    groupsService.getAll().then((response) => {
      this.groups = response.data;
    });
  },
};
</script>

<style>
</style>
