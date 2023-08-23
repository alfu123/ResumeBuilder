package com.example.ResumeBuilderApp.Controller;

import com.example.ResumeBuilderApp.Entity.Experience;
import com.example.ResumeBuilderApp.Service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/experience")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExperienceController {

    @Autowired
    ExperienceService experienceService;

    @PostMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Experience> addExperience(@Valid @RequestBody Experience experience){
        return ResponseEntity.status(HttpStatus.CREATED).body(experienceService.addExperienceDetails(experience));
    }
}
