package com.techelevator.model;

public class Retailer {
    private Long retailerId;
    private String retailerName;

    public Retailer(){

    }

    public Retailer(Long retailerId, String retailerName) {
        this.retailerId = retailerId;
        this.retailerName = retailerName;
    }

    public Long getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(Long retailerId) {
        this.retailerId = retailerId;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }
}
