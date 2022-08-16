<template>
  <div class="flex items-center justify-center py-8 mr-auto ml-auto">
    <form id="createGroupForm" @submit.self="createGroup()">
      <div class="flex flex-col md:mr-16">
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
          >Group Name</label
        >
        <input
          id="groupName"
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
          "
          v-model="groups.groupName"
          required
          autofocus
          placeholder="Group Name"
        />
        <br />
        <label
          for="groupKey"
          class="
            text-gray-800
            dark:text-gray-100
            text-sm
            font-bold
            leading-tight
            tracking-normal
            mb-2
          "
          >Invite Code</label
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
          "
          v-model="groups.groupKey"
          required
          autofocus
          placeholder="Invite Code"
          disabled
        />

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
          "
        >
          <p
            class="
              focus:outline-none
              text-xs
              md:text-sm
              leading-none
              text-white
            "
          >
            Create
          </p>
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import groupsService from "@/services/GroupsService.js";

export default {
  name: "groups-component",
  data() {
    return {
      characters:
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789",
      groups: {
        groupName: "",
        groupKey: "",
        ownerId: "",
      },
    };
  },
  computed: {
    //generate random group key
    generateGroupKey() {
      var result = "";
      var charactersLength = this.characters.length;
      for (var i = 0; i < 8; i++) {
        result += this.characters.charAt(
          Math.floor(Math.random() * charactersLength)
        );
      }
      return result;
    },
  },
  methods: {
    createGroup() {
      groupsService.create(this.groups).then((response) => {
        if (response.status === 201) {
          this.$router.go(this.$router.currentRoute);
        }
        this.groups = response.data;
      });
    },
  },
  created() {
    this.groups.groupKey = this.generateGroupKey;
  },
};
</script>

<style>
</style>
