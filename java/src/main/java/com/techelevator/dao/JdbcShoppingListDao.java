package com.techelevator.dao;

import com.techelevator.model.Item;
import com.techelevator.model.Retailer;
import com.techelevator.model.ShoppingList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcShoppingListDao implements ShoppingListDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcShoppingListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean createList(ShoppingList shoppingList) {
        //UserDao userDao = new JdbcUserDao(jdbcTemplate);
        //Get owner id by user Id

        //int ownerId = userDao.findIdByUsername("user1");
        //TODO get owner ID of the current creator

        String sql="INSERT INTO lists (name) VALUES (?)";
        return jdbcTemplate.update(sql, shoppingList.getListName()) > 0;
    }

    @Override
    public boolean updateList(Long listId,ShoppingList shoppingList) {
        String sql="UPDATE lists SET name = ? WHERE list_id = ?";
        return jdbcTemplate.update(sql, shoppingList.getListName(), listId) > 0;
    }

    @Override
    public void deleteList(Long listId) {
        String sql="DELETE FROM lists WHERE list_id = ?";
        jdbcTemplate.update(sql, listId);
    }


    @Override
    public ShoppingList getListById(Long listId) {
        String sql="SELECT * FROM lists WHERE list_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, listId);
        if (results.next()) {
            return mapRowToList(results);
        } else {
            throw new IllegalArgumentException("No Match Found!");
        }
    }

    @Override
    public ShoppingList getListByName(String listName) {
            String sql = "SELECT * FROM lists WHERE name = ?";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, listName);
            if (results.next()) {
                return mapRowToList(results);
            } else {
                throw new IllegalArgumentException("No Match Found!");
            }
    }


    @Override
    public List<ShoppingList> getAllLists() {
        List<ShoppingList> lists = new ArrayList<>();
        String sql = "SELECT * FROM lists";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            lists.add(mapRowToList(results));
        }
        return lists;
    }

    @Override
    public List<ShoppingList> getListByOwnerId(Long ownerId) {
        List<ShoppingList> lists = new ArrayList<>();
        String sql = "SELECT * FROM lists WHERE owner_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ownerId);
        while (results.next()) {
            lists.add(mapRowToList(results));
        }
        return lists;
    }

    @Override
    public List<ShoppingList> getListByRetailerId(Long retailerId) {
        List<ShoppingList> lists = new ArrayList<>();
        String sql = "SELECT * FROM lists WHERE retailer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, retailerId);
        while (results.next()) {
            lists.add(mapRowToList(results));
        }
        return lists;
    }

    @Override
    public ShoppingList getListByGroupId(Long groupId) {
        String sql = "SELECT * FROM lists WHERE group_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupId);
        if (results.next()) {
            return mapRowToList(results);
        } else {
            throw new IllegalArgumentException("No Match Found!");
        }
    }

    @Override
    public List<ShoppingList> getListByUserId(Long userId) {
        List<ShoppingList> shoppingLists = new ArrayList<>();
        String sql = "SELECT * FROM lists WHERE list_id =  " +
                "(SELECT list_id FROM user_list WHERE user_id = ?)";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            ShoppingList shoppingList = mapRowToList(results);
            shoppingLists.add(shoppingList);
        }
        return shoppingLists;
    }

    private ShoppingList mapRowToList(SqlRowSet results) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setListId(results.getLong("list_id"));
        shoppingList.setListName(results.getString("name"));
        shoppingList.setOwnerId(results.getLong("owner_id"));
        if(results.getDate("created_at") != null) {
            shoppingList.setCreatedAt(results.getDate("created_at").toLocalDate());
        }
        shoppingList.setRetailerId(results.getLong("retailer_id"));
        shoppingList.setGroupId(results.getLong("group_id"));
        return shoppingList;

    }

}
