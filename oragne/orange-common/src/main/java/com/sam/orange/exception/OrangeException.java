package com.sam.orange.exception;

import com.sam.orange.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 自定义异常
 * @author Sam
 * @date 2019/1/4
 * @time 23:59
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrangeException extends RuntimeException {
    private ExceptionEnum exceptionEnum;

}
