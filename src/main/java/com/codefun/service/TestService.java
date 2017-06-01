package com.codefun.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Administrator on 2017/3/8.
 */
@Component("testService")
public class TestService {

    public TestService(){
        System.out.println("TestService构造调用");
    }


    @PostConstruct
    private void myInit(){
        System.out.println("TestService PostConstruct调用");
    }

    @PreDestroy
    private void mydestroy(){
        System.out.println("TestService PreDestroy调用");
    }

    public String todo(){
        return  "dosomething";

    }

}
