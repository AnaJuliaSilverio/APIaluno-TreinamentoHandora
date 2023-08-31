package com.handora.APIaluno.controllers;

import com.handora.APIaluno.dtos.AssessmentResponseDTO;
import com.handora.APIaluno.models.Assessment;
import com.handora.APIaluno.models.Student;
import com.handora.APIaluno.repositories.AssessmentRepository;
import com.handora.APIaluno.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students/{idStudent}/assessment")
public class AssessmentControllerRegistration {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AssessmentRepository assessmentRepository;

    @PostMapping
    public ResponseEntity registerAssessment(@PathVariable("idStudent") Long idStudent,
                                             @RequestBody AssessmentResponseDTO assessmentResponseDTO){
        Student student = studentRepository.findById(idStudent).orElseThrow(() -> new EntityNotFoundException("Nenhum Estudante foi encontrado"));
        Assessment assessment = assessmentResponseDTO.toAssessment(student);
        assessmentRepository.save(assessment);
        return ResponseEntity.status(HttpStatus.CREATED).body(assessment);
    }
}
