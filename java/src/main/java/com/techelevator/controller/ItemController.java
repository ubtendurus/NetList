package com.techelevator.controller;

import com.techelevator.dao.ItemDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController
public class ItemController {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private UserDao userDao;

    public ItemController(ItemDao itemDao, UserDao userDao){
        this.itemDao = itemDao;
        this.userDao = userDao;

    }
    @GetMapping("/items")
        public List<Item> getAllItems(Principal principal){return itemDao.getAllItems(principal);}

    @PostMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean createItem(@RequestBody Item item, Principal principal) {return itemDao.createItem(item, principal);}

    @PutMapping("/items/{itemId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean updateItem(@RequestBody Item item, Principal principal) {return  itemDao.updateItem(item);}

    @DeleteMapping("/items/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteItem(@PathVariable Long itemId, Principal principal){
        itemDao.deleteItem(itemId,principal);
    }
}
