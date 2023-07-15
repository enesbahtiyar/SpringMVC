package com.eb.repository;

import com.eb.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository
{
    void save(Student student);

    List<Student> findAll();

    //Student findById(Long id);

    Optional<Student> findById(Long id);

    void delete(Long id);
}
