package com.techelevator.dao;

import com.techelevator.model.Item;

import java.security.Principal;
import java.util.List;

public interface ItemDao {

    boolean createItem(Item item, Principal principal);

    boolean updateItem(Item item);

    void deleteItem( Long itemId, Principal principal);

    Item getItemById(int itemId);

    Item getItemByName(String itemName);

    List<Item> getAllItems(Principal principal);

    List<Item> getAllItemsByCategoryId(Long categoryId);

}
