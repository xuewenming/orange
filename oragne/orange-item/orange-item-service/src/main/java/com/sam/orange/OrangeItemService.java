package com.sam.orange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 商品类
 * @author Sam
 * @date 2019/1/2
 * @time 21:26
 */
@SpringBootApplication
@EnableEurekaClient
public class OrangeItemService {
    public static void main(String[] args) {
        SpringApplication.run(OrangeItemService.class, args);
    }
}
