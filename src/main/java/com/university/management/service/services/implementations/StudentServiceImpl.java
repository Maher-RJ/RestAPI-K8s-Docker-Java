package com.university.management.service.services.implementations;

import java.util.List;

import com.university.management.service.entities.Student;
import com.university.management.service.repositories.StudentRepository;
import com.university.management.service.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    // Student entity will be returning, throwing exception if student is not found
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }


}

