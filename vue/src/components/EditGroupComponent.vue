<template>
    <div>
        <form id="editGroupForm" @submit.prevent="updateGroup()">
            <div>
                <label for="groupName">Group Name</label>
                <input id="groupName" v-model="group.groupName" required autofocus placeholder="Item Name" />
                <br/>
                <label for="groupOwner">Group Owner</label>
            </div>
    </div>
  
</template>

<script>
export default {

}
</script>

<style>

</style>