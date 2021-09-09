package com.digitalinnovation.one.designpatternsapiproject.service.impl;

import com.digitalinnovation.one.designpatternsapiproject.entity.Student;
import com.digitalinnovation.one.designpatternsapiproject.entity.University;
import com.digitalinnovation.one.designpatternsapiproject.repository.StudentRepository;
import com.digitalinnovation.one.designpatternsapiproject.repository.UniversityRepository;
import com.digitalinnovation.one.designpatternsapiproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

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
    public void updateStudent(Long id, Student new_student) {
        Optional<Student> old_student = studentRepository.findById(id);
        if (old_student.isPresent()) {
            Student student = old_student.get();
            student = new_student;
            studentRepository.save(student);
        }
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
