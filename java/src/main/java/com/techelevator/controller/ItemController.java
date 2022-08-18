package com.techelevator.controller;

import com.techelevator.dao.ItemDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Category;
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

    @GetMapping("/allitems/{listId}")
    public List<Item> getAllItemsByList(@PathVariable Long listId, Principal principal){return itemDao.getAllItemsByList(listId, principal);}

    @GetMapping("/categories")
    public List<Category> getAllCategories(){return itemDao.getAllCategories();}


    @PostMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean createItem(@RequestBody Item item, Principal principal) {return itemDao.createItem(item, principal);}

    @PutMapping("/items/{itemId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean updateItem(@PathVariable Long itemId,@RequestBody Item item, Principal principal) {return  itemDao.updateItem(itemId,item);}

    @PutMapping("/items/{itemId}/purchased")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean updateItemPurchased(@PathVariable Long itemId,@RequestBody Item item, Principal principal) {
        return  itemDao.updateItemPurchased(itemId,item,principal);}

    @GetMapping("/items/{itemId}")
    public Item getItemById(@PathVariable Long itemId,Principal principal){return itemDao.getItemById(itemId,principal);}

    @DeleteMapping("/items/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteItem(@PathVariable Long itemId, Principal principal){
        itemDao.deleteItem(itemId,principal);
    }

    @PutMapping("/items/{itemId}/markalldone")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean markAllDone(@PathVariable Long itemId, Principal principal) {
        return  itemDao.markAllDone(itemId,principal);}

    @PutMapping("/items/{itemId}/markallundone")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean markAllUnDone(@PathVariable Long itemId, Principal principal) {
        return  itemDao.markAllUnDone(itemId,principal);}
}
