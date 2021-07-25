package com.alomonshi.app.service.user.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class MobilePhoneValidator implements ConstraintValidator<MobilePhone, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Pattern.matches(value, "[0][9][0-9]{9}");
    }
}
