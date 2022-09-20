package com.ofss.model;

public class OutputPOJO {

    private int customerId;
    private String customerName;
    private String code;
    private Address address;

    public OutputPOJO() {
    }

    public OutputPOJO(int customerId, String customerName, String code, Address address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OutputPOJO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", code='" + code + '\'' +
                ", address=" + address +
                '}';
    }
}
