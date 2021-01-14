package com.bobo.interceptor;

import com.bobo.common.ResponseResult;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2020/12/19.
 * 拦截器
 * 拦截请求，此请求的值是否需要包装
 * 解析@ResponseResult注解
 *
 */
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    public static final String RESPONSE_RESULT_ANN = "RESPONSE-RESULT-ANN";
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //请求的方法
        if(o instanceof HandlerMethod){
            final HandlerMethod handlerMethod = (HandlerMethod) o;
            final Class<?> clazz = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();
            //判断是否在类对象上面加了注解
            if(clazz.isAnnotationPresent(ResponseResult.class)){
                //设置此请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口进行判断
                httpServletRequest.setAttribute(RESPONSE_RESULT_ANN,clazz.getAnnotation(ResponseResult.class));
            }else if(method.isAnnotationPresent(ResponseResult.class)){
                //设置此请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口进行判断
                httpServletRequest.setAttribute(RESPONSE_RESULT_ANN,method.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
