package com.university.management.service.controllers;

import com.university.management.service.entities.Student;
import com.university.management.service.services.StudentService;
import com.university.management.service.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public Map<String, Object> addStudent(@RequestBody Student student){
        Map<String, Object> response = new HashMap<>();

        try {
            Student persistedStudent = studentService.addStudent(student);
            response.put(Util.CONSTANT_STATUS, Util.CONSTANT_SUCCESS);
            response.put(Util.CONSTANT_DATA, persistedStudent);

        }
        catch(Exception ex) {
            response.put(Util.CONSTANT_STATUS, Util.CONSTANT_FAILED);
            response.put(Util.CONSTANT_MESSAGE, ex.getMessage());
        }

        return response;
    }

    @GetMapping("/students")
    public Map<String, Object> getStudents(){
        Map<String, Object> response = new HashMap<>();

        try {
            List<Student> students = studentService.getStudents();
            response.put(Util.CONSTANT_STATUS, Util.CONSTANT_SUCCESS);
            response.put(Util.CONSTANT_DATA, students);

        }
        catch(Exception ex) {
            response.put(Util.CONSTANT_STATUS, Util.CONSTANT_FAILED);
            response.put(Util.CONSTANT_MESSAGE, ex.getMessage());
        }

        return response;
    }

    @GetMapping("/students/{id}")
    public Map<String, Object> getStudentById(@PathVariable("id") Long studentId){
        Map<String, Object> response = new HashMap<>();

        try {
            Student student = studentService.getStudentById(studentId);
            response.put(Util.CONSTANT_STATUS, Util.CONSTANT_SUCCESS);
            response.put(Util.CONSTANT_DATA, student);

        }
        catch(Exception ex) {
            response.put(Util.CONSTANT_STATUS, Util.CONSTANT_FAILED);
            response.put(Util.CONSTANT_MESSAGE, ex.getMessage());
        }

        return response;
    }
}
