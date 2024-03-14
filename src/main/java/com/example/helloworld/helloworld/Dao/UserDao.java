package com.example.helloworld.helloworld.Dao;

import com.example.helloworld.helloworld.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Users,Integer> {
}
