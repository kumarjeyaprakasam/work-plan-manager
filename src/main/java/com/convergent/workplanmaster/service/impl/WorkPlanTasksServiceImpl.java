package com.convergent.workplanmaster.service.impl;

import com.convergent.workplanmaster.bean.WorkPlanTasksBean;
import com.convergent.workplanmaster.entity.WorkPlanMilestonesEntity;
import com.convergent.workplanmaster.entity.WorkPlanTasksEntity;
import com.convergent.workplanmaster.repository.WorkPlanMilestonesRepository;
import com.convergent.workplanmaster.repository.WorkPlanTasksRepository;
import com.convergent.workplanmaster.service.WorkPlanTasksService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkPlanTasksServiceImpl implements WorkPlanTasksService {

    private final WorkPlanTasksRepository workPlanTasksRepository;
    private final WorkPlanMilestonesRepository workPlanMilestonesRepository;
    @Autowired
    public WorkPlanTasksServiceImpl(WorkPlanTasksRepository workPlanTasksRepository, WorkPlanMilestonesRepository workPlanMilestonesRepository) {
        this.workPlanTasksRepository = workPlanTasksRepository;
        this.workPlanMilestonesRepository = workPlanMilestonesRepository;
    }
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<WorkPlanTasksBean> getAllTasks() {
        List<WorkPlanTasksEntity> workPlanTasksEntities=workPlanTasksRepository.findAll();
        return modelMapper.map(workPlanTasksEntities,new TypeToken<List<WorkPlanTasksBean>>() {}.getType());

    }

    @Override
    public WorkPlanTasksBean getTaskById(Integer id) {
        WorkPlanTasksEntity workPlanTasksEntity=workPlanTasksRepository.findById(id).get() ;
        return modelMapper.map(workPlanTasksEntity,WorkPlanTasksBean.class);
    }

    @Override
    public WorkPlanTasksBean createTask(WorkPlanTasksBean workPlanTasksBean) {
        final Integer wpMilestoneId = workPlanTasksBean.getWpMilestoneId();
        final Optional<WorkPlanMilestonesEntity> optionalWorkPlanMilestonesEntity = workPlanMilestonesRepository.findById(wpMilestoneId);
        if(optionalWorkPlanMilestonesEntity.isPresent()){
            final WorkPlanMilestonesEntity workPlanMilestonesEntity =optionalWorkPlanMilestonesEntity.get();
            final WorkPlanTasksEntity workPlanTasksEntity =modelMapper.map(workPlanTasksBean,WorkPlanTasksEntity.class);
            workPlanTasksEntity.setMilestonesEntity(workPlanMilestonesEntity);
            final WorkPlanTasksEntity savedTaskEntity=workPlanTasksRepository.save(workPlanTasksEntity);
            final WorkPlanTasksBean savedTaskBean=modelMapper.map(savedTaskEntity,WorkPlanTasksBean.class);
            return savedTaskBean;
        }
        return null;
    }

    @Override
    public WorkPlanTasksBean updateTask(Integer id, WorkPlanTasksBean workPlanTasksBean) {
        WorkPlanTasksEntity workPlanTasksEntity=workPlanTasksRepository.findById(workPlanTasksBean.getId()) .get();
        WorkPlanTasksEntity workPlanTasksEntity1=modelMapper.map(workPlanTasksBean,WorkPlanTasksEntity.class);
        workPlanTasksRepository.save(workPlanTasksEntity1);
        return modelMapper.map(workPlanTasksEntity1,WorkPlanTasksBean.class);
    }

    @Override
    public void deleteTask(Integer id) {
        workPlanTasksRepository.deleteById(id);

    }
}
