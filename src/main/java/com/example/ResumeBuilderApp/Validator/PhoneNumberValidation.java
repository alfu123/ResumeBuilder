package com.example.ResumeBuilderApp.Validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumberValidation {
    String message() default "Phone number's first digit must be greater than 5,start with 0-9 and shouldn't be empty ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
