package com.fabio.gymapi.services;


import com.fabio.gymapi.dtos.StudentDto;
import com.fabio.gymapi.exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentService {

    StudentDto saveStudent(StudentDto studentDto);
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id) throws StudentNotFoundException;
    StudentDto getStudentByCpf(String cpf) throws StudentNotFoundException;
    StudentDto updateStudentById(Long id, StudentDto studentDto) throws StudentNotFoundException;
    void deleteStudentById(Long id) throws StudentNotFoundException;

}
