package com.techelevator.dao;

import com.techelevator.model.Group;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcGroupDao implements GroupDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcGroupDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean createGroup(Group group) {
        String sql = "INSERT INTO groups (group_name) VALUES (?)";
        return jdbcTemplate.update(sql, group.getGroupName()) > 0;
    }

    @Override
    public boolean updateGroup(Group group) {
        String sql = "UPDATE groups SET group_name = ? WHERE group_id =?";
        return jdbcTemplate.update(sql, group.getGroupName(), group.getGroupId()) > 0;
    }

    @Override
    public void deleteGroup(Group group) {
        String sql = "DELETE FROM groups WHERE group_id = ?";
        jdbcTemplate.update(sql, group.getGroupId());
    }

    @Override
    public Group getGroupById(int groupId) {
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
    public List<Group> getAllGroups() {
        List<Group> groups = new ArrayList<>();
        String sql = "SELECT * FROM groups";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
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
