package com.convergent.workplanmaster.entity;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "work_plan_master")
@ToString
@Getter
@Setter
public class WorkPlanMasterEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "sr_id")
    private Integer srId;

    @Column(name = "plan_name")

    private String planName;

    @Column(name = "plan_start")
    private Date planStart;

    @Column(name = "plan_end")
    private Date planEnd;

    @Column(name = "days_remaining")
    private Integer daysRemaining;

    @Column(name = "percentage_completed")
    private Integer percentageCompleted;

    @Column(name = "delay_days")
    private Integer delayDays;

    @CreatedBy
    @Column(name = "created_by")
    private Long createdBy;


    @Column(name = "updated_by")
    private Long updatedBy;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "version")
    private Long version;

    @Column(name = "status")
    private Boolean status;

    private String planStatus;

    @OneToMany(mappedBy = "MasterEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkPlanMilestonesEntity> listOfWorkPlanMilestones;


}
