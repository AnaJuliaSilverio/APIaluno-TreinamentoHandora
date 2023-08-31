package com.handora.APIaluno.controllers;

import com.handora.APIaluno.dtos.StudentResponseDTO;
import com.handora.APIaluno.models.Student;
import com.handora.APIaluno.repositories.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentControllerRegistration {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity registerStudent(@RequestBody @Valid StudentResponseDTO studentResponseDTO){
        Student student = studentResponseDTO.toStudent();
        studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}