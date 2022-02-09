package com.fabio.gymapi.services.impl;

import com.fabio.gymapi.dtos.AssessmentDtoRequest;
import com.fabio.gymapi.dtos.AssessmentDtoResponse;
import com.fabio.gymapi.dtos.AssessmentDtoResponseStudentName;
import com.fabio.gymapi.entities.AssessmentPhysical;
import com.fabio.gymapi.entities.Student;
import com.fabio.gymapi.exceptions.AssessmentNotFoundException;
import com.fabio.gymapi.exceptions.StudentNotFoundException;
import com.fabio.gymapi.repositories.AssessmentRepository;
import com.fabio.gymapi.repositories.StudentRepository;
import com.fabio.gymapi.services.AssessmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public AssessmentDtoResponse saveAssessment(Long idStudent, AssessmentDtoRequest assessmentDtoRequest) throws StudentNotFoundException {
        Student student = studentRepository.findById(idStudent).orElseThrow(()-> new StudentNotFoundException(idStudent));
        AssessmentPhysical assessment = new AssessmentPhysical();
        assessment.setStudent(student);
        assessment.setWeight(assessmentDtoRequest.getWeight());
        assessment.setHeight(assessmentDtoRequest.getHeight());
        return modelMapper.map(assessmentRepository.save(assessment),AssessmentDtoResponse.class);
    }

    @Override
    public List<AssessmentDtoResponse> getAllAssessment() {
        List<AssessmentPhysical> assessmentPhysicals = assessmentRepository.findAll();
        return assessmentPhysicals.stream().map(a -> modelMapper.map(a,AssessmentDtoResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AssessmentDtoResponse> getAssessmentsByStudentId(Long idStudent) {
        List<AssessmentPhysical> assessmentPhysicals = assessmentRepository.findByStudentId(idStudent);
        return assessmentPhysicals.stream().map( a -> modelMapper.map(a, AssessmentDtoResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public AssessmentDtoResponse getAssessmentById(Long id) throws AssessmentNotFoundException {
        AssessmentPhysical assessmentPhysical = assessmentRepository.findById(id).orElseThrow(()-> new AssessmentNotFoundException(id));
        return modelMapper.map(assessmentPhysical, AssessmentDtoResponse.class);
    }

    @Override
    public AssessmentDtoResponse updateAssessmentById(Long id, AssessmentDtoRequest assessmentDtoRequest)
            throws AssessmentNotFoundException {
        AssessmentPhysical assessmentPhysical = assessmentRepository.findById(id).orElseThrow(()-> new AssessmentNotFoundException(id));
        assessmentPhysical.setWeight(assessmentDtoRequest.getWeight());
        assessmentPhysical.setHeight(assessmentDtoRequest.getHeight());
        return modelMapper.map(assessmentRepository.save(assessmentPhysical),AssessmentDtoResponse.class);
    }

    @Override
    public void deleteAssessmentById(Long id) throws AssessmentNotFoundException {
        getAssessmentById(id);
        assessmentRepository.deleteById(id);
    }

    @Override
    public List<AssessmentDtoResponseStudentName> findAssessmentByStudent(String name){
        List<AssessmentPhysical> assessmentPhysicals = assessmentRepository.findAssessmentByStudent(name);
        return assessmentPhysicals.stream().map(a-> modelMapper.map(a,AssessmentDtoResponseStudentName.class))
                .collect(Collectors.toList());
    }
}
