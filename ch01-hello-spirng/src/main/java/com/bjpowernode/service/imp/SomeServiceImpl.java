package com.bjpowernode.service.imp;

import com.bjpowernode.service.SomeService;

public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome() {
        System.out.printf("执行impl的doSome");
    }
}
