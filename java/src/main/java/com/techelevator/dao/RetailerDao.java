package com.techelevator.dao;

import com.techelevator.model.Retailer;

import java.util.List;

public interface RetailerDao {
    boolean createRetailer(Retailer retailer);
    boolean updateRetailer(Retailer retailer);
    void deleteRetailer(Retailer retailer);
    Retailer getRetailerById(int retailerId);
    Retailer getRetailerByName(String retailerName);
    List<Retailer> getAllRetailers();
}
