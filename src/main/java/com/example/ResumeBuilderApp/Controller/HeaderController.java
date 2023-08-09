package com.example.ResumeBuilderApp.Controller;

import com.example.ResumeBuilderApp.Entity.Header;
import com.example.ResumeBuilderApp.Service.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/headers")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HeaderController {
    @Autowired
    HeaderService headerService;

    @PostMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Header> addHeader(@Valid @RequestBody Header header){
        return ResponseEntity.status(HttpStatus.CREATED).body(headerService.addHeaderDetails(header));
    }
}
