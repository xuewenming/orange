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

    CATEGORY_NOT_FOUND(404,"商品分类没有找到");

    private Integer code;
    private String msg;

}
