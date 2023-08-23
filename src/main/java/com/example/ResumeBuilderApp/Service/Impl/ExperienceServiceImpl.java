package com.example.ResumeBuilderApp.Service.Impl;

import com.example.ResumeBuilderApp.Dao.ExperienceDao;
import com.example.ResumeBuilderApp.Entity.Experience;
import com.example.ResumeBuilderApp.Service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ExperienceServiceImpl implements ExperienceService {
    @Autowired
    private ExperienceDao experienceDao;
    @Override
    public Experience addExperienceDetails(Experience experience){
        String inputStartDate=experience.getStartDate();
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate startLocalDate = LocalDate.parse(inputStartDate, inputFormatter);
        String formattedStartDate = startLocalDate.format(outputFormatter);
        experience.setStartDate(formattedStartDate);

        if(experience.isStillWorking()==true){
            experience.setEndDate("Present");
        }

        else {
            String inputEndDate = experience.getEndDate();
            LocalDate endLocalDate = LocalDate.parse(inputEndDate, inputFormatter);
            String formattedEndDate = endLocalDate.format(outputFormatter);
            experience.setEndDate(formattedEndDate);
        }
        return experienceDao.save(experience);
    }
}
