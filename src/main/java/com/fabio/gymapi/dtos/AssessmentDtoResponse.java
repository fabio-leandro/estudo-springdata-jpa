package com.fabio.gymapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentDtoResponse {

    private Long id;

    private StudentDto student;

    private LocalDate dateAssessment;

    private double weight;

    private double height;

}
