package com.springboot_practice.controller;

import com.springboot_practice.model.Student;
import com.springboot_practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student created = studentService.createStudent(student);
        return ResponseEntity.ok(created);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updated = studentService.updateStudent(student);
        return ResponseEntity.ok(updated);
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> getAllStudent() {
        List<Student> studentList = studentService.getAllStudent();
        return ResponseEntity.ok(studentList);
    }
}
