package com.convergent.workplanmaster.service;

import com.convergent.workplanmaster.bean.WorkPlanMilestonesBean;


import java.util.List;

public interface WorkPlanMilestonesService {
    List<WorkPlanMilestonesBean> getAllMilestones();
    WorkPlanMilestonesBean getMilestoneById(Integer id);
    WorkPlanMilestonesBean createMilestone(WorkPlanMilestonesBean workPlanMilestonesBean);
    WorkPlanMilestonesBean updateMilestone(Integer id, WorkPlanMilestonesBean workPlanMilestonesBean);
    void deleteMilestone(Integer id);
}
