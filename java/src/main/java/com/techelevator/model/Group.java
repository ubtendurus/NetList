package com.techelevator.model;


import lombok.Data;

@Data
public class Group {

    private Long groupId;
    private String groupName;
    private String groupKey;
    private Long ownerId;

    public Group() {

    }

    public Group(Long groupId, String groupName, String groupKey, Long ownerId) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupKey = groupKey;
        this.ownerId = ownerId;
    }

}
