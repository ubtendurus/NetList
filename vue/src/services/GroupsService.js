import axios from 'axios';

export default {
    create(group) {
        const url = "/groups";
        return axios.post(url, group);
    }
}