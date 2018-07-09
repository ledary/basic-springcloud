package com.wk.service;

import org.springframework.stereotype.Component;

/**
 * Created by wgp on 2018/7/7.
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
