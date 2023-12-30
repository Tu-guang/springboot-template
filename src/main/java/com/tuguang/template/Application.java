package com.tuguang.template;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ConfigurationPropertiesScan("com.tuguang.template.config")
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableDubbo
@ServletComponentScan

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
