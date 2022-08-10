<template>
<div>
    <ul v-for="list in lists" v-bind:key="list.id">
        <li>{{list.listName}}</li>
    </ul>
</div>
</template>

<script>
import ShoppingListsService from "@/services/ShoppingListsService.js";

export default {
    name: "shopping-lists-user",
    data() {
        return {
            lists: [],
        };
    },
    methods: {},
    created() {
        ShoppingListsService.getAll().then((response) => {
            this.lists = response.data;
        });
    },

}
</script>

<style>

</style>