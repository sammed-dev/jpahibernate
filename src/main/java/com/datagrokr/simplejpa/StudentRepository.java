package com.datagrokr.simplejpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.datagrokr.simplejpa.model.Student;

public class StudentRepository {
    
    private EntityManager entityManager;
    private EntityManagerFactory emf;
    public StudentRepository(){
        this.emf = Persistence.createEntityManagerFactory("student_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public Student addStudent(Student student){
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student;
    }

    public Student findStudent(long id){
        return entityManager.find(Student.class, id);
    }

     public Student findStudentById(Long id){
        Query query = entityManager.createNamedQuery("find student by id");
        query.setParameter("id", 3L);
        return (Student)query.getSingleResult();
    }

    public List<String> findFirstNames(){
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT s.firstName from Student s");
        return query.getResultList();
    }


    public Student updateStudent(Student student){
        Student studentToUpdate = entityManager.find(Student.class, student.getId());
        entityManager.getTransaction().begin();
        studentToUpdate.setFirstName(student.getFirstName());
        studentToUpdate.setLastName(student.getLastName());
        entityManager.getTransaction().commit();
        return studentToUpdate;
    }

    public Student updateFirstNameById(String firstName,Long id){
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Student s SET s.firstName = '"+ firstName +"' WHERE id="+id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        return findStudentById(id);
    }

    public void deleteStudent(Student student){
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    public void close(){
        this.entityManager.close();
        this.emf.close();
    }

}
