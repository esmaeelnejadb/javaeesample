package com.alomonshi.app.service.user.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

@Pattern.List({
        @Pattern(regexp = "[0][9][0-9]{9}")
})
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
@Repeatable(MobilePhone.List.class)
public @interface MobilePhone {
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Pattern.List({
            @Pattern(regexp = "[0][9][0-9]{9}")
    })
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
