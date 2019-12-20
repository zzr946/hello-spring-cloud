package com.zzr.feign.controller;

import com.zzr.feign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired//注入service层
    private AdminService adminService;

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String sayHi(String msg){
        return adminService.sayHi(msg);
    }
}
