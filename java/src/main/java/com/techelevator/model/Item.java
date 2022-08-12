package com.techelevator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Item {
    private Long itemId;
    private String itemName;
    private String itemDescription;
    private Long categoryId;
    private Long listId;
    private int quantity;
    private boolean isPurchased;
    private String itemNote;
    private LocalDate createdAt;
    private Long userId;



    public Item(Long itemId, String itemName, String itemDescription, Long categoryId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.categoryId = categoryId;
        this.listId = listId;
        this.quantity = quantity;
        this.isPurchased = isPurchased;
        this.itemNote = itemNote;
        this.createdAt = createdAt;
        this.userId = userId;
    }


}
