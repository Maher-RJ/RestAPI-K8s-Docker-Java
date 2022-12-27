package com.university.management.service.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.university.management.service.entities.Student;
import com.university.management.service.utils.Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Student student;

    private static final String STUDENT_ENDPOINT = "/students";

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
    public void addStudentTest() throws Exception {
        mockMvc.perform(post(STUDENT_ENDPOINT).
                content(toJson(student)).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(content().
                        contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).
                andExpect(jsonPath("$.STATUS", is(Util.CONSTANT_SUCCESS)));
    }

    @Test
    public void getStudentsTest() throws Exception{
        mockMvc.perform(get(STUDENT_ENDPOINT).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(content().
                        contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).
                andExpect(jsonPath("$.STATUS", is(Util.CONSTANT_SUCCESS)));
    }

    @Test
    public void getStudentByIdTest() throws Exception {
        mockMvc.perform(get(STUDENT_ENDPOINT.concat("/1")).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(content().
                        contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).
                andExpect(jsonPath("$.STATUS", is(Util.CONSTANT_SUCCESS)));
    }

    // TEST HELPER - CONVERTING POJO TO JSON
    private String toJson(final Object object) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
