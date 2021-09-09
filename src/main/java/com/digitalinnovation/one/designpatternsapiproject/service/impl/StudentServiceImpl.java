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
    public void updateStudent(Long id, Student student) {
        Optional<Student> student_in_db = studentRepository.findById(id);
        if (student_in_db.isPresent()) {
            student_in_db.get().setFirst_name(student.getFirst_name());
            student_in_db.get().setLast_name(student.getLast_name());
            student_in_db.get().setUniversity(student.getUniversity());
            studentRepository.save(student_in_db.get());
        }
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
