package com.bjpowernode;

import static org.junit.Assert.assertTrue;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void t1() {
        String config = "applicationcontext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("容器中对象名称:" + name + "|" + ctx.getBean(name).getClass().getName());

        }
    }

    @Test
    public void t2() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");
        Student student = new Student();
        student.setId(1023);
        student.setName("SpringDao");
        student.setEmail("SpringDao@qq.com");
        student.setAge(2);
        int nums = studentDao.insertStudent(student);
        System.out.println("返回条数：" + nums);
    }


    @Test
    public void t3() {
        String config = "applicationcontext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        Student student = new Student();
        student.setId(1023);
        student.setName("studentService");
        student.setEmail("studentService@qq.com");
        student.setAge(3);
        //spring和mybatis整合在一起使用，事务是自动提交的。无需执行sqlsession.commit();
        int nums = studentService.addStudent(student);
        System.out.println("返回条数：" + nums);
    }

    @Test
    public void t4() {
        String config = "applicationcontext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        List<Student> students = studentService.qureyStudent();
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
