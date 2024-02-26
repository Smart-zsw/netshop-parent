package com.zsw.netshop.common.exception;

import com.zsw.netshop.model.vo.common.Result;
import com.zsw.netshop.model.vo.common.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    //全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.build(null, ResultCodeEnum.SYSTEM_ERROR);
    }

    //自定义异常处理
    @ExceptionHandler(ShopException.class)
    @ResponseBody
    public Result error(ShopException e) {
        return Result.build(null, e.getResultCodeEnum());
    }
}
