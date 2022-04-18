package com.dailycodebuffer.spring.data.jpa.service;

import com.dailycodebuffer.spring.data.jpa.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.entity.Student;
import com.dailycodebuffer.spring.data.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent() {
        Guardian guardian = Guardian.builder()
            .email("chandru@gmail.com")
            .name("chandru")
            .mobile("1234567898")
            .build();
        Student student = Student.builder()
            .firstname("Abhi")
            .lastname("Kanchan")
            .emailId("abhikanchanc@gmail.com")
            .guardian(guardian)
            .build();
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByFirstnameContaining(name);
    }
}
