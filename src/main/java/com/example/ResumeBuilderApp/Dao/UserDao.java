package com.example.ResumeBuilderApp.Dao;

import com.example.ResumeBuilderApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    public User findByUserName(String userName);
}
