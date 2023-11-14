package com.convergent.workplanmaster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "work_plan_milestones")
@Getter
@Setter
public class WorkPlanMilestonesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "wp_master_id", referencedColumnName = "id")
    @JsonIgnore
    private WorkPlanMasterEntity MasterEntity;

    @Column(name = "milestone_name")
    private String milestoneName;

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

    @Column(name = "plan_actual_diff")
    private Integer planActualDiff;

    @Column(name ="created_by")
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

    @OneToMany(mappedBy = "milestonesEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkPlanTasksEntity> listOfWorkPlanTasks;


   /* public void setMasterEntity(WorkPlanMasterEntity workPlanMasterEntity) {
    }*/
}
