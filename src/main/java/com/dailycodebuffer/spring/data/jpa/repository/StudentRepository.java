package com.dailycodebuffer.spring.data.jpa.repository;

import com.dailycodebuffer.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstnameContaining(String name);

    @Query("select s from Student s where s.emailId = ?1")
    Student findStudentByEmailIdUsingHQL(String email);

    @Query(value = "select s from Student s where s.emailId = :emailId",nativeQuery = true)
    Student findStudentByEmailIdUsingNativeQuery(@Param("emailId") String emailId);
}
