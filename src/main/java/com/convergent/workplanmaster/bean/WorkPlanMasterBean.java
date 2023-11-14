package com.convergent.workplanmaster.bean;

import com.convergent.workplanmaster.entity.WorkPlanMasterEntity;
import com.convergent.workplanmaster.validation.DateAfter;
import com.convergent.workplanmaster.validation.FirstGroup;
import com.convergent.workplanmaster.validation.UniqueName;
import com.convergent.workplanmaster.validation.SecondGroup;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.GroupSequence;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@GroupSequence({WorkPlanMasterBean.class, FirstGroup.class, SecondGroup.class})
@UniqueName(
        entityName = WorkPlanMasterEntity.class,
        propertyName = "planName",
        message = "Work plan name should be unique",
        groups = SecondGroup.class)
@DateAfter(
        referenceField = "planStart",
        afterField = "planEnd",
        message = "Plan End should be after Plan Start Date",
        groups = SecondGroup.class)

public class WorkPlanMasterBean {
    private Integer id;
    private Integer srId;
    @NotEmpty(message = "Plan Name cannot be blank")
    private String planName;
    @NotNull(message = "Plan Start cannot be null", groups = FirstGroup.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date planStart;
    @NotNull(message = "Plan end date cannot be null", groups = FirstGroup.class)
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
    private List< WorkPlanMilestonesBean> workPlanMilestonesBeans;
}
