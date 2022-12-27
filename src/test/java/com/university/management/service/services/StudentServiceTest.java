package com.university.management.service.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.university.management.service.entities.Student;
import com.university.management.service.repositories.StudentRepository;
import com.university.management.service.services.implementations.StudentServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @MockBean
    static StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student;

    private List<Student> students;

    @Before
    public void init() {
        student = new Student();
        student.setFirstName("test");
        student.setLastName("test");
        student.setAge(28);
        student.setUsername("testusername");
        student.setPassword("testpassword");

        students = new ArrayList<>();
        students.add(student);

        Mockito.when(studentRepository.saveAndFlush(student)).thenReturn(student);
        Mockito.when(studentRepository.findAll()).thenReturn(students);
        Mockito.when(studentRepository.findById(1l)).thenReturn(Optional.of(student));

    }

    @Test
    public void addStudentTest() {
        Student testStudent = studentService.addStudent(student);
        assertThat(testStudent.getFirstName()).isEqualTo(student.getFirstName());
    }

    @Test
    public void getStudentsTest() {
        List<Student> testStudents = studentService.getStudents();
        assertThat(testStudents).isNotEmpty();
    }

    @Test
    public void getStudentByIdTest() {
        Student testStudent = studentService.getStudentById(1l);
        assertThat(testStudent.getFirstName()).isEqualTo(student.getFirstName());

    }
}

