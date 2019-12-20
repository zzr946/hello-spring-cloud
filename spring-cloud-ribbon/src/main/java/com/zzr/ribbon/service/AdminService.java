package com.zzr.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {

    @Autowired //注入配置类RestTemplate
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "error")//熔断器注解   失败后回调error方法
    public String sayHi(String msg){
        //利用RestTemplate向服务提供者获取数据  url:http://服务提供者的名字/请求参数
        return restTemplate.getForObject("http://spring-cloud-provider/hi?msg="+msg,String.class);
    }

    //熔断方法 连不上服务后执行此方法返回，就不会一直阻塞了
    public String error(String msg){
        return String.format("前端的消息为:%s, 但是请求失败了！！",msg);
    }

}
