package com.sam.orange.web;

import com.sam.orange.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * @author Sam
 * @date 2019/1/7
 * @time 21:58
 */
@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    UploadService uploadService;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("image")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String url = uploadService.uploadFile(file);
        return ResponseEntity.ok(url);
    }

}
