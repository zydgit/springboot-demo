package zy.springbootdemo.aopdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloAop {

    @GetMapping("/hello")
    public @ResponseBody String hello() {
        return "hello, Spring AOP.";
    }

}
