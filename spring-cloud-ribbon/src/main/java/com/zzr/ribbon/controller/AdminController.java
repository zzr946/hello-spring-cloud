package com.zzr.ribbon.controller;

import com.zzr.ribbon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired //将service层注入
    private AdminService adminService;

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String sayHi(String msg){
        //调用service层的方法，向服务提供者获取数据
        return adminService.sayHi(msg);
    }
}
