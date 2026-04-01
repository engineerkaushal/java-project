package com.example.developer.SpringBootDigest.service;

import com.example.developer.SpringBootDigest.dto.UserDTO;
import com.example.developer.SpringBootDigest.entity.User;

import java.util.List;

public interface UserService {

    User  saveUserDetails(UserDTO request);

    List<User> getAllUsers();

    String updateUser();

    User findById(Integer id);

    User updateById(Integer id, UserDTO userDTO);
}
