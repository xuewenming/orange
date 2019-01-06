package com.sam.orange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 文件上传微服务
 * @author Sam
 * @date 2019/1/7
 * @time 0:19
 */
@EnableEurekaClient
@SpringBootApplication
public class OrangeUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrangeUploadApplication.class, args);
    }
}
