package com.digitalinnovation.one.designpatternsapiproject.controller;

import com.digitalinnovation.one.designpatternsapiproject.entity.Student;
import com.digitalinnovation.one.designpatternsapiproject.service.StudentService;
import com.digitalinnovation.one.designpatternsapiproject.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> searchAll() {
        return ResponseEntity.ok(studentService.searchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> searchForId(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.searchById(id));
    }

    @PostMapping
    public ResponseEntity<Student> insertStudent(@RequestBody  Student student) {
        studentService.insertStudent(student);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student new_student) {
        studentService.updateStudent(id, new_student);
        return ResponseEntity.ok(new_student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

}
