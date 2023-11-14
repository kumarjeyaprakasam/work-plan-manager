package com.convergent.workplanmaster.bean;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@ToString
public class WorkPlanTasksBean {
    private Integer id;
    private Integer wpMilestoneId;
    @NotBlank(message = "Task Detail cannot be null")
    private String taskDetail;
    private String assignedTo;
    private Integer sequence;
    private Date planStart;
    private Date planEnd;
    private Integer plannedDays;
    private BigDecimal duration;
    private Integer dependentId;
    private Date actualStart;
    private Date actualEnd;
    private Integer actualDays;
    private BigDecimal actualDuration;
    private Integer currentWorkStatus;
    private Integer completionPercent;
    private String remarks;
    private Boolean delayedStart;
    private Boolean delayedEnd;
    private Integer planActualDiff;
    private WorkPlanStatusBean planStatusId;
    private Long createdBy;
    private Long updatedBy;
    private Date createdAt;
    private Date updatedAt;
    private Long version;
    private String status;
}
