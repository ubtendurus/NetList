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
    }
}
