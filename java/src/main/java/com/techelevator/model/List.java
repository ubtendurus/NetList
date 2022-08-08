package com.techelevator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


public class List {
    private Long listId;
private String listName;
private Long ownerId;
private Date createdAt;
private Long retailerId;

public List(){

}


    public List(Long listId, String listName, Long ownerId, Date createdAt, Long retailerId) {
        this.listId = listId;
        this.listName = listName;
        this.ownerId = ownerId;
        this.createdAt = createdAt;
        this.retailerId = retailerId;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(Long retailerId) {
        this.retailerId = retailerId;
    }
}
