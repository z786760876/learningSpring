package com.bjpowernode;


import com.bjpowernode.ba02.SomeService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T {
    @Test
    public void t1() {
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        SomeService service = (SomeService) context.getBean("someServiceImpl");
        service.doSome("1", 1);
    }

    @Test
    public void t2() {
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        SomeService service = (SomeService) context.getBean("someServiceImpl");

        String result = service.doOther("lisi", 24);
        System.out.println(result);
    }
}