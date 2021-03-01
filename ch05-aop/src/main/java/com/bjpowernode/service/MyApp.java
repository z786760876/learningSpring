package com.bjpowernode.service;

import com.bjpowernode.service.imp.SomeServiceImpl;

public class MyApp {
    public static void main(String[] args) {
        SomeService service = new SomeServiceImpl();
        service.doSome();
        System.out.println("\n----------------------");
        service.doOther();
    }
}
