package com.convergent.workplanmaster.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = DateAfterValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DateAfter {

    String referenceField();
    String afterField();
    String message() default "The date should be after the reference field ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

