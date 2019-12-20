package com.zzr.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //表明这是一个配置类
public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced //使用负载均衡机制(轮流模式)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
