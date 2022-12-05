package com.api.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestConsumer {
    @Autowired
    RestTemplate rest;
    String apiUrl = "http://localhost:8080/api/";
    Logger log = LoggerFactory.getLogger(RestConsumer.class); // slf4j

    public Student getStudentById(Long id) {
        return rest.getForObject(apiUrl + "/student/{id}/", Student.class, id);
    }

    public void updateStudent(Student student) {
        rest.put(apiUrl + "/student/{id}/", student, student.getId());
    }

    public void deleteStudent(Long id) {
        rest.delete(apiUrl + "/student/{id}/", id);
    }

    public void createStudent(Student student) {
        rest.postForObject(apiUrl + "/student/", student, Student.class);
    }
}