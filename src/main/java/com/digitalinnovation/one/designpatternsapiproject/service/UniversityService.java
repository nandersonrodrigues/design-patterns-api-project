package com.digitalinnovation.one.designpatternsapiproject.service;

import com.digitalinnovation.one.designpatternsapiproject.entity.Student;
import com.digitalinnovation.one.designpatternsapiproject.entity.University;

public interface UniversityService {

    Iterable<University> searchAll();
    University searchById(Long id);
    void insertUniversity(University university);
    void updateUniversity(Long id, University university);
    void deleteUniversity(Long id);
    void insertStudentInUniversity(Long id_student, Long id_university);
}
