package com.techelevator.dao;

import com.techelevator.model.Item;
import com.techelevator.model.ShoppingList;

import java.security.Principal;
import java.util.List;

public interface ShoppingListDao {

        boolean createList(ShoppingList list,Principal principal);

        boolean updateList(Long listId,ShoppingList list);

        void deleteList(Long listId);

        ShoppingList getListById(Long listId);

        ShoppingList getListByName(String listName);

        List<ShoppingList> getAllLists(Principal principal);

        List<ShoppingList> getListByOwnerId(Long ownerId);

        List<ShoppingList> getListByRetailerId(Long retailerId);

        ShoppingList getListByGroupId(Long groupId);

        List<ShoppingList> getListByUserId(Long userId);


    }
