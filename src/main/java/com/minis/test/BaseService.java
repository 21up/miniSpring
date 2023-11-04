package com.minis.test;

import com.minis.core.fourth_class.AutoWired;

public class BaseService {
    @AutoWired
    private BaseBaseService bbs;

    public BaseBaseService getBbs() {
        return bbs;
    }
    public void setBbs(BaseBaseService bbs) {
        this.bbs = bbs;
    }
    public BaseService() {
    }
    public void sayHello() {
        System.out.print("Base Service says hello");
        bbs.sayHello();
    }
}
