package com.zzr.adminserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer //开启Admin功能
@SpringBootApplication
public class SpringCloudAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAdminServerApplication.class, args);
    }

}
