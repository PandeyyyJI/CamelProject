package com.ofss.model;

public class DataPOJO {
    private int customerId;
    private String customerName;
    private Address address;

    public DataPOJO() {
    }

    public DataPOJO(int customerId, String customerName, Address address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DataPOJO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", address=" + address +
                '}';
    }
}
