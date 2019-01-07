package com.sam.orange.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * 文件上传读取类
 * @author Sam
 * @date 2019/1/8
 * @time 0:07
 */
@ConfigurationProperties(prefix = "orange.upload")
@Data
public class UploadProperties {
    private String defaultUrl;
    private List<String> allowTypes;
}
