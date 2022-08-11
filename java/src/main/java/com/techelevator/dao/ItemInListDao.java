package com.techelevator.dao;

import com.techelevator.model.ItemInList;

import java.security.Principal;
import java.util.List;

public interface ItemInListDao {

    boolean createItemInList(ItemInList itemInList, Principal principal);

    boolean updateItemInList(Long shoppinglistitemId, ItemInList itemInList);

    void deleteItemInList(Long itemInListId, Principal principal);

    List<ItemInList> getAllItemsInList(Long listId);

    ItemInList getItemInListById(Long itemInListId);



}
