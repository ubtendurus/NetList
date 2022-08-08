package com.techelevator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {
    private Long itemId;
    private String itemName;
    private String itemDescription;
    private Long categoryId;


    public Item(Long itemId, String itemName, String itemDescription, Long categoryId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.categoryId = categoryId;
    }

}
