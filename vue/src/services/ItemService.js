import axios from "axios";

export default {
    createItem(item) {
        const url = "/items";
        return axios.post(url, item);
    },
    getAllItems(listId) {
        const url = "/items/" + listId;
        return axios.get(url,listId);
    },
    getAllCategories(){
        const url = "/categories";
        return axios.get(url);
    }

}
