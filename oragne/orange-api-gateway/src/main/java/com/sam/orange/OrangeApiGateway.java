package com.sam.orange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 服务网关
 * @author Sam
 * @date 2019/1/2
 * @time 23:34
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class OrangeApiGateway {
    public static void main(String[] args) {
        SpringApplication.run(OrangeApiGateway.class, args);
    }
}
