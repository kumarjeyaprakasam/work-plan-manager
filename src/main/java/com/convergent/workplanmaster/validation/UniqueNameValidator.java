package com.convergent.workplanmaster.validation;

import com.convergent.workplanmaster.entity.WorkPlanMasterEntity;
import com.convergent.workplanmaster.repository.WorkPlanMasterRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, Object> {

    private final Logger logger = LoggerFactory.getLogger(UniqueNameValidator.class);

    private Class entityType;
    private String propertyName;

    @Autowired
    private WorkPlanMasterRepository workPlanMasterRepository;

    @Override
    public void initialize(UniqueName uniqueName) {
        entityType = uniqueName.entityName();
        propertyName = uniqueName.propertyName();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        Object propertyValueToCheck = new BeanWrapperImpl(o).getPropertyValue(propertyName);
        logger.info("Unique Validation Check for entity {} and property {} with value {}", entityType, propertyName, propertyValueToCheck);

        if(entityType == WorkPlanMasterEntity.class ){
            return !workPlanMasterRepository.existsByPlanName((String) propertyValueToCheck);
        }
        return true;
    }
}
