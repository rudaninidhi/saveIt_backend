package com.example.helloworld.helloworld.Controller;

import com.example.helloworld.helloworld.Entity.Income;
import com.example.helloworld.helloworld.Entity.Users;
import com.example.helloworld.helloworld.Service.IncomeService;
import com.example.helloworld.helloworld.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class UserController {
    @Autowired
    UserService serviceobj;

    @GetMapping("/getUsers")
    public List<Users> getUser(){
        return serviceobj.getUser();
    }

    @GetMapping("/getUserById/{id}")
    public Optional<Users> getUserById(@PathVariable int id){
        System.out.println( serviceobj.getUserById(id));
        return serviceobj.getUserById(id);
    }
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody Users user) {
        logger.info("User received: {}", user);
        try {
            serviceobj.addUser(user);
            return new ResponseEntity<>("User added successfully", HttpStatus.OK);
        } catch (DataAccessException e) {
            logger.error("Error adding Income", e);
            return new ResponseEntity<>("Database error adding User", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            logger.error("Unexpected error adding User", e);
            return new ResponseEntity<>("Error adding User: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody Users updatedUser) {
        try {
            System.out.println("method called");
            serviceobj.updateUser(updatedUser);
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating User: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteUser/{incomeId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        try {
            serviceobj.deleteUser(userId);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting User: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
