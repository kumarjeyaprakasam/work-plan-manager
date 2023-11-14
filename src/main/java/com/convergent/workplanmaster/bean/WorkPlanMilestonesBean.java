package com.convergent.workplanmaster.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@ToString
public class WorkPlanMilestonesBean {
    private Integer id;
    private Integer wpMasterId;
    @NotBlank(message = "Milestone name cannot be blank")
    private String milestoneName;
    private Integer sequence;
    @NotNull(message = "Milestone plan start date cannot be blank")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date planStart;
    @NotNull(message = "Milestone plan end date cannot be blank")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date planEnd;
    private Integer plannedDays;
    private BigDecimal duration;
    private Date actualStart;
    private Date actualEnd;
    private Integer actualDays;
    private BigDecimal actualDuration;
    private Integer currentWorkStatus;
    private Integer completionPercent;
    private String remarks;
    private Integer planActualDiff;
    private Long createdBy;
    private Long updatedBy;
    private Date createdAt;
    private Date updatedAt;
    private Long version;
    private String status;
    private List<@Valid WorkPlanTasksBean> tasksBeans;
}
