package com.sam.orange.service.impl;

import com.sam.orange.config.UploadProperties;
import com.sam.orange.enums.ExceptionEnum;
import com.sam.orange.exception.OrangeException;
import com.sam.orange.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

/**
 * @author Sam
 * @date 2019/1/7
 * @time 22:01
 */
@EnableConfigurationProperties(value = UploadProperties.class)
@Slf4j
@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private UploadProperties uploadProperties;


    @Override
    public String uploadFile(MultipartFile file) {
        try {
        // 1.校验文件格式
        List<String> allowsType = uploadProperties.getAllowTypes();
        String contentType = file.getContentType();
        if( !allowsType.contains(contentType) ) {
            log.error("上传失败，文件类型不匹配{}",contentType);
            throw new OrangeException(ExceptionEnum.UPLOAD_FILE_TYPE_ERROR);
        }

        // 2.校验文件内容
        BufferedImage read = ImageIO.read(file.getInputStream());
        if ( null == read ) {
            log.error("上传文件为非法文件");
            throw new OrangeException(ExceptionEnum.UPLOAD_FILE_IS_NULL);
        }

        // 3.上传到fdfs文件
       /* String url = uploadProperties.getDefaultUrl();
        String suffix = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
        StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), suffix, null);
        return url + storePath.getFullPath();*/

       File dir = new File("D:\\d");
       if( !dir.exists() ) {
           dir.mkdirs();
       }
       file.transferTo(new File(dir,file.getOriginalFilename()));

       return dir.getPath();

        } catch (Exception e) {
            log.error("文件上传失败",e);
            throw new OrangeException(ExceptionEnum.UPLOAD_FILE_ERROR);
        }
    }
}
