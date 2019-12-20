package com.zzr.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix //开启熔断器
@EnableDiscoveryClient //注册到服务中心
@SpringBootApplication
public class SpringCloudRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonApplication.class, args);
    }

}
