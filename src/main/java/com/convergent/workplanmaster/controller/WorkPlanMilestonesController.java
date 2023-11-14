package com.convergent.workplanmaster.controller;

import com.convergent.workplanmaster.bean.WorkPlanMilestonesBean;
import com.convergent.workplanmaster.service.WorkPlanMilestonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/workplanmilestone")
public class WorkPlanMilestonesController {
    private  final WorkPlanMilestonesService workPlanMilestonesService;
   @Autowired
    public WorkPlanMilestonesController(WorkPlanMilestonesService workPlanMilestonesService) {
        this.workPlanMilestonesService = workPlanMilestonesService;
    }
    @GetMapping("/allmilestone")
    public List<WorkPlanMilestonesBean> getAllMilestones(){

       return workPlanMilestonesService.getAllMilestones();
    }
    @GetMapping("/{id}")
    public WorkPlanMilestonesBean getMilestoneById(@PathVariable Integer id){

        return workPlanMilestonesService.getMilestoneById(id);
    }

    @PostMapping("/milestonecreation")
    public WorkPlanMilestonesBean createMilestone(@RequestBody WorkPlanMilestonesBean workPlanMilestonesBean){

       return workPlanMilestonesService.createMilestone(workPlanMilestonesBean);
    }

    @PutMapping("/{id}")
    public WorkPlanMilestonesBean updateMilestone(@PathVariable Integer id, @RequestBody WorkPlanMilestonesBean workPlanMilestonesBean){
        return workPlanMilestonesService.updateMilestone(id, workPlanMilestonesBean);
    }

    @DeleteMapping("/{id}")
    public void deleteMilestone(@PathVariable Integer id) {

        workPlanMilestonesService.deleteMilestone(id);
    }


}
