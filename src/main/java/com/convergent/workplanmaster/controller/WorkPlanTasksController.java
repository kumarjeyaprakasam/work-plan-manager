package com.convergent.workplanmaster.controller;

import com.convergent.workplanmaster.bean.WorkPlanMasterBean;
import com.convergent.workplanmaster.bean.WorkPlanTasksBean;
import com.convergent.workplanmaster.service.WorkPlanTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/workplantasks")
public class WorkPlanTasksController {
    private  final WorkPlanTasksService workPlanTasksService;
    @Autowired
    public WorkPlanTasksController(WorkPlanTasksService workPlanTasksService) {
        this.workPlanTasksService = workPlanTasksService;
    }
    @GetMapping("/alltasks")
    public List<WorkPlanTasksBean> getAllTasks(){

        return workPlanTasksService.getAllTasks();
    }
    @GetMapping("/{id}")
    public WorkPlanTasksBean getTaskById(@PathVariable Integer id){

        return workPlanTasksService.getTaskById(id);
    }

    @PostMapping("/taskcreation")
    public WorkPlanTasksBean createTask(@RequestBody WorkPlanTasksBean workPlanTasksBean){

        return workPlanTasksService.createTask(workPlanTasksBean);
    }

    @PutMapping("/{id}")
    public WorkPlanTasksBean updateTask(@PathVariable Integer id, @RequestBody WorkPlanTasksBean workPlanTasksBean){
        return workPlanTasksService.updateTask(id, workPlanTasksBean);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id) {

        workPlanTasksService.deleteTask(id);
    }
}
