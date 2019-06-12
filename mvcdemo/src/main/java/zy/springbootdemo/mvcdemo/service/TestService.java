package zy.springbootdemo.mvcdemo.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {


    public void throwNullError() {
        String a = null;
        String b = a.toString(); // 空指针异常
    }
}
