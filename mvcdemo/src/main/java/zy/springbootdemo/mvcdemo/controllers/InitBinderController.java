package zy.springbootdemo.mvcdemo.controllers;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class InitBinderController {



    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }


    @RequestMapping("/printdate")
    @ResponseBody
    public void printDate(Date d) {
        System.out.println(d.toString());
        return;
    }



}
