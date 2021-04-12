package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer strID = Integer.parseInt(request.getParameter("id"));
        String strName = request.getParameter("name");
        String strEmail = request.getParameter("email");
        Integer strAge = Integer.parseInt(request.getParameter("age"));

//        String config = "spring.xml";
//        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
//        System.out.println("容器对象的信息========" + ctx);

        WebApplicationContext ctx = null;
        //获取servletcontext中的容器对象，创建好的容器对象，拿来就用
//        String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
//        Object attr  = getServletContext().getAttribute(key);
//        if (attr!=null){
//            ctx = (WebApplicationContext) attr;
//        }

        //使用框架中的方法，获取容器对象
        ServletContext sc = getServletContext();
        ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
        System.out.println("容器对象的信息========" + ctx);

        StudentService service = (StudentService) ctx.getBean("studentService");
        Student student = new Student();
        student.setId(strID);
        student.setName(strName);
        student.setEmail(strEmail);
        student.setAge(strAge);

        service.addStudent(student);

        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
