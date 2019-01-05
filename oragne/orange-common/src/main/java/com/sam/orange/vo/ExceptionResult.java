package com.sam.orange.vo;

import com.sam.orange.enums.ExceptionEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 返回异常处理对象
 * @author Sam
 * @date 2019/1/5
 * @time 20:54
 */
@Getter
@Setter
public class ExceptionResult {

    private Integer code;
    private String message;
    private long timestamp;

    public ExceptionResult(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
