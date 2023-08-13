package com.example.ResumeBuilderApp.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberValidation,String> {
    @Override
    public void initialize(PhoneNumberValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phoneNo, ConstraintValidatorContext context) {
        char firstDigit=phoneNo.charAt(0);
        String phoneNoMatcher="^[0-9]{10}$";
        return phoneNo.matches(phoneNoMatcher) && firstDigit>'5';
    }
}
