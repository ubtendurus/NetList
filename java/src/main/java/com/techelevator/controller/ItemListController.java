package com.techelevator.controller;

import com.techelevator.dao.ItemInListDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Item;
import com.techelevator.model.ItemInList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController
public class ItemListController {

    @Autowired
    private ItemInListDao itemInListDao;
    @Autowired
    private UserDao userDao;

    public  ItemListController(ItemInListDao itemInListDao, UserDao userDao) {
        this.itemInListDao = itemInListDao;
        this.userDao = userDao;
        }

    @GetMapping("/shoppinglistitems/{listId}")
    public List<ItemInList> getAllItemsInList(@PathVariable Long listId) {
      return   itemInListDao.getAllItemsInList(listId);
    }

    @PostMapping("/shoppinglistitems")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean createItemInList(@RequestBody ItemInList itemInList, Principal principal) {
        return itemInListDao.createItemInList(itemInList, principal);
    }

    @PutMapping("/shoppinglistitems/{shoppinglistitemId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean updateItemInList(@PathVariable Long shoppinglistitemId, @RequestBody ItemInList itemInList, Principal principal) {
        return itemInListDao.updateItemInList(shoppinglistitemId, itemInList);
    }

    @DeleteMapping("/shoppinglistitems/{shoppinglistitemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItemInList(@PathVariable Long itemInListId, Principal principal) {
        itemInListDao.deleteItemInList(itemInListId, principal);
    }

}

