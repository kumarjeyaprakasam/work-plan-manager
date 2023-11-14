package com.convergent.workplanmaster.service.impl;
import com.convergent.workplanmaster.bean.WorkPlanMasterBean;
import com.convergent.workplanmaster.bean.WorkPlanMilestonesBean;
import com.convergent.workplanmaster.entity.WorkPlanMasterEntity;
import com.convergent.workplanmaster.entity.WorkPlanMilestonesEntity;
import com.convergent.workplanmaster.repository.WorkPlanMasterRepository;
import com.convergent.workplanmaster.repository.WorkPlanMilestonesRepository;
import com.convergent.workplanmaster.service.WorkPlanMilestonesService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class WorkPlanMilestonesServiceImpl implements WorkPlanMilestonesService {
    private final WorkPlanMilestonesRepository workPlanMilestonesRepository;
    private  final WorkPlanMasterRepository workPlanMasterRepository;
    @Autowired
    public WorkPlanMilestonesServiceImpl(WorkPlanMilestonesRepository workPlanMilestonesRepository, WorkPlanMasterRepository workPlanMasterRepository) {
        this.workPlanMilestonesRepository = workPlanMilestonesRepository;
        this.workPlanMasterRepository = workPlanMasterRepository;
    }
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<WorkPlanMilestonesBean> getAllMilestones(){
        List<WorkPlanMilestonesEntity> MilestonesEntities =workPlanMilestonesRepository.findAll();
        return modelMapper.map(MilestonesEntities,new TypeToken<List<WorkPlanMilestonesBean>>() {}.getType());

    }

    @Override
    public WorkPlanMilestonesBean getMilestoneById(Integer id) {
        WorkPlanMilestonesEntity workPlanMilestonesEntity =workPlanMilestonesRepository.findById(id).get();
        return modelMapper.map(workPlanMilestonesEntity,WorkPlanMilestonesBean.class);
    }

    @Override
    public WorkPlanMilestonesBean createMilestone(WorkPlanMilestonesBean workPlanMilestonesBean) {
        final Integer wpMasterId = workPlanMilestonesBean.getWpMasterId();
        final Optional<WorkPlanMasterEntity> optionalWorkPlanMaster = workPlanMasterRepository.findById(wpMasterId);
        if(optionalWorkPlanMaster.isPresent()){
            final WorkPlanMasterEntity workPlanMasterEntity  = optionalWorkPlanMaster.get();
            final WorkPlanMilestonesEntity workPlanMilestonesEntity=modelMapper.map(workPlanMilestonesBean,WorkPlanMilestonesEntity.class);
            workPlanMilestonesEntity.setMasterEntity(workPlanMasterEntity);
            final WorkPlanMilestonesEntity savedMilestoneEntity =  workPlanMilestonesRepository.save(workPlanMilestonesEntity);
//            workPlanMilestonesBean.setId(savedMilestoneEntity.getId());
            final WorkPlanMilestonesBean savedMilestoneBean = modelMapper.map(savedMilestoneEntity,WorkPlanMilestonesBean.class);
            return workPlanMilestonesBean;
        }
        return null;
    }


    @Override
    public WorkPlanMilestonesBean updateMilestone(Integer id, WorkPlanMilestonesBean workPlanMilestonesBean) {
        WorkPlanMilestonesEntity workPlanMilestonesEntity=workPlanMilestonesRepository.findById(workPlanMilestonesBean.getId()).get();
        WorkPlanMilestonesEntity workPlanMilestonesEntity1=modelMapper.map(workPlanMilestonesBean,WorkPlanMilestonesEntity.class) ;
        workPlanMilestonesRepository.save(workPlanMilestonesEntity1);
        return modelMapper.map(workPlanMilestonesEntity1,WorkPlanMilestonesBean.class);
    }

    @Override
    public void deleteMilestone(Integer id) {
        workPlanMilestonesRepository.deleteById(id);

    }
}
