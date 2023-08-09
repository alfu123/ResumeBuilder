package com.example.ResumeBuilderApp.Dao;

import com.example.ResumeBuilderApp.Entity.Header;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderDao extends JpaRepository<Header,Integer> {
}
