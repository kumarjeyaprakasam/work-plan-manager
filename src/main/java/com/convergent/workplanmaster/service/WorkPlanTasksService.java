package com.convergent.workplanmaster.service;

import com.convergent.workplanmaster.bean.WorkPlanTasksBean;

import java.util.List;

public interface WorkPlanTasksService {
    List<WorkPlanTasksBean> getAllTasks();
    WorkPlanTasksBean getTaskById(Integer id);
    WorkPlanTasksBean createTask(WorkPlanTasksBean workPlanTasksBean);
    WorkPlanTasksBean updateTask(Integer id, WorkPlanTasksBean workPlanTasksBean);
    void deleteTask(Integer id);

}
