package com.bobo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/4/5.
 */

@Aspect
@Component
public class HttpAspect {

    private final static Logger log = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.bobo.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        log.info("面向切面在处理逻辑之前执行===================");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        log.info("url={}",request.getRequestURL());
        //method
        log.info("method={}",request.getMethod());
        //ip
        log.info("ip={}",request.getRemoteAddr());
        //类方法
        log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        log.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        log.info("处理逻辑之后执行=================");
    }

    @AfterReturning(pointcut = "log()", returning = "object")
    public void doAfterReturning(Object object){
        log.info("response={}",object);

    }
}
