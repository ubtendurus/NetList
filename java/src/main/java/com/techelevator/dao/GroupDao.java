package com.techelevator.dao;

import com.techelevator.model.Group;

import java.security.Principal;
import java.util.List;

public interface GroupDao {

    boolean createGroup(Group group, Principal principal);

    boolean updateGroup(Group group);

    void deleteGroup(Long groupId);

    Group getGroupById(Long groupId);

    Group getGroupByName(String groupName);

    List<Group> getAllGroups(Principal principal);

    List<Group> getGroupsByUserId(Long userId);


}
