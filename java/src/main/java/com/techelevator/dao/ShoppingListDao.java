package com.techelevator.dao;

import com.techelevator.model.Item;
import com.techelevator.model.ShoppingList;

import java.util.List;

public interface ShoppingListDao {

        boolean createList(ShoppingList list);

        boolean updateList(ShoppingList list);

        void deleteList(ShoppingList list);

        ShoppingList getListById(Long listId);

        ShoppingList getListByName(String listName);

        List<ShoppingList> getAllLists();

        List<ShoppingList> getListByOwnerId(Long ownerId);

        List<ShoppingList> getListByRetailerId(Long retailerId);

        ShoppingList getListByGroupId(Long groupId);

        List<ShoppingList> getListByUserId(Long userId);


    }
