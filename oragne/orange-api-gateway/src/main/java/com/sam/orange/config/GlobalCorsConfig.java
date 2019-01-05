package com.sam.orange.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 使用Cors解决跨域
 * @author Sam
 * @date 2019/1/5
 * @time 21:30
 */
@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        // 1.添加Cors配置信息信息
        CorsConfiguration configuration = new CorsConfiguration();
        // 1）添加允许的域名，不要写"*"，否则cookie无法使用
        configuration.addAllowedOrigin("http://manage.orange.com");
        configuration.addAllowedOrigin("http://api.orange.com");
        // 2）是否发送cookie信息
        configuration.setAllowCredentials(true);
        // 3) 允许的请求方式
        configuration.addAllowedMethod("OPTIONS");
        configuration.addAllowedMethod("HEAD");
        configuration.addAllowedMethod("GET");
        configuration.addAllowedMethod("PUT");
        configuration.addAllowedMethod("POST");
        configuration.addAllowedMethod("DELETE");
        configuration.addAllowedMethod("PATCH");
        // 4) 允许的头信息
        configuration.addAllowedHeader("*");
        // 5) 有效时长
        configuration.setMaxAge(3600L);


        // 2.添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);

        // 3.返回新的CorsFilter
        return new CorsFilter(source);
    }

}
