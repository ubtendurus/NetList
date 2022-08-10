package com.techelevator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class ShoppingList {


private Long listId;
private String listName;
private Long ownerId;
private LocalDate createdAt;
private Long retailerId;
private Long groupId;



    public ShoppingList(Long listId, String listName, Long ownerId, LocalDate createdAt, Long retailerId,Long groupId) {
        this.listName = listName;
        this.ownerId = ownerId;
        this.createdAt = createdAt;
        this.retailerId = retailerId;
        this.groupId = groupId;
        this.listId = listId;
    }

}
