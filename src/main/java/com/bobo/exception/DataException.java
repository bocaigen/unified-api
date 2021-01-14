package com.bobo.exception;

import com.bobo.common.ResultCodeEnum;

/**
 * Created by Administrator on 2020/12/22.
 * 自定义异常之 数据问题
 */
public class DataException extends RuntimeException{

    private ResultCodeEnum resultCodeEnum;
    public DataException(ResultCodeEnum resultCodeEnum){
        this.resultCodeEnum = resultCodeEnum;
    }

    public ResultCodeEnum getResultCodeEnum() {
        return resultCodeEnum;
    }

    public void setResultCodeEnum(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
    }
}
