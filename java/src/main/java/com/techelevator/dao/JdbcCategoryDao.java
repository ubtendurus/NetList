package com.techelevator.dao;

import com.techelevator.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcCategoryDao implements CategoryDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCategoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            categories.add(mapRowToCategory(results));
        }
        return categories;
    }

    @Override
    public Category getCategoryById(long categoryId) {
        String sql = "SELECT * FROM categories WHERE category_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, categoryId);
        if (results.next()) {
            return mapRowToCategory(results);
        } else {
            throw new IllegalArgumentException("No Match Found!");
        }
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        String sql= "SELECT * FROM categories WHERE category_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, categoryName);
        if (results.next()) {
            return mapRowToCategory(results);
        } else {
            throw new IllegalArgumentException("No Match Found!");
        }
    }

    @Override
    public Category getCategoryByItem(long itemId) {
        String sql = "SELECT * FROM categories WHERE category_id = (SELECT category_id FROM items WHERE item_id = ?)";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemId);
        if (results.next()) {
            return mapRowToCategory(results);
        } else {
            throw new IllegalArgumentException("No Match Found!");
        }
    }


    private Category mapRowToCategory(SqlRowSet row) {
        Category category = new Category();
        category.setCategoryId(row.getLong("category_id"));
        category.setCategoryName(row.getString("category_name"));
        return category;
    }
}
