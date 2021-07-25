package com.alomonshi.app.service.user.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintTarget;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {MobilePhoneValidator.class})
@Documented
@Target({
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.PARAMETER,
        ElementType.CONSTRUCTOR,
        ElementType.TYPE,
        ElementType.TYPE_USE,
})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MobilePhone.List.class)
public @interface MobilePhone {
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    ConstraintTarget target() default ConstraintTarget.PARAMETERS;
    @Constraint(validatedBy = {})
    @Documented
    @Target({
            ElementType.METHOD,
            ElementType.FIELD,
            ElementType.PARAMETER,
            ElementType.CONSTRUCTOR,
            ElementType.TYPE,
            ElementType.TYPE_USE,
    })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        MobilePhone[] value();
    }
}
