package com.datagrokr.simplejpa.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
@NamedQuery(name = "find student by id", query = "SELECT s FROM Student s where s.id =:id")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 150)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 150)
    private String lastName;


    @OneToOne
    private School school;


    public Long getId() {
        return id;
    }

    public Student() {
    }

    public Student(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + ", school=" + school + "]";
    }

    
       
}
