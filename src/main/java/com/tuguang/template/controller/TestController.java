package com.tuguang.template.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class TestController {
    @GetMapping("/hello")
    public String Hello(){
        System.out.println("hello");
        return "Hello SpringBoot!";
    }
}
