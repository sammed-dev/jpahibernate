package com.datagrokr.simplejpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "teachers")
public class Teacher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 150)
    private String first_name;

    @Column(name = "last_name", nullable = false, length = 150)
    private String lastName;


    @ManyToOne
    private School school;


    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(
        name = "teachers_students",
        joinColumns = {@JoinColumn(name = "teacher_id")},
        inverseJoinColumns =  {@JoinColumn(name = "student_id")},
        uniqueConstraints = {
            @UniqueConstraint(
                columnNames = {"teacher_id", "student_id"}
            )
        }
    )
    private Set<Student> students = new HashSet<>();

    
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Teacher() {
    }

    public Teacher(String first_name, String lastName) {
        this.first_name = first_name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addStudent(Student student){
        boolean added = students.add(student);
        if(added)
            student.getTeachers().add(this);
    }

    public void removeStudent(Student student){
        boolean removed = students.remove(student);
        if(removed)
            student.getTeachers().remove(this);
    }

    @Override
    public String toString() {
        return "Teacher [first_name=" + first_name + ", id=" + id + ", lastName=" + lastName + ", school=" + school
                + ", students=" + students + "]";
    }

    
}
