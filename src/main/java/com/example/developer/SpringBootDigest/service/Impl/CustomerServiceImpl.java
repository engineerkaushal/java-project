package com.example.developer.SpringBootDigest.service.Impl;

import com.example.developer.SpringBootDigest.dto.CustomerDTO;
import com.example.developer.SpringBootDigest.entity.User;
import com.example.developer.SpringBootDigest.oneToManyEntity.CustomerEntity;
import com.example.developer.SpringBootDigest.oneToManyEntity.OrderEntity;
import com.example.developer.SpringBootDigest.repository.CustomerRepository;
import com.example.developer.SpringBootDigest.service.CustomerService;
import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    public static final Logger log = LoggerFactory.getLogger (CustomerServiceImpl.class);

    @Autowired
    private  CustomerRepository customerRepository;


    @Override
    public CustomerEntity saveCustomerDetails (CustomerDTO request) {
        CustomerEntity response = new CustomerEntity ();
        try {
            response.setCustomerName (request.getCustomerName ());
            response.setCustomerAge (request.getAge ());
            response.setEmail (request.getEmail ());
            response.setMobileNumber (request.getMobileNumber ( ));
            if ( request.getOrders() != null && !request.getOrders ().isEmpty () ) {
                List<OrderEntity> list = request.getOrders ( ).stream ( ).map (value -> {
                    OrderEntity order = new OrderEntity ( );
                    order.setProductName (value.getProductName ( ));
                    order.setProductPrice (value.getProductPrice ( ));
                    order.setRating (value.getRating ( ));
                    order.setCustomer (response);
                    return order;
                }).toList ( );
                response.setOrders (list);
            }

            customerRepository.save (response);
        } catch (Exception e) {
            throw new RuntimeException (e);
        }
        return response;
    }

    @Override
    public List<CustomerEntity> getAllCustomers () {
        List<CustomerEntity> response = null;
        try {
            //response = customerRepository.findAll ();
            response = customerRepository.fetchCustomerWithOrder ();
        } catch (Exception e) {
            throw new RuntimeException (e);
        }
        return response;
    }

    @Override
    public String updateCustomer () {
        try {
            List<CustomerEntity> customers = getAllCustomers ( );
            customers.stream ().filter (f -> f.getCustomerId () == 6).forEach (value -> {
                value.setCustomerName ("Saurabh Singh");
                value.getOrders ().stream ()
                        .filter (f -> f.getCustomer ().getCustomerId () == 6)
                        .forEach (val -> {
                            val.setRating (5);
                        });
                customerRepository.save (value);
            });
        } catch (Exception e) {
            log.info ("Exception in UserServiceImpl :: updateCustomer() : Exception ", e);
        }
        return "Customer Updated successfully..";
    }

    @Override
    public CustomerEntity findByCustId (Integer id) {
        return customerRepository.findById (id)
                .orElseThrow ( () -> new RuntimeException ( "Customer details not found for id{} "+ id ) );

    }

    @Override
    public CustomerEntity updateByCustId (Integer id, CustomerDTO request) {
        return null;
    }
}
