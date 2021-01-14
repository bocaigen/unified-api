package com.bobo.common;


/**
 * Created by Administrator on 2020/12/18.
 * 枚举中定义状态码
 */
public enum ResultCodeEnum {

    //成功
    SUCCESS(0,"成功"),
    ERROR(-1,"系统错误"),

    //1001-1999 参数错误
    PARAM_IS_INVALID(1001,"参数无效"),
    PARAM_IS_BLANK(1002,"参数为空"),
    PARAM_TYPE_ERROR(1003,"参数类型不匹配"),
    PARAM_NUM_FORMAT(1004,"数字格式化异常"),

    //2001-2999 用户错误
    USER_NOT_LOGIN(2001,"用户未登录"),
    USER_LOGIN_ERROR(2002,"用户名或密码错误");

    private Integer code;
    private String message;

    ResultCodeEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer code(){
        return this.code;
    }

    public String message(){
        return this.message;
    }

}
