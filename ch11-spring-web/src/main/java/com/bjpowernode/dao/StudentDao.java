package com.bjpowernode.dao;


import com.bjpowernode.domain.Student;

import java.util.List;

public interface StudentDao {
    Integer insertStudent(Student student);

    List<Student> selectStudents();
}
