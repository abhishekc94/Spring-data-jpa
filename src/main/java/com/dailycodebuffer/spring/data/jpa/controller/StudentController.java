package com.dailycodebuffer.spring.data.jpa.controller;

import com.dailycodebuffer.spring.data.jpa.entity.Student;
import com.dailycodebuffer.spring.data.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.saveStudent());
    }

    @GetMapping("/students/{name}")
    public ResponseEntity<List<Student>> getStudentsByName(@PathVariable("name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentsByName(name));
    }
}
