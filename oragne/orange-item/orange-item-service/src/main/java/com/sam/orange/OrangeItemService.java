package com.sam.orange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 商品微服务
 * @author Sam
 * @date 2019/1/2
 * @time 22:58
 */
@EnableEurekaClient
@SpringBootApplication
public class OrangeItemService {
    public static void main(String[] args) {
        SpringApplication.run(OrangeItemService.class, args);
    }
}
