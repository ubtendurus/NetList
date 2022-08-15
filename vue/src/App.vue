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
            class="rounded-full relative p-3 flex justify-end text-white"
          ></div>
        </div>
        <ul class="flex items-center justify-center h-full">
          <li
            class="
              cursor-pointer
              h-full
              flex
              xl:flex
              items-center
              text-sm text-indigo-500
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
              xl:flex
              items-center
              text-sm text-white
              xl:ml-10
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
              <svg
                aria-label="Home"
                id="logo"
                enable-background="new 0 0 300 300"
                height="44"
                viewBox="0 0 300 300"
                width="43"
              >
                <g>
                  <path
                    fill="#667eea"
                    d="m234.735 35.532c-8.822 0-16 7.178-16 16s7.178 16 16 16 16-7.178 16-16-7.178-16-16-16zm0 24c-4.412 0-8-3.588-8-8s3.588-8 8-8 8 3.588 8 8-3.588 8-8 8zm-62.529-14c0-2.502 2.028-4.53 4.53-4.53s4.53 2.028 4.53 4.53c0 2.501-2.028 4.529-4.53 4.529s-4.53-2.027-4.53-4.529zm89.059 60c0 2.501-2.028 4.529-4.53 4.529s-4.53-2.028-4.53-4.529c0-2.502 2.028-4.53 4.53-4.53s4.53 2.029 4.53 4.53zm-40.522-5.459-88-51.064c-1.242-.723-2.773-.723-4.016 0l-88 51.064c-1.232.715-1.992 2.033-1.992 3.459v104c0 1.404.736 2.705 1.938 3.428l88 52.936c.635.381 1.35.572 2.062.572s1.428-.191 2.062-.572l88-52.936c1.201-.723 1.938-2.023 1.938-3.428v-104c0-1.426-.76-2.744-1.992-3.459zm-90.008-42.98 80.085 46.47-52.95 31.289-23.135-13.607v-21.713c0-2.209-1.791-4-4-4s-4 1.791-4 4v21.713l-26.027 15.309c-1.223.719-1.973 2.029-1.973 3.447v29.795l-52 30.727v-94.688zm0 198.707-80.189-48.237 51.467-30.412 24.723 14.539v19.842c0 2.209 1.791 4 4 4s4-1.791 4-4v-19.842l26.027-15.307c1.223-.719 1.973-2.029 1.973-3.447v-31.667l52-30.728v94.729z"
                  />
                </g>
              </svg>
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
            hidden
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
                hidden
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
