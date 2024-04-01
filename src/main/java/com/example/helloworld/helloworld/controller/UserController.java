package com.example.helloworld.helloworld.controller;

import com.example.helloworld.helloworld.entity.Users;
import com.example.helloworld.helloworld.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService serviceobj;

    @GetMapping("/getUsers")
    public List<Users> getUser() {
        return serviceobj.getUser();
    }

    @GetMapping("/getUserById/{id}")
    public Optional<Users> getUserById(@PathVariable int id) {
        return serviceobj.getUserById(id);
    }

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody Users user) {
        logger.info("User received: {}", user);
        try {
            boolean success = serviceobj.addUser(user);
            if (success) {
                return new ResponseEntity<>("User added successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Error adding User", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (DataAccessException e) {
            logger.error("Error adding User", e);
            return new ResponseEntity<>("Database error adding User", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody Users updatedUser) {
        try {
            boolean success = serviceobj.updateUser(updatedUser);
            if (success) {
                return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating User: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        try {
            boolean success = serviceobj.deleteUser(userId);
            if (success) {
                return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting User: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
