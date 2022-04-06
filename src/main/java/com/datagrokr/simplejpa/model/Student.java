package com.datagrokr.simplejpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
// @DiscriminatorValue(value = "ST")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@NamedQuery(name = "find student by id", query = "SELECT s FROM Student s where s.id =:id")
public class Student extends Person {


    @OneToOne
    private Tutor tutor;

    @ManyToMany(mappedBy = "students")
    private Set<Teacher> teachers = new HashSet<>();
    

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "Student [teachers=" + teachers + ", tutor=" + tutor + "]";
    }

    
   
}
