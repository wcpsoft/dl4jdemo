package com.rxaisoft.dl4jdemo;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.List;

@SpringBootApplication
public class Dl4jDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dl4jDemoApplication.class, args);
    }

}
