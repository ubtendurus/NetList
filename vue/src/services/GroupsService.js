import axios from 'axios';

export default {
    create(group) {
        const url = "/groups";
        return axios.post(url, group);
    },
    getAll() {
        const url = "/groups";
        return axios.get(url);
    },
    deleteGroup(id) {
        const url = "/groups/" + id;
        return axios.delete(url);
    },
    joinGroup(key) {
        const url = "/groups/join/" + key;
        return axios.post(url);
    },
    updateGroup(groupId, group) {
        const url = "/groups/" + groupId;
        return axios.put(url, group);
    },
    getGroupUsers(groupId) {
      const url = "/users/groups/" + groupId;
        return axios.get(url);
    },
  getGroupById(groupId) {
    const url = "/groups/" + groupId;
        return axios.get(url);
    }
}
