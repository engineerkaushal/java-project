package com.example.developer.SpringBootDigest.controller;

import com.example.developer.SpringBootDigest.dto.CustomerDTO;
import com.example.developer.SpringBootDigest.oneToManyEntity.CustomerEntity;
import com.example.developer.SpringBootDigest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cust")
public class CustomerController {

    @Autowired
    private  CustomerService customerService;


    @PostMapping("/save")
    public
    ResponseEntity<?> saveCustomerDetails(@RequestBody CustomerDTO request) {
        CustomerEntity details;
        try {
            details = customerService.saveCustomerDetails (request);
        } catch (Exception e) {
            throw new RuntimeException ( "Error while save user details : " , e );
        }
        return new ResponseEntity<> (details, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllCustomers() {
        List<CustomerEntity> details;
        try {
            details = customerService.getAllCustomers ();
            System.out.println (details.get (0).getOrders () );//I have for check LazyInitializationException
        } catch (Exception e) {
            throw new RuntimeException ( "Error while get user details : " , e );
        }
        return new ResponseEntity<> (details, HttpStatus.OK);
    }


    @GetMapping("/findByCustId/{id}")
    public ResponseEntity<?> findByCustId(@PathVariable int id) {
        CustomerEntity details;
        try {
            details = customerService.findByCustId (id);
        } catch (Exception e) {
            throw new RuntimeException ( "Error while get user details : " , e );
        }
        return new ResponseEntity<> (details, HttpStatus.OK);
    }


    @GetMapping("/findByCustIdOrDefault")
    public ResponseEntity<?> findByCustIdOrDefault(@RequestParam(required = false) Integer id) {
        try {
            if ( id != null ) {
                return new ResponseEntity<> (customerService.findByCustId (id), HttpStatus.OK);
            } else {
                return new ResponseEntity<> (customerService.getAllCustomers (), HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new RuntimeException ( "Error while get user details : " , e );
        }
    }


    @PostMapping("/updateCustomer")
    public ResponseEntity<?> updateCustomer() {
        String response;
        try {
            response = customerService.updateCustomer ();
        } catch (Exception e) {
            throw new RuntimeException ( "Error while get user details : " , e );
        }
        return new ResponseEntity<> (response, HttpStatus.OK);
    }
}
