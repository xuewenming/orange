package com.sam.orange.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Sam
 * @date 2019/1/7
 * @time 22:01
 */
public interface UploadService {
    /**
     * 文件上传
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file);
}
