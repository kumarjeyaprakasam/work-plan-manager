package com.convergent.workplanmaster.controller;

import com.convergent.workplanmaster.bean.WorkPlanMasterBean;
import com.convergent.workplanmaster.service.WorkPlanMasterService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("workplan")
public class WorkPlanMasterController {

    Logger logger = LoggerFactory.getLogger(WorkPlanMasterController.class);

    private final WorkPlanMasterService workPlanMasterService;

    @Autowired
    public WorkPlanMasterController(WorkPlanMasterService workPlanMasterService) {
        this.workPlanMasterService = workPlanMasterService;
    }

    @GetMapping
    public List<WorkPlanMasterBean> getAllPlans() {

        return workPlanMasterService.getAllPlans();
    }

    @GetMapping("/{id}")
    public WorkPlanMasterBean getPlanById(@PathVariable Integer id) {

        return workPlanMasterService.getPlanById(id);
    }

    @PostMapping()
    public ResponseEntity<WorkPlanMasterBean> createPlan(@Valid @RequestBody WorkPlanMasterBean workPlanMasterBean) {
        logger.info("Entering create Plan {}", workPlanMasterBean);
        WorkPlanMasterBean savedBean = workPlanMasterService.createPlan(workPlanMasterBean);
        if (workPlanMasterService.createPlan(workPlanMasterBean) != null) {
            logger.info("Successfully saved the work plan");
            return ResponseEntity.ok(savedBean);
        } else {
            logger.error("Error Saving the work plan");
            return ResponseEntity.badRequest().body(workPlanMasterBean);
        }
    }

    @PutMapping("/{id}")
    public WorkPlanMasterBean updatePlan(@PathVariable Integer id, @RequestBody WorkPlanMasterBean workPlanMasterBean) {
        return workPlanMasterService.updatePlan(id, workPlanMasterBean);
    }

    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable Integer id) {
        workPlanMasterService.deletePlan(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<String>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            errors.add(errorMessage);
        });
        return errors;
    }
}
