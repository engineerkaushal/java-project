package com.example.developer.SpringBootDigest.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_tbl")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "department")
    private String department;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private Long mobileNumber;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "date_of_joining")
    private String dateOfJoining;


    public
    Integer getUserId () {
        return userId;
    }

    public
    void setUserId (Integer userId) {
        this.userId = userId;
    }

    public
    String getUserName () {
        return userName;
    }

    public
    void setUserName (String userName) {
        this.userName = userName;
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

    public String getDateOfJoining () {
        return dateOfJoining;
    }

    public void setDateOfJoining (String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}
