package com.zyy.mowa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring4all.swagger.EnableSwagger2Doc;

/**
 * @author USER
 * @date 2020/05/25
 */
@EnableSwagger2Doc
@SpringBootApplication
@MapperScan(basePackages = {"com.zyy.mowa.mapper"})
public class MOWAApplication {
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(MOWAApplication.class, args);
    }

}
