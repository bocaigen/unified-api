package com.bobo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/3/31.
 */

@Component
@ConfigurationProperties(prefix = "girl")//获取配置文件里面前缀是girl的配置
public class GirlProperties {

    private String name;
    private String cupSize;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "GirlProperties{" +
                "name='" + name + '\'' +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
