package com.example.developer.SpringBootDigest.dto;

import jakarta.persistence.Column;

import java.util.Date;

public class UserDTO {

    private String userName;

    private String department;

    private String email;

    private Integer age;

    private Long mobileNumber;

    private Double salary;

    private String dateOfJoining;

    public
    String getUserName () {
        return userName;
    }

    public
    void setUserName (String userName) {
        this.userName = userName;
    }

    public
    String getDepartment () {
        return department;
    }

    public
    void setDepartment (String department) {
        this.department = department;
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
    Integer getAge () {
        return age;
    }

    public
    void setAge (Integer age) {
        this.age = age;
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
    Double getSalary () {
        return salary;
    }

    public
    void setSalary (Double salary) {
        this.salary = salary;
    }

    public
    String getDateOfJoining () {
        return dateOfJoining;
    }

    public
    void setDateOfJoining (String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}
