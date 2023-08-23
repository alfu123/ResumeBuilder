package com.example.ResumeBuilderApp.Entity;

import com.example.ResumeBuilderApp.Validator.PhoneNumberValidation;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "header")
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

//    @OneToOne(targetEntity = Experience.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "exp_id",referencedColumnName = "id")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "header_id")
    private List<Experience> experience=new ArrayList<>();

}
