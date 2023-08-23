package com.example.ResumeBuilderApp.Dao;

import com.example.ResumeBuilderApp.Entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceDao extends JpaRepository<Experience,Integer> {

}
