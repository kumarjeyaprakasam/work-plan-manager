package com.convergent.workplanmaster.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.lang.reflect.Type;

@Constraint(validatedBy = UniqueNameValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueName {

    Class entityName();
    String propertyName();
    String message() default "Name should be unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
