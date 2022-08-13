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
    getAllItemByListId(listId) {
        const url = "/allitems/" + listId;
        return axios.get(url);
    },
    getAllCategories(){
        const url = "/categories";
        return axios.get(url);
    },
  updateItemPurchased(itemId) {
        const url = "/items/" + itemId + "/purchased";
    return axios.put(url);
    },
    deleteItem(itemId) {
        const url = "/items/" + itemId;
        return axios.delete(url);
    },
    updateItem(item) {
        const url = "/items/" + item.itemId;
        return axios.put(url, item);
    },
    getItemById(itemId) {
        const url = "/items/" + itemId;
        return axios.get(url);
    }

}
