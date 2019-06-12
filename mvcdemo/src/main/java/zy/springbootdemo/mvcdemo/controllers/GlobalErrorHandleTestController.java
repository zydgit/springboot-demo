package zy.springbootdemo.mvcdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zy.springbootdemo.mvcdemo.service.TestService;

import java.util.Date;
@Controller
public class GlobalErrorHandleTestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/throw_error")
    @ResponseBody
    public void throw_error(Date d) {
         testService.throwNullError();
    }
}
