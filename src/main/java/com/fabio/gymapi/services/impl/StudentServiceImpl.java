package com.fabio.gymapi.services.impl;

import com.fabio.gymapi.dtos.StudentDto;
import com.fabio.gymapi.entities.Student;
import com.fabio.gymapi.exceptions.StudentNotFoundException;
import com.fabio.gymapi.repositories.StudentRepository;
import com.fabio.gymapi.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        return modelMapper.map(studentRepository.save(student), StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(s -> modelMapper.map(s,StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(Long id) throws StudentNotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto getStudentByCpf(String cpf) throws StudentNotFoundException {
        Student student = studentRepository.findByCpf(cpf).orElseThrow(()-> new StudentNotFoundException(cpf));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updateStudentById(Long id, StudentDto studentDto) throws StudentNotFoundException {
        getStudentById(id);
        Student student = modelMapper.map(studentDto, Student.class);
        return modelMapper.map(studentRepository.save(student), StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) throws StudentNotFoundException {
        getStudentById(id);
        studentRepository.deleteById(id);
    }

}
