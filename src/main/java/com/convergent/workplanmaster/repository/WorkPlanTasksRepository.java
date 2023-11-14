package com.convergent.workplanmaster.repository;

import com.convergent.workplanmaster.entity.WorkPlanTasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkPlanTasksRepository extends JpaRepository<WorkPlanTasksEntity,Integer> {
}
