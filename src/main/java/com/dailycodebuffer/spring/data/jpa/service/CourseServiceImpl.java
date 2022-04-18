package com.dailycodebuffer.spring.data.jpa.service;

import com.dailycodebuffer.spring.data.jpa.entity.Course;
import com.dailycodebuffer.spring.data.jpa.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void findAllPagination() {
        Pageable firstPageableRequest = PageRequest.of(0,3);
        Pageable secondPageableRequest = PageRequest.of(1,2);
        List<Course> courses = courseRepository.findAll(firstPageableRequest).getContent();
        System.out.println(courses);

        Long totalElements = courseRepository.findAll(firstPageableRequest).getTotalElements();
        System.out.println(totalElements);

        long totalPages = courseRepository.findAll(firstPageableRequest).getTotalPages();
        System.out.println(totalPages);
    }

    public void findAllSorting (){
        Pageable sortByTitle = PageRequest.of(0,3, Sort.by("title"));
        Pageable sortByCredit = PageRequest.of(0,3, Sort.by("credit").ascending());

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println(courses);
    }

    public void findByTitleContaining() {
        Pageable pageable = PageRequest.of(0,10,Sort.by("title"));
        List<Course> courses = courseRepository.findByTitleContaining("D",pageable).getContent();
        System.out.println(courses);
    }
}
