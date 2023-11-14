package com.convergent.workplanmaster.controller;

import com.convergent.workplanmaster.bean.UserMasterBean;
import com.convergent.workplanmaster.service.UserMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserMasterController {
    private final UserMasterService userMasterService;
    @Autowired
    public UserMasterController(UserMasterService userMasterService) {
        this.userMasterService = userMasterService;
    }

    @PostMapping("/createuser")
    public UserMasterBean createUser(@RequestBody UserMasterBean userMasterBean){
        return userMasterService.createUser(userMasterBean);
    }
}
