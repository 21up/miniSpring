package com.minis.test;

import com.minis.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        AService aservice = (AService) ctx.getBean("aservice");
        aservice.sayHello();
    }
}
