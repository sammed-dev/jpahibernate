package com.datagrokr.simplejpa;

import java.util.List;

import com.datagrokr.simplejpa.model.Student;

public class App 
{
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Ab");
        student.setLastName("devilliars");

        StudentRepository studentRepository = new StudentRepository();
        // studentRepository.addStudent(student);
        // System.out.println(student.toString());

        List<String> firstNames =   studentRepository.findFirstNames();
        System.out.println(firstNames);
        // student = studentRepository.findStudent(8L);
        // System.out.println(student);

        // student.setFirstName("Ab");
        // studentRepository.updateStudent(student);
        // studentRepository.deleteStudent(student);
    }
}
