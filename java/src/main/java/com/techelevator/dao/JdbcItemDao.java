package com.techelevator.dao;

import com.techelevator.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItemDao implements ItemDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean createItem(Item item, Principal principal) {
        String sql = "INSERT INTO items (name, description) VALUES (?, ?)";
        return jdbcTemplate.update(sql, item.getItemName(), item.getItemDescription()) > 0;
    }

    @Override
    public boolean updateItem(Item item) {
        String sql = "UPDATE items SET name = ?, description = ? WHERE item_id = ?";
        return jdbcTemplate.update(sql, item.getItemName(), item.getItemDescription(), item.getItemId()) > 0;
    }

    @Override
    public void deleteItem(Long itemId, Principal principal){
        String sql = "DELETE FROM items WHERE item_id = ?";
        jdbcTemplate.update(sql, itemId);
    }

    @Override
    public Item getItemById(int itemId) {
        String sql="SELECT * FROM items WHERE item_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemId);
        if (results.next()) {
            return mapRowToItem(results);
        } else {
            throw new IllegalArgumentException("No Match Found!");
        }
    }

    @Override
    public Item getItemByName(String itemName) {
        String sql="SELECT * FROM items WHERE name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemName);
        if (results.next()) {
            return mapRowToItem(results);
        } else {
            throw new IllegalArgumentException("No Match Found!");
        }
    }

    @Override
    public List<Item> getAllItems(Principal principal) {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Item item = mapRowToItem(results);
            items.add(item);
        }
        return items;
    }

    @Override
    public List<Item> getAllItemsByCategoryId(Long categoryId) {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE category_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, categoryId);
        while (results.next()) {
            Item item = mapRowToItem(results);
            list.add(item);
        }
        return list;
    }

    private Item mapRowToItem(SqlRowSet results) {
        Item item = new Item();
        item.setItemId(results.getLong("item_id"));
        item.setItemName(results.getString("name"));
        item.setItemDescription(results.getString("description"));
        item.setCategoryId(results.getLong("category_id"));
        return item;
    }
}
