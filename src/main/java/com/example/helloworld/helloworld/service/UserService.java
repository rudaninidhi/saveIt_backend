package com.example.helloworld.helloworld.service;

import com.example.helloworld.helloworld.dao.UserDao;
import com.example.helloworld.helloworld.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDao user;

    public List<Users> getUser() {
        return user.findAll();
    }

    public List<Users> getUserList() {
        return user.findAll();
    }

    public Optional<Users> getUserById(int id) {
        return user.findById(id);
    }

    public boolean addUser(@RequestBody Users user1) {
        try {
            user.save(user1);
            System.out.println("here" + user1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateUser(Users updatedUser) {
        try {
            if (!user.existsById(updatedUser.getUserId())) {
                return false;
            }
            user.save(updatedUser);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteUser(int userId) {
        try {
            if (user.existsById(userId)) {
                user.deleteById(userId);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //logic for database
        return new User("admin","password0",new ArrayList());
    }

}
