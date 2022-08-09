package com.techelevator.dao;


import com.techelevator.model.ItemInList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcItemInListDao implements ItemInListDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcItemInListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean createItemInList(ItemInList itemInList) {
        String sql="INSERT INTO items_in_lists (list_id, item_id, quantity, item_note) VALUES (?, ?, ?,?)";
        return jdbcTemplate.update(sql, itemInList.getListId(), itemInList.getItemId(), itemInList.getQuantity(),itemInList.getItemNote()) > 0;
    }

    @Override
    public boolean updateItemInList(ItemInList itemInList) {
        String sql="UPDATE items_in_lists SET list_id = ?, item_id = ?, quantity = ?, item_note = ? , is_purchased = ? WHERE item_in_list_id = ?";
        return jdbcTemplate.update(sql, itemInList.getListId(), itemInList.getItemId(), itemInList.getQuantity(),itemInList.getItemNote(), itemInList.getItemInListId(), itemInList.isPurchased()) > 0;
    }

    @Override
    public void deleteItemInList(ItemInList itemInList) {
        String sql="DELETE FROM items_in_lists WHERE item_in_list_id = ?";
        jdbcTemplate.update(sql, itemInList.getItemInListId());
        //TODO database add cascade to delete items in list when list is deleted
    }

    @Override
    public List<ItemInList> getAllItemsInList(Long listId) {
        List<ItemInList> items = new ArrayList<>();
        String sql = "SELECT * FROM items_in_lists WHERE list_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, listId);
        while (results.next()) {
            items.add(mapRowToItemInList(results));
        }
        return items;
    }

    @Override
    public ItemInList getItemInListById(Long itemInListId) {
        String sql = "SELECT * FROM items_in_lists WHERE item_in_list_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemInListId);
        if (results.next()) {
            return mapRowToItemInList(results);
        } else {
            throw new IllegalArgumentException("No Match Found!");
        }
    }

    public ItemInList mapRowToItemInList(SqlRowSet results) {
        ItemInList itemInList = new ItemInList();
        itemInList.setItemInListId(results.getLong("item_in_list_id"));
        itemInList.setListId(results.getLong("list_id"));
        itemInList.setItemId(results.getLong("item_id"));
        itemInList.setQuantity(results.getInt("quantity"));
        itemInList.setItemNote(results.getString("item_note"));
        itemInList.setPurchased(results.getBoolean("is_purchased"));
        return itemInList;
    }
}
