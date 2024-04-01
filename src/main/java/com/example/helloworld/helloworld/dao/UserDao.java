package com.example.helloworld.helloworld.dao;

import com.example.helloworld.helloworld.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Users,Integer> {
}
