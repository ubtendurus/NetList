package com.techelevator.controller;

import com.techelevator.dao.GroupDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.HttpConstraint;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class GroupController {

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private UserDao userDao;

    public GroupController(GroupDao groupDao,UserDao userDao) {
        this.groupDao = groupDao;
        this.userDao = userDao;
    }

    @GetMapping("/groups")
    public List<Group> getAllGroups() {
        return groupDao.getAllGroups();
    }

    @GetMapping("/groups/{groupId}")
    public Group getGroupById(@PathVariable Long groupId) {
        return groupDao.getGroupById(groupId);
    }

    @PostMapping("/groups")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean createGroup(@RequestBody Group group) {
        return groupDao.createGroup(group);
    }

    @PutMapping("/groups/{groupId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean updateGroup(@PathVariable Long groupId, @RequestBody Group group) {
        return groupDao.updateGroup(group);
    }

    @DeleteMapping("/groups/{groupId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGroup(@PathVariable Long groupId) {
        groupDao.deleteGroup(groupId);
    }

}