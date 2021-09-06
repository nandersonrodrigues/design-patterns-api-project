package com.digitalinnovation.one.designpatternsapiproject.repository;

import com.digitalinnovation.one.designpatternsapiproject.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
