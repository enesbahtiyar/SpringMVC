package com.eb.service;

import com.eb.domain.Student;
import com.eb.exceptions.ResourceNotFoundException;
import com.eb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService
{
    @Autowired
    private StudentRepository repository;

    @Override
    public void saveStudent(Student student)
    {
        repository.save(student);
    }

    @Override
    public List<Student> findAll()
    {
        return repository.findAll();
    }

    @Override
    public Student findById(Long id)
    {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't find the student with id"));
    }

    @Override
    public void delete(Long id)
    {
        repository.delete(id);
    }
}
