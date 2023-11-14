package com.convergent.workplanmaster.repository;

import com.convergent.workplanmaster.entity.WorkPlanMilestonesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkPlanMilestonesRepository  extends JpaRepository<WorkPlanMilestonesEntity,Integer> {
}
