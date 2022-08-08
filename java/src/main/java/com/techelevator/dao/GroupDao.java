package com.techelevator.dao;

import com.techelevator.model.Group;

import java.util.List;

public interface GroupDao {

    boolean createGroup(Group group);

    boolean updateGroup(Group group);

    void deleteGroup(Group group);

    Group getGroupById(Long groupId);

    Group getGroupByName(String groupName);

    List<Group> getAllGroups();

    List<Group> getGroupsByUserId(Long userId);
}
