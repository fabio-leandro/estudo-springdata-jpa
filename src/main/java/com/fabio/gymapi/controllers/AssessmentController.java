package com.fabio.gymapi.controllers;

import com.fabio.gymapi.dtos.AssessmentDtoRequest;
import com.fabio.gymapi.dtos.AssessmentDtoResponse;
import com.fabio.gymapi.dtos.AssessmentDtoResponseStudentName;
import com.fabio.gymapi.exceptions.AssessmentNotFoundException;
import com.fabio.gymapi.exceptions.StudentNotFoundException;
import com.fabio.gymapi.services.impl.AssessmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/${api.version}/gym/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentServiceImpl assessmentService;

    @PostMapping("/{idStudent}")
    public ResponseEntity<AssessmentDtoResponse> saveAssessment(@PathVariable Long idStudent, @Valid @RequestBody
            AssessmentDtoRequest assessmentDtoRequest) throws StudentNotFoundException {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(assessmentService.saveAssessment(idStudent,assessmentDtoRequest));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AssessmentDtoResponse> getAllAssessment(){
        return assessmentService.getAllAssessment();
    }

    @GetMapping("/idStudent")
    @ResponseStatus(HttpStatus.OK)
    public List<AssessmentDtoResponse> getAssessmentsByStudentId(@RequestParam(name = "id") Long studentId){
        return assessmentService.getAssessmentsByStudentId(studentId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssessmentDtoResponse> getAssessmentById(@PathVariable Long id) throws AssessmentNotFoundException {
        return ResponseEntity.ok(assessmentService.getAssessmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssessmentDtoResponse> updateAssessmentById(@PathVariable Long id, @RequestBody
            AssessmentDtoRequest assessmentDtoRequest) throws AssessmentNotFoundException {
       return ResponseEntity.ok(assessmentService.updateAssessmentById(id,assessmentDtoRequest));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAssessmentById(@PathVariable Long id) throws AssessmentNotFoundException {
        assessmentService.deleteAssessmentById(id);
    }

    @GetMapping("/studentName")
    @ResponseStatus(HttpStatus.OK)
    List<AssessmentDtoResponseStudentName> findAssessmentByStudent(@RequestParam(name = "name") String name){
        return assessmentService.findAssessmentByStudent(name);
    }


}
