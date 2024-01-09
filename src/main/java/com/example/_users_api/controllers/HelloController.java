package com.example._users_api.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getHello(){
        return "Hello Vigor";
    }

}
