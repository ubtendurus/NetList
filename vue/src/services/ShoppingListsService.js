import axios from 'axios'

export default {
    create(list) {
        const url = "/shoppinglists";
        return axios.post(url, list);
    },
    getAll() {
        const url = "/shoppinglists";
        return axios.get(url);
    },
    delete(listId) {
        const url = "/shoppinglists/" + listId;
        return axios.delete(url);
    },
    updateList(listId,list) {
      const url = "/shoppinglists/" + listId;
        return axios.put(url,list);
    },
    getListById(listId) {
        const url = "/shoppinglists/" + listId;
        return axios.get(url);
    }
}
