package com.bobo.controller;

import com.bobo.common.ResponseResult;
import com.bobo.common.ResultCodeEnum;
import com.bobo.exception.DataException;
import com.bobo.exception.ParamException;
import com.bobo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/31.
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/say/{id}")
    @ResponseResult
    //使用封装返回体注解，方法返回值类型不能是String类型，否则会报错。
    // 原因是Controller会把String认为成一个html地址
    public String say(@PathVariable("id") Integer aid,
                      @RequestParam(value = "myId",required = false,defaultValue = "0") String Id){

        return "id : "+aid + "==myId : "+Id;
    }

    @GetMapping(value = "/say/param")
    @ResponseResult
    //使用封装返回体注解，方法返回值类型不能是String类型，否则会报错。
    // 原因是Controller会把String认为成一个html地址
    public Map myParam(@RequestParam(value = "param1") String param1,
                        @RequestParam(value = "param2",required = false,defaultValue = "0") String param2) throws Exception{
        Map<String,String> map = new HashMap();
        map.put("param1",param1);
        map.put("param2",param2);
        if(param1.equals("001")){
            throw new ParamException(ResultCodeEnum.USER_LOGIN_ERROR);
        }
        if(param1.equals("002")){
            throw new DataException(ResultCodeEnum.USER_NOT_LOGIN);
        }
        if(param1.equals("003")){

            String a = "aa";
            Integer integer = Integer.valueOf(a);
        }
        return map;
    }
}
