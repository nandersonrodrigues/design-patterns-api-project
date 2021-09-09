package com.digitalinnovation.one.designpatternsapiproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String first_name;
    private String last_name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private University university;

    public Student() {

    }

    public Student(String first_name, String last_name, University university) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.university = university;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Student))
            return false;
        Student other = (Student) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + first_name + ", lastName="
                + last_name + "]";
    }
}
