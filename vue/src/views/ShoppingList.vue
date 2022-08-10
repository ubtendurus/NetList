<template>
  <!--list shopping list-->
  <body class="flex items-center justify-center py-8">
    <div class="shoppinglist">
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
          Shopping Lists
        </p>
        <button
          @click="showCreateListForm = !showCreateListForm"
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
            Create List
          </p>
        </button>
      </div>
      <div
        v-if="showCreateListForm"
        class="
          flex
          items-center
          border-b border-gray-200
          justify-between
          px-6
          py-3
        "
      >
        <shopping-lists-component />
      </div>
      <div class="list-shoppinglists">
        <shopping-lists-user-component />
      </div>
    </div>
  </body>
</template>

<script>
import ShoppingListsComponent from "@/components/ShoppingListsComponent.vue";
import ShoppingListsUserComponent from "@/components/ShoppingListsUserComponent.vue";

export default {
  name: "shopping-lists",
  data() {
    return {
      showCreateListForm: false,
    };
  },
  components: {
    ShoppingListsUserComponent,
    ShoppingListsComponent,
  },
};
</script>

<style>
</style>
