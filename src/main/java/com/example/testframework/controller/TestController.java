package com.example.testframework.controller;

import com.example.testframework.service.SmsService;
import com.huang.framework.annotation.TRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author -Huang
 * @create 2020-03-15 17:47
 */
@TRestController
public class TestController {
    @Autowired
    private SmsService smsService;

    @GetMapping("/test")
    public String test(){
        System.out.println("test");
        return "testtttt";
    }

    @GetMapping("/code")
    public String getCode(@RequestParam String mobile){
        String send = smsService.send(mobile);
        System.out.println(send);
        return send;
    }

    @GetMapping("/read")
    public String read(@RequestParam String mobile){
        String send = smsService.send(mobile);
        System.out.println(send);
        return "read scopes" + send;
    }

    @GetMapping("/write")
    public String write(@RequestParam String mobile){
        String send = smsService.send(mobile);
        System.out.println(send);
        return "write scopes" + send;
    }
}
