package com.sam.orange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心
 * @author Sam
 * @date 2019/1/2
 * @time 20:48
 */
@EnableEurekaServer
@SpringBootApplication
public class OrangeRegistry {
    public static void main(String[] args) {
        SpringApplication.run(OrangeRegistry.class, args);
    }
}
