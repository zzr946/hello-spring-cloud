package com.zzr.feign.service.hystrix;
/**
 * 熔断器类
 *   当阻塞时执行这个类中的熔断方法，直接返回
 */

import com.zzr.feign.service.AdminService;
import org.springframework.stereotype.Component;

@Component //交由容器管理
public class AdminServiceHystrix implements AdminService {
    //重写Service接口中的方法,当阻塞是执行此类中的方法
    @Override
    public String sayHi(String msg) {
        //直接返回消息，就不会导致一直阻塞
        return String.format("前端的消息为:%s, 但是请求失败了！！",msg);
    }
}
