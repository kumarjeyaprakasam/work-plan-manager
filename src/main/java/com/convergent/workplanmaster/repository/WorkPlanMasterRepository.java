package com.convergent.workplanmaster.repository;

import com.convergent.workplanmaster.entity.WorkPlanMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkPlanMasterRepository extends JpaRepository<WorkPlanMasterEntity,Integer> {
    boolean existsByPlanName(String name);
}
