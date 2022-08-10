package com.techelevator.dao;

import com.techelevator.model.Group;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGroupDao implements GroupDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcGroupDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean createGroup(Group group, Principal principal) {
        UserDao userDao = new JdbcUserDao(jdbcTemplate);
        String ownerName = principal.getName();
        Long ownerId = (long) userDao.findIdByUsername(ownerName);

        //System.out.println(getGroupByName(group.getGroupName()));


        String sql = "INSERT INTO groups (group_name) VALUES (?); ";

        jdbcTemplate.update(sql, group.getGroupName());

        Long groupId = getGroupByName(group.getGroupName()).getGroupId();

        String sql2 = "INSERT INTO group_user (group_id, user_id) VALUES (?,?);";
        return jdbcTemplate.update(sql2, groupId, ownerId) > 0;
    }

    @Override
    public boolean updateGroup(Group group) {
        String sql = "UPDATE groups SET group_name = ?, group_key = ? WHERE group_id =?";
        return jdbcTemplate.update(sql, group.getGroupName(), group.getGroupKey(), group.getGroupId()) > 0;
    }

    @Override
    public void deleteGroup(Long groupId) {
        String sql = "DELETE FROM groups WHERE group_id = ?";
        jdbcTemplate.update(sql, groupId);
    }

    @Override
    public Group getGroupById(Long groupId) {
        String sql = "SELECT * FROM groups WHERE group_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupId);
        if (results.next()) {
            return mapRowToGroup(results);
        } else {
            throw new IllegalArgumentException("No Match Found!");
        }
    }

    @Override
    public Group getGroupByName(String groupName) {
        String sql = "SELECT * FROM groups WHERE group_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupName);
        if (results.next()) {
            return mapRowToGroup(results);
        } else {
            throw new IllegalArgumentException("No Match Found!");
        }
    }

    @Override
    public List<Group> getAllGroups(Principal principal) {
        List<Group> groups = new ArrayList<>();
        String userName = principal.getName();
        UserDao userDao = new JdbcUserDao(jdbcTemplate);
        Long userId = (long) userDao.findIdByUsername(userName);


        String sql = "SELECT * FROM groups WHERE group_id IN (SELECT group_id FROM group_user WHERE user_id = ?)";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Group group = mapRowToGroup(results);
            groups.add(group);
        }
        return groups;
    }

    @Override
    public List<Group> getGroupsByUserId(Long userId) {
        List<Group> groups = new ArrayList<>();
        String sql = "SELECT * FROM groups WHERE group_id = " +
                "(SELECT group_id FROM group_user WHERE user_id = ?)";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Group group = mapRowToGroup(results);
            groups.add(group);
        }
        return groups;
    }

    private Group mapRowToGroup(SqlRowSet results) {
        Group group = new Group();
        group.setGroupId(results.getLong("group_id"));
        group.setGroupName(results.getString("group_name"));
        return group;
    }
}
