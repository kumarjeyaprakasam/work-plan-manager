package com.convergent.workplanmaster.bean;

import com.convergent.workplanmaster.entity.WorkPlanMasterEntity;
import com.convergent.workplanmaster.validation.DateAfter;
import com.convergent.workplanmaster.validation.UniqueName;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@UniqueName(entityName = WorkPlanMasterEntity.class, propertyName = "planName", message = "Work plan name should be unique")
@DateAfter(referenceField="planStart", afterField = "planEnd", message = "Plan End should be after Plan Start Date")
public class WorkPlanMasterBean {
    private Integer id;
    private Integer srId;
    @NotEmpty(message = "Plan Name cannot be blank")
    private String planName;
    @NotNull(message = "Plan Start cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date planStart;
    @NotNull(message = "Plan end date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date planEnd;
    private Integer daysRemaining;
    private Integer percentageCompleted;
    private Integer delayDays;
    private Long createdBy;
    private Long updatedBy;
    private Date createdAt;
    private Date updatedAt;
    private Long version;
    private Boolean status;
    private WorkPlanStatusBean planStatusId;
    private List<@Valid WorkPlanMilestonesBean> workPlanMilestonesBeans;
}
