package com.digitalinnovation.one.designpatternsapiproject.service;

import com.digitalinnovation.one.designpatternsapiproject.entity.Student;

public interface StudentService {

    Iterable<Student> searchAll();
    Student searchById(Long id);
    void insertStudent(Student student);
    void updateStudent(Long id, Student student);
    void deletar(Long id);
}
