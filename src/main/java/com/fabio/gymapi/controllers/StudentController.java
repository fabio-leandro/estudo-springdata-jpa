package com.fabio.gymapi.controllers;

import com.fabio.gymapi.dtos.StudentDto;
import com.fabio.gymapi.exceptions.StudentNotFoundException;
import com.fabio.gymapi.services.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/${api.version}/gym/students")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<StudentDto> saveStudent(@Valid @RequestBody StudentDto studentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(studentDto));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/studentId")
    public ResponseEntity<StudentDto> getStudentById(@RequestParam(value = "id") Long id) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/studentCpf")
    public ResponseEntity<StudentDto> getStudentByCpf(@RequestParam(value = "cpf") String cpf) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.getStudentByCpf(cpf));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable Long id, @Valid @RequestBody
            StudentDto studentDto) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.updateStudentById(id,studentDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable Long id) throws StudentNotFoundException {
        studentService.deleteStudentById(id);
    }




}
