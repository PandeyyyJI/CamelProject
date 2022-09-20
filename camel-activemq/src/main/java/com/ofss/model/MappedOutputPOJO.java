package com.ofss.model;

public class MappedOutputPOJO {

    private String customerId;
    private String customerName;
    private String code;
    private String customerAddress1;
    private String customerAddress2;

    public MappedOutputPOJO() {
    }

    public MappedOutputPOJO(String customerId, String customerName, String code, String customerAddress1, String customerAddress2) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.code = code;
        this.customerAddress1 = customerAddress1;
        this.customerAddress2 = customerAddress2;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
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

    public String getCustomerAddress1() {
        return customerAddress1;
    }

    public void setCustomerAddress1(String customerAddress1) {
        this.customerAddress1 = customerAddress1;
    }

    public String getCustomerAddress2() {
        return customerAddress2;
    }

    public void setCustomerAddress2(String customerAddress2) {
        this.customerAddress2 = customerAddress2;
    }

    @Override
    public String toString() {
        return "MappedOutputPOJO{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", code='" + code + '\'' +
                ", customerAddress1='" + customerAddress1 + '\'' +
                ", customerAddress2='" + customerAddress2 + '\'' +
                '}';
    }
}
