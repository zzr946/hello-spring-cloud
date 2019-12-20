package com.zzr.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrixDashboard//开启熔断器仪表盘
@EnableFeignClients //开启Feign功能
@EnableDiscoveryClient //注册到服务中心
@SpringBootApplication
public class SpringCloudFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignApplication.class, args);
    }
}
