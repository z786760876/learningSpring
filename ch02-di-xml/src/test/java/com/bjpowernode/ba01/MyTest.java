package com.bjpowernode.ba01;

import org.junit.Test;
import com.bjpowernode.ba04.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void t2() {
        String config = "ba04/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.printf(myStudent.toString());
    }
}
