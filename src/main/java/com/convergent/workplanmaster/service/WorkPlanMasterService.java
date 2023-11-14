package com.convergent.workplanmaster.service;

import com.convergent.workplanmaster.bean.WorkPlanMasterBean;

import java.util.List;

public interface WorkPlanMasterService {

     List<WorkPlanMasterBean> getAllPlans();
    WorkPlanMasterBean getPlanById(Integer id);
    WorkPlanMasterBean createPlan(WorkPlanMasterBean workPlanMasterBean);
    WorkPlanMasterBean updatePlan(Integer id, WorkPlanMasterBean workPlanMasterBean);
    void deletePlan(Integer id);
}
