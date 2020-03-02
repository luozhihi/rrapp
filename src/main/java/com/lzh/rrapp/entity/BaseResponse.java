package com.lzh.rrapp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther LuoZhiHui
 * @date 2020/3/2 11:57
 */
@Data
public class BaseResponse<T> implements Serializable {
    private String code;
    private String errorMsg;
    private T data;

    public BaseResponse<T> buildeResult(T data){
        this.data = data;
        this.code = "200";
        this.errorMsg = "ok";
        return this;
    }
}
