package com.techelevator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemShoppingList {
    private int quantity;
    private boolean isPurchased;
    private String itemNote;

    public ItemShoppingList(int quantity, boolean isPurchased, String itemNote) {
        this.quantity = quantity;
        this.isPurchased = isPurchased;
        this.itemNote = itemNote;
    }
}
