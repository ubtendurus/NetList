package com.techelevator.dao;

import com.techelevator.model.Group;

import java.security.Principal;
import java.util.List;

public interface GroupDao {

    boolean createGroup(Group group, Principal principal);

    boolean updateGroup(Group group,Principal principal);

    void deleteGroup(Long groupId,Principal principal);

    boolean joinGroup(String groupKey,Principal principal);

    Group getGroupById(Long groupId);

    Group getGroupByName(String groupName);

    List<Group> getAllGroups(Principal principal);

    List<Group> getGroupsByUserId(Long userId);


}
