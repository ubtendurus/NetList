<template>
  <div>
    <edit-group-component :groupId="groupId" />
  </div>
</template>

<script>
import EditGroupComponent from "../components/EditGroupComponent.vue";

export default {
  name: "edit-group",
  components: { EditGroupComponent },
  data() {
    return {
      groupId: this.$route.params.groupId,
    };
  },
};
</script>

<style>
</style>
