package com.convergent.workplanmaster.service.impl;

import com.convergent.workplanmaster.bean.UserMasterBean;
import com.convergent.workplanmaster.entity.UserMasterEntity;
import com.convergent.workplanmaster.repository.UserMasterRepository;
import com.convergent.workplanmaster.service.UserMasterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMasterServiceImpl implements UserMasterService {
    private UserMasterRepository userMasterRepository;
    @Autowired
    public UserMasterServiceImpl(UserMasterRepository userMasterRepository) {
        this.userMasterRepository = userMasterRepository;
    }
    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserMasterBean createUser(UserMasterBean userMasterBean) {
        final UserMasterEntity userMasterEntity = modelMapper.map(userMasterBean,UserMasterEntity.class) ;
        final UserMasterEntity savedUserEntity = userMasterRepository.save(userMasterEntity);
        final UserMasterBean savedUserBean = modelMapper.map(savedUserEntity,UserMasterBean.class);
        return savedUserBean;
    }
}
