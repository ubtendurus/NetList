package com.techelevator.dao;

import com.techelevator.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcItemDao implements ItemDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean createItem(Item item) {
        String sql = "INSERT INTO items (item_name, item_description) VALUES (?, ?)";
        return jdbcTemplate.update(sql, item.getItemName(), item.getItemDescription()) > 0;
    }

    @Override
    public boolean updateItem(Item item) {
        String sql = "UPDATE items SET item_name = ?, item_description = ? WHERE item_id = ?";
        return jdbcTemplate.update(sql, item.getItemName(), item.getItemDescription(), item.getItemId()) > 0;
    }

    @Override
    public void deleteItem(Item item){
        String sql = "DELETE FROM items WHERE item_id = ?";
        jdbcTemplate.update(sql, item.getItemId());
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
        String sql="SELECT * FROM items WHERE item_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemName);
        if (results.next()) {
            return mapRowToItem(results);
        } else {
            throw new IllegalArgumentException("No Match Found!");
        }
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        String sql = "select * from items";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Item item = mapRowToItem(results);
            items.add(item);
        }
        return items;
    }

    private Item mapRowToItem(SqlRowSet results) {
        Item item = new Item();
        item.setItemId(results.getLong("item_id"));
        item.setItemName(results.getString("item_name"));
        item.setItemDescription(results.getString("item_description"));
        return item;
    }
}
