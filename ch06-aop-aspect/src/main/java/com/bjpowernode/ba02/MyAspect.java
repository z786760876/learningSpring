package com.bjpowernode.ba02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

    @AfterReturning(value = "execution( String com.bjpowernode.ba02.SomeServiceImpl.doOther(..))", returning = "res")
    public void myAfterReturning(Object res) {
        System.out.println("后置通知，切面功能:在目标方法之后,返回值:" + res);
        if ("123".equals(res)) {
            res = "abcd";
        } else {
            res = "666";
        }
    }
}
