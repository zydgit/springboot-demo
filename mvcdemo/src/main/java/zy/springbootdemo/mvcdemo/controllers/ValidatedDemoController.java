package zy.springbootdemo.mvcdemo.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zy.springbootdemo.mvcdemo.domain.WorkinfoForm;

// 校验 ＠Validated


@RestController
public class ValidatedDemoController {

    // 新增和修改对 id的校验是不同的
    @RequestMapping("/validated")
    public void addWorkInfo(@Validated({WorkinfoForm.Add.class}) @RequestBody WorkinfoForm workinfoForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            FieldError error = (FieldError)bindingResult.getAllErrors().get(0);
            System.out.println(error.getObjectName() + "," + error.getField() + "," + error.getDefaultMessage());
            return;
        }
        return;
    }


    // 自定义校验， 自定义注解 用@Validated({WorkinfoForm.Add.class})的话需要给注解加上分组即可
    @RequestMapping("/self_valid")
    public void selfValid(@Validated @RequestBody WorkinfoForm workinfoForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            FieldError error = (FieldError)bindingResult.getAllErrors().get(0);
            System.out.println(error.getObjectName() + "," + error.getField() + "," + error.getDefaultMessage());
            return;
        }
        return;
    }
}
