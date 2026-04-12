package com.example.developer.SpringBootDigest.dto;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {

    private String customerName;

    private Integer age;

    private String email;

    private Long mobileNumber;

    private List<OrderDTO> orders = new ArrayList<> (  );

    public
    String getCustomerName () {
        return customerName;
    }

    public
    void setCustomerName (String customerName) {
        this.customerName = customerName;
    }

    public
    Integer getAge () {
        return age;
    }

    public
    void setAge (Integer age) {
        this.age = age;
    }

    public
    String getEmail () {
        return email;
    }

    public
    void setEmail (String email) {
        this.email = email;
    }

    public
    Long getMobileNumber () {
        return mobileNumber;
    }

    public
    void setMobileNumber (Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public
    List<OrderDTO> getOrders () {
        return orders;
    }

    public
    void setOrders (List<OrderDTO> orders) {
        this.orders = orders;
    }

    @Override
    public
    String toString () {
        return "CustomerDTO{" +
                "customerName='" + customerName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", orders=" + orders +
                '}';
    }
}
