package com.techelevator.dao;

import com.techelevator.model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getAllCategories();
    Category getCategoryById(long categoryId);
    Category getCategoryByName(String categoryName);

    Category getCategoryByItem(long itemId);

    boolean createCategory(Category category);
    boolean updateCategory(Category category);
    void deleteCategory(Category category);
}
