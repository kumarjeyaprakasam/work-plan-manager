package com.convergent.workplanmaster.repository;

import com.convergent.workplanmaster.entity.UserMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMasterEntity,Integer> {
}
