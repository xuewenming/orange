package com.sam.orange.interceptor;

import com.sam.orange.enums.ExceptionEnum;
import com.sam.orange.exception.OrangeException;
import com.sam.orange.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常执行器
 * @author Sam
 * @date 2019/1/5
 * @time 20:31
 */
@ControllerAdvice
public class CommonExceptionHandler {

    /**
     * 拦截OrangeException
     * @param OrangeException
     * @return
     */
    @ExceptionHandler(OrangeException.class)
    public ResponseEntity<ExceptionResult> handlerException(OrangeException e){
        ExceptionEnum exceptionEnum = e.getExceptionEnum();
        return ResponseEntity.status(exceptionEnum.getCode()).body(new ExceptionResult(exceptionEnum));
    }

}
