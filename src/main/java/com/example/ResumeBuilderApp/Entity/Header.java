package com.example.ResumeBuilderApp.Entity;

import com.example.ResumeBuilderApp.Validator.PhoneNumberValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Header {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int hid;

    @NotEmpty
    @Size(min = 4,message = "Your name should be atleast 4 chracters")
    private String name;
    @NotEmpty
    @Email
    private String emailAddress;
    @PhoneNumberValidation
    private String phoneNo;

    private String address;
    @NotEmpty
    @URL(message = "Invalid url format")
    private String linkedInAddress;
    @NotEmpty
    @URL(message = "Invalid url format")
    private String imageUrl;

}
