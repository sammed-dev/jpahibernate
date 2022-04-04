package com.datagrokr.simplejpa;

import com.datagrokr.simplejpa.model.School;
import com.datagrokr.simplejpa.model.Student;

public class App 
{
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("shreyank");
        student.setLastName("jain");

        StudentRepository studentRepository = new StudentRepository();
        SchoolRepository schoolRepository = new SchoolRepository();


        student = studentRepository.addStudent(student);
        System.out.println(student.toString());


        School school = new School("PESCE", "Bangalore");
        schoolRepository.addSchool(school);

        studentRepository.addSchool(student.getId(), school);

        student.setSchool(school);
        System.out.println("student-school : "+student.toString());


         // student = studentRepository.findStudentById(student.getId());

        // List<String> firstNames =   studentRepository.findFirstNames();
        // System.out.println(firstNames);
        // student = studentRepository.findStudent(3L);
        // System.out.println("student with id : "+ student.getId()+" is "+student);


        student  = studentRepository.findStudentById(student.getId());
        System.out.println("JPQL query to find by id :"+student.toString());

        // student = studentRepository.updateFirstNameById("virat", student.getId());
        // System.out.println("update firstName : "+ student.toString());
        // studentRepository.deleteById(4L);

        // student.setFirstName("Ab");
        // studentRepository.updateStudent(student);
        // studentRepository.deleteStudent(student);

        // List<String> firstNamesStartsWith = studentRepository.findFirstNamesStartsWith("s");
        // System.out.println("firstNames starts with :"+firstNamesStartsWith.toString());

        // System.out.println("total no of students : "+studentRepository.totalNoOfStudents());

        // List<String> orderByFirstName = studentRepository.findSortingByFirstName();
        // System.out.println(orderByFirstName.toString());

    }
}
