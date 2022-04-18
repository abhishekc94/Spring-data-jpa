package com.dailycodebuffer.spring.data.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_student",
    uniqueConstraints = @UniqueConstraint(
        name = "emailid_unique",
        columnNames = "email_address"
    ))
public class Student {

    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        initialValue = 10,
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "student_sequence")
    private Long studentId;
    private String firstname;
    private String lastname;

    @Column(name = "email_address",
            nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;

}


