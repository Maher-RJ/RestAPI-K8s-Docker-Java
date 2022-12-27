package com.university.management.service.services;

import java.util.List;

import com.university.management.service.entities.Student;

public interface StudentService {
    public Student addStudent(Student studentDto);

    public List<Student> getStudents();

    public Student getStudentById(Long id);
}
