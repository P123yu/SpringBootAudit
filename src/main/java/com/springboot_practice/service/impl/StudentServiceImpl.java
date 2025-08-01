package com.springboot_practice.service.impl;

import com.springboot_practice.model.Student;
import com.springboot_practice.repo.StudentRepo;
import com.springboot_practice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

//    @Override
//    public Student updateStudent(Student student) {
//        Student existingStudent = studentRepo.findById(student.getId())
//                .orElseThrow(()-> new NoSuchElementException("student not found"));
//        existingStudent.setName(student.getName());
//        existingStudent.setCity(student.getCity());
//        return studentRepo.save(existingStudent);
//    }



    @Override
    public Student updateStudent(Student student) {
        boolean isStudentExists = studentRepo.existsById(student.getId());
        if(isStudentExists) {
            return studentRepo.save(student);
        }
        else{
            throw new NoSuchElementException("element not found for update");
        }
    }


}
