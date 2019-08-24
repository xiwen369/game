package com.qiqiji.backstage.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${person.lastName}")
    private String name;

    //ioc容器
    @Autowired
    ApplicationContext ioc;

    @RequestMapping("/sayHello")
    public String sayHello() {
        boolean b = ioc.containsBean("helloService");
        System.out.println("b=" + b);
        return "Hello," + name + "容器中是否有helloService=" + b;
    }

}
