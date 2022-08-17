<template>
  <div id="app">
    <!-- Navigation starts -->
    <nav
      class="
        w-full
        mx-auto
        bg-gray-800
        border-b border-gray-700
        shadow
        relative
        z-20
      "
    >
      <div
        class="container px-6 h-16 flex items-center justify-between mx-auto"
      >
        <div class="flex items-center">
          <div
            class="
              rounded-full
              relative
              p-3
              flex
              justify-end
              leading-10
              font-bold
              text-white text-xl
            "
          >
            NetList
          </div>
        </div>
        <ul class="flex items-center justify-center h-full">
          <li
            class="
              cursor-pointer
              h-full
              flex
              xl:flex
              items-center
              text-sm text-white
              hover:text-indigo-500
              tracking-normal
            "
          >
            <router-link
              v-bind:to="{ name: 'home' }"
              v-if="$store.state.token != ''"
              >Home</router-link
            >
          </li>
          <li
            class="
              flex
              hover:text-indigo-500
              cursor-pointer
              h-full
              items-center
              text-sm text-white
              ml-10
              tracking-normal
              relative
            "
          >
            <router-link
              v-bind:to="{ name: 'groups' }"
              v-if="$store.state.token != ''"
            >
              Groups
            </router-link>
          </li>
          <li class="mx-0 mx-12 cursor-pointer flex">
            <router-link v-bind:to="{ name: 'home' }">
              <img
                src="https://img.icons8.com/clouds/344/checklist.png"
                width="43px"
                height="44px"
              />
            </router-link>
          </li>
          <li
            class="
              hover:text-indigo-500
              cursor-pointer
              h-full
              xl:flex
              flex
              items-center
              text-sm text-white
              mr-10
              tracking-normal
            "
          >
            <router-link
              v-bind:to="{ name: 'shopping-lists' }"
              v-if="$store.state.token != ''"
            >
              Lists
            </router-link>
          </li>
          <li
            class="
              hover:text-indigo-500
              cursor-pointer
              mr-10
              h-full
              xl:flex
              flex
              items-center
              text-sm text-white
              tracking-normal
            "
          >
            <router-link
              v-bind:to="{ name: 'creator-view' }"
              v-if="$store.state.token != ''"
            >
              Creators
            </router-link>
            <!--TODO change the Link-->
          </li>
        </ul>
        <div
          aria-haspopup="true"
          class="
            cursor-pointer
            h-full
            xl:flex
            flex
            items-center
            justify-end
            relative
          "
        >
          <router-link
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
          >
            <li
              class="
                hover:text-indigo-500
                cursor-pointer
                h-full
                xl:flex
                flex
                items-center
                text-sm text-white
                tracking-normal
              "
            >
              Logout
            </li></router-link
          >
        </div>
      </div>
    </nav>
    <!-- Navigation ends -->
    <router-view />
  </div>
</template>

<style scoped>
@import "https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css";
</style>
