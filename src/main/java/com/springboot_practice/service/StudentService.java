package com.springboot_practice.service;

import com.springboot_practice.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    Student createStudent(Student student);

    Student updateStudent(Student student);
}
