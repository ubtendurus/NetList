package com.techelevator.model;

public class Group {
    private Long groupId;
    private String groupName;
    private String groupKey;

    public Group() {

    }

    public Group(Long groupId, String groupName, String groupKey) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupKey = groupKey;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }
}
