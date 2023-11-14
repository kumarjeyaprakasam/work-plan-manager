package com.convergent.workplanmaster.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "work_plan_tasks")
public class WorkPlanTasksEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "wp_milestone_id", referencedColumnName = "id")
    private WorkPlanMilestonesEntity milestonesEntity;

    @Column(name = "task_detail")
    private String taskDetail;

    @Column(name = "assigned_to")
    private String assignedTo;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "plan_start")
    private Date planStart;

    @Column(name = "plan_end")
    private Date planEnd;

    @Column(name = "planned_days")
    private Integer plannedDays;

    @Column(name = "duration")
    private BigDecimal duration;

    @Column(name = "dependent_id")
    private Integer dependentId;

    @Column(name = "actual_start")
    private Date actualStart;

    @Column(name = "actual_end")
    private Date actualEnd;

    @Column(name = "actual_days")
    private Integer actualDays;

    @Column(name = "actual_duration")
    private BigDecimal actualDuration;

    @Column(name = "current_work_status")
    private Integer currentWorkStatus;

    @Column(name = "completion_percent")
    private Integer completionPercent;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "delayed_start")
    private Boolean delayedStart;

    @Column(name = "delayed_end")
    private Boolean delayedEnd;

    @Column(name = "plan_actual_diff")
    private Integer planActualDiff;

    private String planStatus;

    @Column(name="created_by")
    private Long createdBy;

    @Column(name="updated_by")
    private Long updatedBy;

    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name="version")
    private Long version;

    @Column(name="status")
    private String status;
}
