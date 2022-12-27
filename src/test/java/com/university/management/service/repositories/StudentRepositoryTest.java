package com.university.management.service.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import com.university.management.service.entities.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest{

    @Autowired
    private StudentRepository studentRepository;

    private Student student;

    @Before
    public void init() {
        student = new Student();
        student.setFirstName("test");
        student.setLastName("test");
        student.setAge(28);
        student.setUsername("testusername");
        student.setPassword("testpassword");
    }


    @Test
    public void addStudentTest() {
        Student testStudent = studentRepository.saveAndFlush(student);
        assertThat(testStudent.getFirstName()).isEqualTo(student.getFirstName());
    }

    @Test
    public void getStudentsTest() {
        studentRepository.saveAndFlush(student);
        List<Student> testStudents = studentRepository.findAll();
        assertThat(testStudents).isNotEmpty();
    }

    @Test
    public void getStudentByIdTest() {
        studentRepository.saveAndFlush(student);
        Student testStudent = studentRepository.getById(2l);
        assertThat(testStudent.getFirstName()).isEqualTo(student.getFirstName());
    }
}
