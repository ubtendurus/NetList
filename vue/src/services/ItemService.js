import axios from "axios";

export default {
    createItem(item) {
        const url = "/items";
        return axios.post(url, item);
    },
    getAllItems() {
        const url = "/items";
        return axios.get(url);
    },
    getAllCategories(){
        const url = "/categories";
        return axios.get(url);
    },
    updateItem(item) {
        const url = "/items/" + this.item.itemId;
        return axios.put(url, item);
    }

}
