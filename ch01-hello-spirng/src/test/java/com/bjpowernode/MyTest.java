package com.bjpowernode;

import com.bjpowernode.service.SomeService;
import com.bjpowernode.service.imp.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void t1() {
        SomeService service = new SomeServiceImpl();
        service.doSome();
    }

    @Test
    public void t2() {
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) ac.getBean("someService");
        someService.doSome();
    }
}
