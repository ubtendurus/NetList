package com.techelevator.dao;

import com.techelevator.model.Item;
import com.techelevator.model.ShoppingList;

import java.util.List;

public interface ShoppingListDao {

        boolean createList(ShoppingList list);

        boolean updateList(ShoppingList list);

        void deleteList(ShoppingList list);

        ShoppingList getListById(int listId);

        ShoppingList getListByName(String listName);

        List<ShoppingList> getAllLists();

        List<ShoppingList> getListByOwnerId(long ownerId);

        List<ShoppingList> getListByRetailerId(long retailerId);



    }
