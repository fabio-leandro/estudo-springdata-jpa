package com.fabio.gymapi.services;

import com.fabio.gymapi.dtos.AssessmentDtoRequest;
import com.fabio.gymapi.dtos.AssessmentDtoResponse;
import com.fabio.gymapi.dtos.AssessmentDtoResponseStudentName;
import com.fabio.gymapi.exceptions.AssessmentNotFoundException;
import com.fabio.gymapi.exceptions.StudentNotFoundException;

import java.util.List;

public interface AssessmentService {

    AssessmentDtoResponse saveAssessment(Long idStudent, AssessmentDtoRequest assessmentDtoRequest) throws StudentNotFoundException;
    List<AssessmentDtoResponse> getAllAssessment();
    List<AssessmentDtoResponse> getAssessmentsByStudentId(Long idStudent);
    AssessmentDtoResponse getAssessmentById(Long id) throws AssessmentNotFoundException;
    AssessmentDtoResponse updateAssessmentById(Long id, AssessmentDtoRequest assessmentDtoRequest) throws AssessmentNotFoundException;
    void deleteAssessmentById(Long id) throws AssessmentNotFoundException;
    List<AssessmentDtoResponseStudentName> findAssessmentByStudent(String name);

}
