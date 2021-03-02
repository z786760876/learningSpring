package com.bjpowernode.ba01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

@Aspect
public class MyAspect {
    @Before(value = "execution( void *..doSome(..))")
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("方法的签名(定义)=" + joinPoint.getSignature());
        System.out.println("方法的名称=" + joinPoint.getSignature().getName());

        Object[] objects = joinPoint.getArgs();
        for (Object object : objects) {
            System.out.println("参数=" + object);
        }

        System.out.println("前置通知，切面功能:在目标方法之前输出执行时间:" + new Date());
    }
}
