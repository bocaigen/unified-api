package com.bobo.common;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/12/19.
 * 返回的数据体
 * 实现序列化接口
 */
public class Result implements Serializable{
    private Integer code;
    private String message;
    private Object data;
    public Result(ResultCodeEnum resultCodeEnum,Object data){
        this.code = resultCodeEnum.code();
        this.message = resultCodeEnum.message();
        this.data = data;
    }
    public Result(ResultCodeEnum resultCodeEnum){
        this.code = resultCodeEnum.code();
        this.message = resultCodeEnum.message();
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    //返回成功
    public static Result success(){
        return new Result(ResultCodeEnum.SUCCESS);
    }

    //返回成功
    public static Result success(Object data){
        return new Result(ResultCodeEnum.SUCCESS,data);
    }

    //返回失败
    public static Result failure(ResultCodeEnum resultCodeEnum){
        return new Result(resultCodeEnum);
    }

    //返回失败
    public static Result failure(ResultCodeEnum resultCodeEnum,Object data){
        return new Result(resultCodeEnum,data);
    }
}
