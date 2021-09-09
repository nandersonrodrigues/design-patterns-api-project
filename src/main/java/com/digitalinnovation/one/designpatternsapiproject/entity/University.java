package com.digitalinnovation.one.designpatternsapiproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String country;

    @JsonIgnore
    @OneToMany(mappedBy = "university")
    private List<Student> students;

    public University() {

    }

    public University(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudent(Student student) {
        this.students.add(student);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "University [id=" + id + ", name=" + name + ", country="
                + country + "]";
    }
}
