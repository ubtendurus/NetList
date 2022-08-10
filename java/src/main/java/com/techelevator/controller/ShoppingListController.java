package com.techelevator.controller;

import com.techelevator.dao.ShoppingListDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.ShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ShoppingListController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ShoppingListDao shoppingListDao;

    public ShoppingListController(ShoppingListDao shoppingListDao,UserDao userDao) {
        this.shoppingListDao = shoppingListDao;
        this.userDao = userDao;
    }

    @GetMapping("/shoppinglists")
    public List<ShoppingList> getAllLists() {
        return shoppingListDao.getAllLists();
    }

    @PutMapping("/shoppinglists/{listId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean updateList(@PathVariable Long listId, @RequestBody ShoppingList shoppingList) {
        return shoppingListDao.updateList(listId,shoppingList);
    }

    @PostMapping("/shoppinglists")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean createList(@RequestBody ShoppingList shoppingList,Principal principal) {
        return shoppingListDao.createList(shoppingList,principal);
    }

    @DeleteMapping("/shoppinglists/{listId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteList(@PathVariable Long listId) {
        shoppingListDao.deleteList(listId);
    }


}
