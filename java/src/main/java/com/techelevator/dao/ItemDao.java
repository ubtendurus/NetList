package com.techelevator.dao;

import com.techelevator.model.Category;
import com.techelevator.model.Item;

import java.security.Principal;
import java.util.List;

public interface ItemDao {

    boolean createItem(Item item, Principal principal);

    boolean updateItem(Long itemId,Item item);

    boolean updateItemPurchased(Long itemId,Item item,Principal principal);

    boolean markAllDone(Long itemId,Principal principal);

    boolean markAllUnDone(Long itemId,Principal principal);

    void deleteItem( Long itemId, Principal principal);

    Item getItemById(Long itemId,Principal principal);

    Item getItemByName(String itemName);

    List<Item> getAllItems(Principal principal);

    List<Item> getAllItemsByList(Long listId,Principal principal);

    List<Item> getAllItemsByCategoryId(Long categoryId);

    List<Category> getAllCategories();

}
