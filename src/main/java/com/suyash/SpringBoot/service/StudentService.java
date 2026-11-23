package com.suyash.SpringBoot.service;


import com.suyash.SpringBoot.Entity.Student;
import com.suyash.SpringBoot.Repository.StudentRepository;
import com.suyash.SpringBoot.dto.StudentRequestDto;
import com.suyash.SpringBoot.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findById(String email) {
        return studentRepository.findByEmail(email);
    }

    public StudentResponseDto save(StudentRequestDto studentRequestDto) {
        Student student = new Student();

        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setPassword(studentRequestDto.getPassword());
        student.setSubject(studentRequestDto.getSubject());
        student.setUpdatedAt(LocalDateTime.now());
        student.setCreatedAt(LocalDateTime.now());
        Student savedStudent = studentRepository.save(student);

        StudentResponseDto studentResponseDto = new StudentResponseDto();

        studentResponseDto.setId(savedStudent.getId());
        studentResponseDto.setName(savedStudent.getName());
        studentResponseDto.setEmail(savedStudent.getEmail());
        studentResponseDto.setSubject(savedStudent.getSubject());
        return studentResponseDto;


    }
}
