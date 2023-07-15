package com.eb.service;

import com.eb.domain.Student;

import java.util.List;

public interface StudentService
{
    void saveStudent(Student student);

    List<Student> findAll();

    Student findById(Long id);

    void delete(Long id);
}
