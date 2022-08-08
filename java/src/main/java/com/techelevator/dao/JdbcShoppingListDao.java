package com.techelevator.dao;

import com.techelevator.model.Item;
import com.techelevator.model.Retailer;
import com.techelevator.model.ShoppingList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcShoppingListDao implements ShoppingListDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcShoppingListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean createList(ShoppingList shoppingList) {
        String sql="INSERT INTO lists (name) VALUES (?)";
        return jdbcTemplate.update(sql, shoppingList.getListName()) > 0;
    }

    @Override
    public boolean updateList(ShoppingList shoppingList) {
        String sql="UPDATE lists SET name = ? WHERE list_id = ?";
        return jdbcTemplate.update(sql, shoppingList.getListName(), shoppingList.getListId()) > 0;
    }

    @Override
    public void deleteList(ShoppingList shoppingList) {
        String sql="DELETE FROM lists WHERE list_id = ?";
        jdbcTemplate.update(sql, shoppingList.getListId());
    }


    @Override
    public ShoppingList getListById(int listId) {
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
    public List<ShoppingList> getListByOwnerId(long ownerId) {
        List<ShoppingList> lists = new ArrayList<>();
        String sql = "SELECT * FROM lists WHERE owner_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ownerId);
        while (results.next()) {
            lists.add(mapRowToList(results));
        }
        return lists;
    }

    @Override
    public List<ShoppingList> getListByRetailerId(long retailerId) {
        List<ShoppingList> lists = new ArrayList<>();
        String sql = "SELECT * FROM lists WHERE retailer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, retailerId);
        while (results.next()) {
            lists.add(mapRowToList(results));
        }
        return lists;
    }

    @Override
    public ShoppingList getListByGroupId(long groupId) {
        String sql = "SELECT * FROM lists WHERE group_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupId);
        if (results.next()) {
            return mapRowToList(results);
        } else {
            throw new IllegalArgumentException("No Match Found!");
        }
    }

    private ShoppingList mapRowToList(SqlRowSet results) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setListId(results.getLong("list_id"));
        shoppingList.setListName(results.getString("name"));
        shoppingList.setOwnerId(results.getLong("owner_id"));
        if(results.getDate("date_created") != null) {
            shoppingList.setCreatedAt(results.getDate("created_at").toLocalDate());
        }
        shoppingList.setRetailerId(results.getLong("retailer_id"));
        shoppingList.setGroupId(results.getLong("group_id"));
        return shoppingList;

    }

}
