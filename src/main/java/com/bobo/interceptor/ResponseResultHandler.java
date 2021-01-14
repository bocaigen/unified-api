package com.bobo.interceptor;

import com.bobo.common.ResponseResult;
import com.bobo.common.Result;
import com.bobo.common.ResultCodeEnum;
import com.bobo.exception.DataException;
import com.bobo.exception.ParamException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2020/12/19.
 */
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object>{


    public static final String RESPONSE_RESULT_ANN = "RESPONSE-RESULT-ANN";

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        //判断请求 是否有包装标记
        ResponseResult attribute = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANN);
        boolean b = false;
        Class<?> parameterType = methodParameter.getParameterType();
        if(attribute != null && !parameterType.equals(Result.class)){
            b = true;
        }
        return b;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        System.out.println(" 进入返回体，重写格式 处理中。。。。。。");

//        if(body instanceof ErrorResult)
        return Result.success(body);
    }



    @ExceptionHandler(ParamException.class) //参数验证异常
    @ResponseBody
    public Result ParamException(ParamException e){
        e.printStackTrace();
        return Result.failure(e.getResultCodeEnum());
    }

    @ExceptionHandler(DataException.class) //查询数据异常
    @ResponseBody
    public Result DataException(DataException e){
        e.printStackTrace();
        return Result.failure(e.getResultCodeEnum());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class) //参数类型不匹配
    @ResponseBody
    public Result MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        e.printStackTrace();
        return Result.failure(ResultCodeEnum.PARAM_TYPE_ERROR);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class) //paramter参数为空
    @ResponseBody
    public Result MissingServletRequestParameterException(MissingServletRequestParameterException e){
        e.printStackTrace();
        return Result.failure(ResultCodeEnum.PARAM_IS_BLANK);
    }

    @ExceptionHandler(NumberFormatException.class) //数字格式化异常
    @ResponseBody
    public Result NumberFormatExceptionHandler(Exception e){
        e.printStackTrace();
        return Result.failure(ResultCodeEnum.PARAM_NUM_FORMAT);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exeptionHandler(Exception e){
        e.printStackTrace();
        return Result.failure(ResultCodeEnum.ERROR);
    }
}
