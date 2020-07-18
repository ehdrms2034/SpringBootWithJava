package com.donggeun.springSecurity.controller;

import com.donggeun.springSecurity.model.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/login")
    String testLogin(){
        return "Hello World";
    }

    @GetMapping("/user")
    String user() {return "you are a user"; }

    @GetMapping("/admin")
    String admin() {return "you are a admin";}
}