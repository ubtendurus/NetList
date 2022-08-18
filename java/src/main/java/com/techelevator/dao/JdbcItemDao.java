package com.techelevator.dao;

import com.techelevator.model.Category;
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
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sqlGetAllCategories = "SELECT * FROM category";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllCategories);
        while (results.next()) {
            Category category = mapRowToCategory(results);
            categories.add(category);
        }
        return categories;
    }

    @Override
    public boolean createItem(Item item, Principal principal) {
        String sql = "INSERT INTO items (name, description, category_id, list_id, quantity, item_note, is_purchased, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String userName = principal.getName();
        UserDao userDao = new JdbcUserDao(jdbcTemplate);
        Long userId = (long)userDao.findIdByUsername(userName);
        return jdbcTemplate.update(sql, item.getItemName(), item.getItemDescription(), item.getCategoryId(), item.getListId(), item.getQuantity(), item.getItemNote(), item.isPurchased(), userId) > 0;
    }

    @Override
    public boolean updateItem(Long itemId, Item item) {
        String sql = "UPDATE items SET name = ?, item_note = ? ,quantity=? WHERE item_id = ?";
        return jdbcTemplate.update(sql, item.getItemName(), item.getItemNote(), item.getQuantity(), itemId) > 0;
    }

    @Override
    public boolean updateItemPurchased(Long itemId,Item item,Principal principal) {
        String sqlPurchaseGet = "SELECT is_purchased FROM items WHERE item_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlPurchaseGet, itemId);
        boolean isPurchased = false;
        if (result.next()) {
            isPurchased = result.getBoolean("is_purchased");
        }

        String sql = "UPDATE items SET is_purchased = ? WHERE item_id = ?";
        return jdbcTemplate.update(sql, item.isPurchased(), itemId) > 0;
    }

    @Override
    public boolean markAllDone(Long itemId,Principal principal) {
        String sql = "UPDATE items SET is_purchased = ? WHERE list_id = ?";
        return jdbcTemplate.update(sql, true, itemId) > 0;
    }

    @Override
    public boolean markAllUnDone(Long itemId,Principal principal) {
        String sql = "UPDATE items SET is_purchased = ? WHERE list_id = ?";
        return jdbcTemplate.update(sql, false, itemId) > 0;
    }

    @Override
    public void deleteItem(Long itemId, Principal principal){
        String sql = "DELETE FROM items WHERE item_id = ?";
        jdbcTemplate.update(sql, itemId);
    }

    @Override
    public Item getItemById(Long itemId,Principal principal) {
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
    public List<Item> getAllItemsByList(Long listId, Principal principal) {
        List<Item>  items = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE list_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, listId);
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
        item.setListId(results.getLong("list_id"));
        item.setQuantity(results.getInt("quantity"));
        item.setItemNote(results.getString("item_note"));
        item.setPurchased(results.getBoolean("is_purchased"));
        if(results.getDate("created_at") != null) {
            item.setCreatedAt(results.getDate("created_at").toLocalDate());
        }
        item.setUserId(results.getLong("user_id"));

        return item;
    }

    private Category mapRowToCategory(SqlRowSet results) {
        Category category = new Category();
        category.setCategoryId(results.getLong("category_id"));
        category.setCategoryName(results.getString("category_name"));
        return category;
    }
}
