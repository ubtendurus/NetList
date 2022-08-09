package com.techelevator.dao;

import com.techelevator.model.ItemInList;

import java.util.List;

public interface ItemInListDao {

    boolean createItemInList(ItemInList itemInList);

    boolean updateItemInList(ItemInList itemInList);

    void deleteItemInList(ItemInList itemInList);

    List<ItemInList> getAllItemsInList(Long listId);

    ItemInList getItemInListById(Long itemInListId);



}
