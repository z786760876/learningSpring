package com.bjpowernode;

import com.bjpowernode.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void t1() {
        String config = "applicationcontext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        BuyGoodsService buyGoodsService = (BuyGoodsService) ctx.getBean("buyService");

        System.out.println("service是代理: " + buyGoodsService.getClass().getName());

        buyGoodsService.buy(10010, 1000);
    }
}
