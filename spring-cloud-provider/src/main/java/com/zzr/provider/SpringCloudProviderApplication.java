package com.zzr.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient//表明自己是一个Eureka Client
@SpringBootApplication
public class SpringCloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderApplication.class, args);
    }

}
