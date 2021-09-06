package com.digitalinnovation.one.designpatternsapiproject.service.impl;

import com.digitalinnovation.one.designpatternsapiproject.entity.Student;
import com.digitalinnovation.one.designpatternsapiproject.entity.University;
import com.digitalinnovation.one.designpatternsapiproject.repository.StudentRepository;
import com.digitalinnovation.one.designpatternsapiproject.repository.UniversityRepository;
import com.digitalinnovation.one.designpatternsapiproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public Iterable<Student> searchAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student searchById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    @Override
    public void insertStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        Optional<Student> new_student = studentRepository.findById(id);
        if (new_student.isPresent()) {
            studentRepository.save(student);
        }
    }

    @Override
    public void deletar(Long id) {
        studentRepository.deleteById(id);
    }
}
