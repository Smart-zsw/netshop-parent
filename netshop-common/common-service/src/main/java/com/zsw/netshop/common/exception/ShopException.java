package com.zsw.netshop.common.exception;


import com.zsw.netshop.model.vo.common.ResultCodeEnum;
import lombok.Data;

@Data
public class ShopException extends RuntimeException{

    private Integer code;
    private String message;
    private ResultCodeEnum resultCodeEnum;

    public ShopException(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }
}
