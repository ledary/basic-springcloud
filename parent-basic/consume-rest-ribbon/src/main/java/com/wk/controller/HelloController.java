package com.wk.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wk.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wgp on 2018/7/7.
 */

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;



//    @RequestMapping("/hi")
//    public String hello1(@RequestParam String name){
//        return helloService.hiService(name);
//    }

    /*
    这就说明当 service-hi 工程不可用的时候，
    service-ribbon调用 service-hi的API接口时，
    会执行快速失败，直接返回一组字符串，而不是等待响应超时，
    这很好的控制了容器的线程阻塞。
    */
    @HystrixCommand(fallbackMethod = "hiError")
    @RequestMapping("hi")
    public String hello(@RequestParam String name){
        return helloService.hiService(name);
    }


    public String hiError(String name){
        return "hi," + name + ",sorry,error!";
    }
}
