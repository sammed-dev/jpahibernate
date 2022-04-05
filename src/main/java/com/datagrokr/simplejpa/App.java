package com.datagrokr.simplejpa;

import com.datagrokr.simplejpa.model.School;
import com.datagrokr.simplejpa.model.Student;
import com.datagrokr.simplejpa.model.Tutor;
import com.datagrokr.simplejpa.repository.SchoolRepository;
import com.datagrokr.simplejpa.repository.StudentRepository;
import com.datagrokr.simplejpa.repository.TutorRepository;

public class App 
{
    public static void main(String[] args) {
        

        StudentRepository studentRepository = new StudentRepository();
        SchoolRepository schoolRepository = new SchoolRepository();
        TutorRepository tutorRepository = new TutorRepository();

        Student student = new Student();
        student.setFirstName("deekshi");
        student.setLastName("patil");

        student = studentRepository.addStudent(student);

        School school = new School("Ramaiah", "Bangalore");
        school = schoolRepository.addSchool(school);

        Tutor tutor = new Tutor("chandashree", "das");
        tutor = tutorRepository.addTutor(tutor);

        student.setTutor(tutor);

        studentRepository.addtutor(student.getId(), tutor);

        // School school = new School();
        // school = schoolRepository.findSchool(4L);
        schoolRepository.addStudent(school.getId(), student);
       
        System.out.println("one to many of school :"+school.getStudents());
        schoolRepository.removeStudent(school.getId(), student);
         // student = studentRepository.findStudentById(student.getId());

        // List<String> firstNames =   studentRepository.findFirstNames();
        // System.out.println(firstNames);
        // student = studentRepository.findStudent(3L);
        // System.out.println("student with id : "+ student.getId()+" is "+student);


        // student  = studentRepository.findStudentById(student.getId());
        // System.out.println("JPQL query to find by id :"+student.toString());

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
