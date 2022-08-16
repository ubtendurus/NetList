<template>
  <body class="min-h-screen">
    <div
      class="
        min-h-screen
        bg-gradient-to-tl
        from-green-400
        to-indigo-900
        w-full
        py-16
        px-4
      "
    >
      <div class="flex flex-col items-center justify-center">
        <img
          width="188"
          height="74"
          viewBox="0 0 188 74"
          fill="none"
          style="border-radius: 1000px"
          src="https://img.icons8.com/clouds/452/edit-file.png"
        />
        <div
          class="bg-white shadow rounded lg:w-1/3 md:w-1/2 w-full p-10 mt-16"
        >
          <p
            tabindex="0"
            role="heading"
            aria-label="Login to your account"
            class="text-2xl font-extrabold leading-6 text-gray-800"
          >
            Register your account
          </p>
          <p class="text-sm mt-4 font-medium leading-none text-gray-500">
            Have an account?
            <router-link :to="{ name: 'login' }"
              ><span
                tabindex="0"
                role="link"
                aria-label="Sign up here"
                class="
                  text-sm
                  font-medium
                  leading-none
                  underline
                  text-gray-800
                  cursor-pointer
                "
              >
                Sign in here</span
              ></router-link
            >
          </p>
          <div
            class="alert alert-danger"
            role="alert"
            v-if="registrationErrors"
          >
            {{ registrationErrorMsg }}
          </div>
          <form @submit.prevent="register">
            <div>
              <label class="text-sm font-medium leading-none text-gray-800">
                Email
              </label>
              <input
                aria-label="enter email adress"
                role="input"
                type="email"
                v-model="user.username"
                autofocus
                required
                class="
                  bg-gray-200
                  border
                  rounded
                  focus:outline-none
                  text-xs
                  font-medium
                  leading-none
                  text-gray-800
                  py-3
                  w-full
                  pl-3
                  mt-2
                "
              />
            </div>
            <div class="mt-6 w-full">
              <label class="text-sm font-medium leading-none text-gray-800">
                Password
              </label>
              <div class="relative flex items-center justify-center">
                <input
                  aria-label="enter Password"
                  role="input"
                  type="password"
                  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                  required
                  v-model="user.password"
                  id="password"
                  class="
                    bg-gray-200
                    border
                    rounded
                    focus:outline-none
                    text-xs
                    font-medium
                    leading-none
                    text-gray-800
                    py-3
                    w-full
                    pl-3
                    mt-2
                  "
                />
              </div>
            </div>
            <div class="right-0 mt-2 mr-3">
              <span class="text-xs font-medium leading-none text-red-800">
                Password must be at least 8 characters long, contains at least
                one lowercase letter, one uppercase letter and one number.
              </span>
            </div>
            <div class="mt-6 w-full">
              <label class="text-sm font-medium leading-none text-gray-800">
                Confirm Password
              </label>
              <div class="relative flex items-center justify-center">
                <input
                  aria-label="Confirm Password"
                  role="input"
                  type="password"
                  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                  required
                  id="confirmPassword"
                  v-model="user.confirmPassword"
                  class="
                    bg-gray-200
                    border
                    rounded
                    focus:outline-none
                    text-xs
                    font-medium
                    leading-none
                    text-gray-800
                    py-3
                    w-full
                    pl-3
                    mt-2
                  "
                />
              </div>
            </div>
            <div class="mt-8">
              <button
                role="button"
                aria-label="create my account"
                class="
                  focus:ring-2 focus:ring-offset-2 focus:ring-indigo-700
                  text-sm
                  font-semibold
                  leading-none
                  text-white
                  focus:outline-none
                  bg-indigo-700
                  border
                  rounded
                  hover:bg-indigo-600
                  py-4
                  w-full
                "
              >
                Create my account
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg =
                "Bad Request: That e-mail address is already in use.";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
@import "https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css";
</style>
