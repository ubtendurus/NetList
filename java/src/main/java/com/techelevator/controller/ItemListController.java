package com.techelevator.controller;

import com.techelevator.dao.ItemInListDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Item;
import com.techelevator.model.ItemInList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        @GetMapping("/shoppinglistitems")
    public List<ItemInList> getAllItemsInList(Long listId) {
      return   itemInListDao.getAllItemsInList(listId);
      
    }

}

