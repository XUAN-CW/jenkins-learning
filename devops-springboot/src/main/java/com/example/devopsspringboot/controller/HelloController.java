package com.example.devopsspringboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 电子书信息(Ebook)表控制层
 *
 * @author 禤成伟
 * @since 2022-03-17 09:58:54
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello devops 2!";
    }
}

