package com.datagrokr.simplejpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
// @DiscriminatorValue(value = "TE")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Teacher extends Person {
    
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


    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

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
        return "Teacher [school=" + school + ", students=" + students + "]";
    }


}
