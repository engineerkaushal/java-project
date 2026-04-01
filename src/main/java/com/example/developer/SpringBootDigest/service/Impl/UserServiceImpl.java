package com.example.developer.SpringBootDigest.service.Impl;

import com.example.developer.SpringBootDigest.dto.UserDTO;
import com.example.developer.SpringBootDigest.entity.User;
import com.example.developer.SpringBootDigest.repository.UserRepository;
import com.example.developer.SpringBootDigest.service.UserService;
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
public class UserServiceImpl implements UserService {

    public static final Logger log = LoggerFactory.getLogger (UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUserDetails (UserDTO request) {
        User response = new User ();
        try {
            response.setUserName (request.getUserName ());
            response.setAge (request.getAge ());
            response.setDepartment (request.getDepartment ());
            response.setEmail (request.getEmail ());
            response.setMobileNumber (request.getMobileNumber ());
            response.setSalary (request.getSalary ());
            response = userRepository.save (response);
        } catch (Exception e) {
            throw new RuntimeException (e);
        }
        return response;
    }

    @Override
    public List<User> getAllUsers () {
        List<User> users = null;
        try {
            log.info ("UserServiceImpl :: getAllUsers() Started...");
            users = userRepository.findAll ( );
            log.info ("UserServiceImpl :: getAllUsers() End...");
        } catch (Exception e) {
            log.info ("Exception in UserServiceImpl :: getAllUsers() : Exception ", e);
        }
        return users;
    }

    @Override
    public String updateUser () {
        try {
            List<User> userList = getAllUsers ( );
            userList.stream ().filter (f -> !StringUtils.isBlank (f.getDateOfJoining ())).forEach (value -> {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate givenDate = LocalDate.parse(value.getDateOfJoining (), formatter);
                Period period = Period.between (givenDate,LocalDate.now () );
                if ( period.getYears () > 5 ) {
                    value.setSalary (value.getSalary ( ) + (value.getSalary ( ) * 0.1));
                    userRepository.save (value);
                }
            });
        } catch (Exception e) {
            log.info ("Exception in UserServiceImpl :: updateUser() : Exception ", e);
        }
        return "User Updated successfully..";
    }

    @Override
    public User findById (Integer id) {
        return userRepository.findById (id).orElseThrow ( () -> new RuntimeException ( "User details not found for id{} "+ id ) );
    }

    @Override
    public User updateById (Integer id, UserDTO userDTO) {
        User save = null;
        try {
            if ( id != null ) {
                User user = findById (id);
                if ( user != null ) {
                    user.setUserName (StringUtils.isEmpty (userDTO.getUserName ()) ? user.getUserName () : userDTO.getUserName ());
                    save = userRepository.save (user);
                }
            } else {
                throw new RuntimeException ( "User details not found for userId " + id );
            }
        } catch (Exception e) {

        }
        return save;
    }
}
