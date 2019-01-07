package com.sam.orange.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 自定义异常枚举方法
 * @author Sam
 * @date 2019/1/5
 * @time 0:00
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum  ExceptionEnum {

    CATEGORY_NOT_FOUND(404,"商品分类没有找到"),
    BRAND_NOT_FOUND(404,"品牌列表没有找到"),
    BRAND_INSERT_ERROR(500,"品牌保存异常"),
    CATEGROYANDBRAND_INSERT_ERROR(500,"品牌和分类保存异常"),
    UPLOAD_FILE_TYPE_ERROR(500,"文件类型不匹配"),
    UPLOAD_FILE_ERROR(500,"文件上传失败"),
    UPLOAD_FILE_IS_NULL(500,"文件不符合要求");

    private Integer code;
    private String msg;

}
