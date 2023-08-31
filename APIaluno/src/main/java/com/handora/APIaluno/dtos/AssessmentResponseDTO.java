package com.handora.APIaluno.dtos;


import com.handora.APIaluno.models.Assessment;
import com.handora.APIaluno.models.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentResponseDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String text;

    public Assessment toAssessment(Student student){
        return new Assessment(title,text,student);
    }
}
