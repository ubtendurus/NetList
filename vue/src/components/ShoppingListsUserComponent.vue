<template>
  <body class="flex items-center justify-center py-8 mr-auto ml-auto">
    <div class="flex flex-col md:mr-16">
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
          ml-auto
          mr-auto
        "
        >Select a Group to Display Its Lists:</label
      >
      <select
        name="group"
        id="groups"
        v-model="selectedGroupId"
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
          mb-5
          ml-auto
          mr-auto
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
      <p v-if="selectedGroupId != 0" class="
          text-gray-600
          dark:text-gray-100
          text-base
          font-semibold
          leading-tight
          tracking-normal
          mb-2
          ml-auto
          mr-auto"
          > <em>Click on a list to see its items.</em> </p>
      <div class="w-full max-w-5xl px-4" v-if="selectedGroupId != 0">
        <div class="border rounded-lg border pb-6 border-gray-200">
          <p v-if="filterListsbyGroupId.length === 0"
          class="
            text-gray-400
            dark:text-gray-100
            text-sm
            leading-tight
            tracking-normal
            ml-3
            mr-3
            mt-12
            text-align-center
            text-justify-center
          "> Your lists will display here after creating them! </p>
          <div class="px-6 pt-6 overflow-x-auto ">
            <table class="w-full whitespace-nowrap ">
              <tbody
                v-for="list in filterListsbyGroupId"
                v-bind:key="list.listId"
                class="group"
              >
                <tr tabindex="0" class="focus:outline-none border-b border-gray-200">
                  <td>
                    <div class="flex items-center">
                      <div class="rounded-sm p-1.5">
                        <img
                          width="36px"
                          height="36px"
                          src="https://img.icons8.com/clouds/344/checklist.png"
                        />
                      </div>
                      <div class="pl-3">
                        <div class="flex items-center text-lg leading-none">
                          <p class="font-semibold text-gray-800">
                            <router-link
                              :to="{
                                name: 'show-list-items',
                                params: {
                                  listId: list.listId,
                                },
                              }"
                              >{{ list.listName }}</router-link
                            >
                          </p>
                          <p class="text-indigo-700 ml-3">
                            <!-- (Anything can come here) -->
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
                          <!-- //TODO IDEA: Group Desc? Maybe -->
                        </p>
                      </div>
                    </div>
                  </td>
                  <td class="pl-16">
                    <div>
                      <router-link
                            :to="{
                              name: 'edit-list',
                              params: { listId: list.listId },
                            }">
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
                            text-xs
                            font-semibold
                            leading-none
                            text-right text-green-800
                          "
                        >
                          
                            Edit List Name
                        </p>
                      </div>
                      </router-link
                          >
                      <button>
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
                          cursor: pointer;
                          mb-2
                        "
                      
                      >
                      
                        <p class="text-xs font-semibold leading-3 text-red-700 cursor-pointer px-7"
                        @click.self="deleteList(list.listId)">
                          
                            Delete List
                        </p>
                      </div>
                      </button>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </body>
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
  methods: {
    deleteList(listId) {
      ShoppingListsService.delete(listId).then((response) => {
        if (response.status === 204) {
          this.$router.go(this.$router.currentRoute);
        } else {
          alert("Error deleting group");
        }
      });
    },
  },
};
</script>

<style>
</style>
