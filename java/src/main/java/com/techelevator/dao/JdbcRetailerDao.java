package com.techelevator.dao;

import com.techelevator.model.Retailer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRetailerDao implements RetailerDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcRetailerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean createRetailer(Retailer retailer) {
        String sql="INSERT INTO retailers (retailer_name) VALUES (?)";
        return jdbcTemplate.update(sql, retailer.getRetailerName()) > 0;
    }

    @Override
    public boolean updateRetailer(Retailer retailer) {
        String sql="UPDATE retailers SET retailer_name = ? WHERE retailer_id = ?";
        return jdbcTemplate.update(sql, retailer.getRetailerName(), retailer.getRetailerId()) > 0;
    }

    @Override
    public void deleteRetailer(Retailer retailer) {
        String sql="DELETE FROM retailers WHERE retailer_id = ?";
        jdbcTemplate.update(sql, retailer.getRetailerId());
    }

    @Override
    public Retailer getRetailerById(int retailerId) {
        String sql="SELECT * FROM retailers WHERE retailer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, retailerId);
        if (results.next()) {
            return mapRowToRetailer(results);
        } else {
            throw new IllegalArgumentException("No Match Found!");
        }
    }

    @Override
    public Retailer getRetailerByName(String retailerName) {
        String sql="SELECT * FROM retailers WHERE retailer_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, retailerName);
        if (results.next()) {
            return mapRowToRetailer(results);
        } else {
            throw new IllegalArgumentException("No Match Found!");
        }
    }

    @Override
    public List<Retailer> getAllRetailers() {
        List<Retailer> retailers = new ArrayList<>();
        String sql = "SELECT * FROM retailers";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            retailers.add(mapRowToRetailer(results));
        }
        return retailers;
    }

    private Retailer mapRowToRetailer(SqlRowSet results) {
        Retailer retailer = new Retailer();
        retailer.setRetailerId(results.getLong("retailer_id"));
        retailer.setRetailerName(results.getString("retailer_name"));
        return retailer;
    }
}
