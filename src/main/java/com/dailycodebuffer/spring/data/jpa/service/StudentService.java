package com.dailycodebuffer.spring.data.jpa.service;

import com.dailycodebuffer.spring.data.jpa.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student saveStudent();

    List<Student> getStudentsByName(String firstname);
}
