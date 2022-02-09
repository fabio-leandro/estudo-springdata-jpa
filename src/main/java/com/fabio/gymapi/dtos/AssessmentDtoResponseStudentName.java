package com.fabio.gymapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentDtoResponseStudentName {


    private Long id;

    private StudentDtoAssessment student;

    private LocalDate dateAssessment;

    private double weight;

    private double height;


}
