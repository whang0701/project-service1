package com.wanghang.projectservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.wanghang.*")
@ComponentScan("com.wanghang.*")
public class ProjectService1Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectService1Application.class, args);
    }

}
