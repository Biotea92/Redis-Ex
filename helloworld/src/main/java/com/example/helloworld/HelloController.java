package com.example.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// /hello -> "hello world!"
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }
}
