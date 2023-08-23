package com.example.ResumeBuilderApp.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Experience {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int eid;
    @NotEmpty
    private String jobTitle;
    @NotEmpty
    private String jobDescription;
    @NotEmpty
    private String startDate;
    private String endDate;
    @NotNull
    private boolean stillWorking;



}
