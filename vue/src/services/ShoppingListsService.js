import axios from 'axios'

export default {
    create(list) {
        const url = "/shoppinglists";
        return axios.post(url, list);
    }
}