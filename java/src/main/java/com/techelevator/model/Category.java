package com.techelevator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Category {
    private Long categoryId;
    private String categoryName;

    public Category(Long categoryId,String categoryName) {
        this.categoryName = categoryName;
        this.categoryId = categoryId;
    }
}
