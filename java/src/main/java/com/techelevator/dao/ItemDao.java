package com.techelevator.dao;

import com.techelevator.model.Item;

import java.util.List;

public interface ItemDao {

    boolean createItem(Item item);

    boolean updateItem(Item item);

    void deleteItem(Item item);

    Item getItemById(int itemId);

    Item getItemByName(String itemName);

    List<Item> getAllItems();

}
