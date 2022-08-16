package com.techelevator.dao;

import com.techelevator.model.Group;
import com.techelevator.model.User;

import java.security.Principal;
import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);

    List<User> getUsersByGroupId(Long groupId, Principal principal);

    List<User> getUsersByListId(Long listId);
}
