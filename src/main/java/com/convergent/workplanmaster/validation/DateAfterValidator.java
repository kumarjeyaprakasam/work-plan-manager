package com.convergent.workplanmaster.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Date;

public class DateAfterValidator implements ConstraintValidator<DateAfter, Object> {

    private final Logger logger = LoggerFactory.getLogger(DateAfterValidator.class);

    private String referenceField;
    private String afterField;

    @Override
    public void initialize(DateAfter dateAfter) {
        referenceField = dateAfter.referenceField();
        afterField = dateAfter.afterField();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext ctx) {
        Object referenceDate = new BeanWrapperImpl(o).getPropertyValue(referenceField);
        Object afterDate = new BeanWrapperImpl(o).getPropertyValue(afterField);
        logger.info("Date Check : Date {} should be after {}", afterDate, referenceDate);
        return (referenceDate != null && afterDate != null && ((Date) afterDate).after((Date) referenceDate));

    }
}
