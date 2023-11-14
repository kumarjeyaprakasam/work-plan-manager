package com.convergent.workplanmaster.service.impl;

import com.convergent.workplanmaster.bean.WorkPlanMasterBean;
import com.convergent.workplanmaster.bean.WorkPlanMilestonesBean;
import com.convergent.workplanmaster.bean.WorkPlanTasksBean;
import com.convergent.workplanmaster.entity.WorkPlanMasterEntity;
import com.convergent.workplanmaster.entity.WorkPlanMilestonesEntity;
import com.convergent.workplanmaster.entity.WorkPlanTasksEntity;
import com.convergent.workplanmaster.repository.WorkPlanMasterRepository;
import com.convergent.workplanmaster.service.WorkPlanMasterService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkPlanMasterServiceImpl implements WorkPlanMasterService {
    private final Logger logger = LoggerFactory.getLogger(WorkPlanMasterServiceImpl.class);
    private WorkPlanMasterRepository workPlanMasterRepository;
    private ModelMapper modelMapper;

    @Autowired
    public WorkPlanMasterServiceImpl(WorkPlanMasterRepository workPlanMasterRepository, ModelMapper modelMapper) {
        this.workPlanMasterRepository = workPlanMasterRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<WorkPlanMasterBean> getAllPlans() {
        List<WorkPlanMasterEntity> planMasterEntities = workPlanMasterRepository.findAll();
        return modelMapper.map(planMasterEntities, new TypeToken<List<WorkPlanMasterBean>>() {
        }.getType());
    }

    @Override
    public WorkPlanMasterBean getPlanById(Integer id) {
        WorkPlanMasterEntity workPlanMasterEntity = workPlanMasterRepository.findById(id).get();
        return modelMapper.map(workPlanMasterEntity, WorkPlanMasterBean.class);
    }

    @Override
    public WorkPlanMasterBean createPlan(WorkPlanMasterBean workPlanMasterBean) {
        logger.info("Entering Create Plan Service {}", workPlanMasterBean);
        final WorkPlanMasterEntity workPlanMasterEntity = modelMapper.map(workPlanMasterBean, WorkPlanMasterEntity.class);
        workPlanMasterEntity.setListOfWorkPlanMilestones(workPlanMasterBean.getWorkPlanMilestonesBeans()
                .stream()
                .map(workPlanMilestonesBean -> {
                    WorkPlanMilestonesEntity workPlanMilestonesEntity = modelMapper.map(workPlanMilestonesBean, WorkPlanMilestonesEntity.class);
                    workPlanMilestonesEntity.setListOfWorkPlanTasks(workPlanMilestonesBean.getTasksBeans().stream()
                            .map(workPlanTasksBean -> {
                                return modelMapper.map(workPlanTasksBean, WorkPlanTasksEntity.class);
                            }).collect(Collectors.toList()));
                    return workPlanMilestonesEntity;
                })
                .collect(Collectors.toList()));
        final WorkPlanMasterEntity savedPlanEntity = workPlanMasterRepository.save(workPlanMasterEntity);
        final WorkPlanMasterBean savedPlanBean = modelMapper.map(savedPlanEntity, WorkPlanMasterBean.class);
        savedPlanBean.setWorkPlanMilestonesBeans(savedPlanEntity
                .getListOfWorkPlanMilestones()
                .stream()
                .map(workPlanMilestonesEntity -> {
                    final WorkPlanMilestonesBean workPlanMilestonesBean = modelMapper.map(workPlanMilestonesEntity, WorkPlanMilestonesBean.class);
                    workPlanMilestonesBean.setTasksBeans(workPlanMilestonesEntity
                            .getListOfWorkPlanTasks()
                            .stream()
                            .map(workPlanTasksEntity -> {
                                final WorkPlanTasksBean workPlanTasksBean = modelMapper.map(workPlanTasksEntity, WorkPlanTasksBean.class);
                                return workPlanTasksBean;
                            }).collect(Collectors.toList()));
                    return workPlanMilestonesBean;
                }).collect(Collectors.toList()));
        logger.info("Exiting Create plan service {}", savedPlanBean);
        return savedPlanBean;
    }

    @Override
    public WorkPlanMasterBean updatePlan(Integer id, WorkPlanMasterBean workPlanMasterBean) {
        WorkPlanMasterEntity workPlanMasterEntity = workPlanMasterRepository.findById(workPlanMasterBean.getId()).get();
        WorkPlanMasterEntity workPlanMasterEntity1 = modelMapper.map(workPlanMasterBean, WorkPlanMasterEntity.class);
        workPlanMasterRepository.save(workPlanMasterEntity1);
        return modelMapper.map(workPlanMasterEntity1, WorkPlanMasterBean.class);

    }

    @Override
    public void deletePlan(Integer id) {
        workPlanMasterRepository.deleteById(id);

    }
    /*private boolean isWorkPlanNameUnique(String planName) {
        // Check if the work plan name already exists in the repository
        return !workPlanMasterRepository.existsByName(planName);
    }*/
}
