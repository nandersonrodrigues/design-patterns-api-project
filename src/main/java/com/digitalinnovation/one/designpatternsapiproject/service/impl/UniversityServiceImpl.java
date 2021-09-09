package com.digitalinnovation.one.designpatternsapiproject.service.impl;

import com.digitalinnovation.one.designpatternsapiproject.entity.Student;
import com.digitalinnovation.one.designpatternsapiproject.entity.University;
import com.digitalinnovation.one.designpatternsapiproject.repository.StudentRepository;
import com.digitalinnovation.one.designpatternsapiproject.repository.UniversityRepository;
import com.digitalinnovation.one.designpatternsapiproject.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public Iterable<University> searchAll() {
        return universityRepository.findAll();
    }

    @Override
    public University searchById(Long id) {
        Optional<University> university = universityRepository.findById(id);
        return university.get();
    }

    @Override
    public void insertUniversity(University university) {
        universityRepository.save(university);
    }

    @Override
    public void updateUniversity(Long id, University new_university) {
        Optional<University> university = universityRepository.findById(id);
        if (university.isPresent()) {
            universityRepository.save(new_university);
        }
    }

    @Override
    public void deleteUniversity(Long id) {
        universityRepository.deleteById(id);
    }

    @Override
    public void insertStudentInUniversity(Long id_student, Long id_university) {
        Optional<Student> student = studentRepository.findById(id_student);
        Optional<University> university = universityRepository.findById(id_university);
        if (student.isPresent()) {
            university.get().setStudent(student.get());
            universityRepository.save(university.get());
        }
    }
}
