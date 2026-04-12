package com.example.developer.SpringBootDigest.service;

import com.example.developer.SpringBootDigest.dto.CustomerDTO;
import com.example.developer.SpringBootDigest.dto.UserDTO;
import com.example.developer.SpringBootDigest.entity.User;
import com.example.developer.SpringBootDigest.oneToManyEntity.CustomerEntity;

import java.util.List;

public interface CustomerService {

    CustomerEntity saveCustomerDetails(CustomerDTO request);

    List<CustomerEntity> getAllCustomers();

    String updateCustomer();

    CustomerEntity findByCustId(Integer id);

    CustomerEntity updateByCustId(Integer id, CustomerDTO request);
}
