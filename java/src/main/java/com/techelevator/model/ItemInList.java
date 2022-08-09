package com.techelevator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemInList {

    private Long itemInListId;
    private Long itemId;
    private Long listId;
    private int quantity;
    private boolean isPurchased;
    private String itemNote;

    public ItemInList(Long itemInListId, Long itemId, Long listId, int quantity, boolean isPurchased, String itemNote) {
        this.itemInListId = itemInListId;
        this.itemId = itemId;
        this.listId = listId;
        this.quantity = quantity;
        this.isPurchased = isPurchased;
        this.itemNote = itemNote;
    }

}
