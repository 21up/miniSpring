package com.minis.test;


import com.minis.BeansException;
import com.minis.core.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        AService aservice = (AService) ctx.getBean("aservice");
        aservice.sayHello();
    }
}
