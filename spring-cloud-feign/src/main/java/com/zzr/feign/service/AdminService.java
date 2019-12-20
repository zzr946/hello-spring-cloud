package com.zzr.feign.service;

import com.zzr.feign.service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(value = "spring-cloud-provider")//value=服务提供者的名字

//增加熔断器后的写法  fallback=熔断器类.class  本service类的实现类
@FeignClient(value = "spring-cloud-provider",fallback = AdminServiceHystrix.class)
public interface AdminService {

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    //如果前端页有参数传过来,此处必须加上RequestParam注解用于获取参数
    public String sayHi(@RequestParam(value = "msg") String msg);
}
