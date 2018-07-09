package com.wk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wgp on 2018/7/7.
 */

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name){
        String url = "http://SERVICE-HI/hi?name="+name;
        return restTemplate.getForObject(url,String.class);
    }
}
