package com.digitalinnovation.one.designpatternsapiproject.controller;

import com.digitalinnovation.one.designpatternsapiproject.entity.University;
import com.digitalinnovation.one.designpatternsapiproject.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("university")
public class UniversityRestController {

    @Autowired
    private UniversityService universityService;

    @GetMapping
    public ResponseEntity<Iterable<University>> searchAll() {
        return ResponseEntity.ok(universityService.searchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<University> searchForId(@PathVariable Long id) {
        return ResponseEntity.ok(universityService.searchById(id));
    }

    @PostMapping
    public ResponseEntity<University> insertUniversity(@RequestBody  University university) {
        universityService.insertUniversity(university);
        return ResponseEntity.ok(university);
    }

    @PutMapping("/{id}")
    public ResponseEntity<University> updateUniversity(@PathVariable Long id, @RequestBody University new_university) {
        universityService.updateUniversity(id, new_university);
        return ResponseEntity.ok(new_university);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<University> deleteUniversity(@PathVariable Long id) {
        universityService.deleteUniversity(id);
        return ResponseEntity.ok().build();
    }
}
