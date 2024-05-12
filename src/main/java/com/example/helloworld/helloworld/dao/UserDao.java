package com.example.helloworld.helloworld.dao;

import com.example.helloworld.helloworld.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserDao extends JpaRepository<Users, Integer> {
    List<Users> findByEmailId(String emailId);
}
