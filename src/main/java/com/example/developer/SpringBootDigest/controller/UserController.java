package com.example.developer.SpringBootDigest.controller;

import com.example.developer.SpringBootDigest.dto.UserDTO;
import com.example.developer.SpringBootDigest.entity.User;
import com.example.developer.SpringBootDigest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public ResponseEntity<?> saveUserDetails(@RequestBody UserDTO request) {
        User details;
        try {
            details = userService.saveUserDetails (request);
        } catch (Exception e) {
            throw new RuntimeException ( "Error while save user details : " , e );
        }
        return new ResponseEntity<> (details, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllUser() {
        List<User> details;
        try {
            details = userService.getAllUsers ();
        } catch (Exception e) {
            throw new RuntimeException ( "Error while get user details : " , e );
        }
        return new ResponseEntity<> (details, HttpStatus.OK);
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        User details;
        try {
            details = userService.findById (id);
        } catch (Exception e) {
            throw new RuntimeException ( "Error while get user details : " , e );
        }
        return new ResponseEntity<> (details, HttpStatus.OK);
    }


    @GetMapping("/findByIdOrDefault")
    public ResponseEntity<?> findByIdOrDefault(@RequestParam(required = false) Integer id) {
        try {
            if ( id != null ) {
                return new ResponseEntity<> (userService.findById (id), HttpStatus.OK);
            } else {
                return new ResponseEntity<> (userService.getAllUsers (), HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new RuntimeException ( "Error while get user details : " , e );
        }
    }


    @PostMapping("/updateSalary")
    public ResponseEntity<?> updateSalary() {
        String response;
        try {
            response = userService.updateUser ();
        } catch (Exception e) {
            throw new RuntimeException ( "Error while get user details : " , e );
        }
        return new ResponseEntity<> (response, HttpStatus.OK);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        User user;
        try {
            user = userService.updateById (id, userDTO);
        } catch (Exception e) {
            throw new RuntimeException ( "Error while get user details : " , e );
        }
        return new ResponseEntity<> (user, HttpStatus.OK);
    }
}
