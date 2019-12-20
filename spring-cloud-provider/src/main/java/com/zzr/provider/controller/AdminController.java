package com.zzr.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Value("${server.port}")//将配置文件中配配置的端口号读进来
    private String port;//8762

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "msg") String msg) {
        //格式化字符串返回
        return String.format("地址栏信息为: %s ,端口号为 : %s", msg, port);
    }
}
