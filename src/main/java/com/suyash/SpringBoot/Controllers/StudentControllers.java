package com.suyash.SpringBoot.Controllers;


import com.suyash.SpringBoot.dto.StudentRequestDto;
import com.suyash.SpringBoot.dto.StudentResponseDto;
import com.suyash.SpringBoot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentControllers {

    private final StudentService studentService;
    public StudentControllers(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createdStudent(@Valid @RequestBody StudentRequestDto  studentRequestDto) {

        StudentResponseDto studentResponseDto = studentService.save(studentRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentResponseDto);
    }

}
