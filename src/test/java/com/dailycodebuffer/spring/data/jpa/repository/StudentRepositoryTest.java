package com.dailycodebuffer.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.dailycodebuffer.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

   /* @Test
    public void saveStudent() {
        Student student = Student.builder()
            .firstname("Abhi")
            .lastname("Kanchan")
            .emailId("abhikanchanc@gmail.com")
            .guardianName("chandru")
            .guardianMobile("1234567891")
            .guardianEmail("chandru@gmail.com")
            .build();
        studentRepository.save(student);
    }*/

}