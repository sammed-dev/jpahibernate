package com.datagrokr.simplejpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.datagrokr.simplejpa.model.School;
import com.datagrokr.simplejpa.model.Student;

public class SchoolRepository {
    private EntityManager entityManager;
    private EntityManagerFactory emf;
    public SchoolRepository(){
        this.emf = Persistence.createEntityManagerFactory("student_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public School addSchool(School school){
        entityManager.getTransaction().begin();
        entityManager.persist(school);
        entityManager.getTransaction().commit();
        return school;
    }

    public School findSchool(long id){
        return entityManager.find(School.class, id);
    }

    public School updateSchool(School school){
        School schoolToUpdate = entityManager.find(School.class, school.getId());
        entityManager.getTransaction().begin();
        schoolToUpdate.setName(school.getName());
        schoolToUpdate.setCity(school.getCity());
        entityManager.getTransaction().commit();
        return schoolToUpdate;
    }

    public void deleteSchool(School school){
        entityManager.getTransaction().begin();
        entityManager.remove(school);
        entityManager.getTransaction().commit();
    }

    public void addStudent(Long id,Student student){
        entityManager.getTransaction().begin();
        School school = findSchool(id);
        if(school != null)
            school.getStudents().add(student);
        entityManager.getTransaction().commit();
    }

    public void removeStudent(Long id, Student student){
        entityManager.getTransaction().begin();
        School school =findSchool(id);
        if(school != null)
            school.getStudents().remove(student);
        entityManager.getTransaction().commit();
    }

    public void close(){
        this.entityManager.close();
        this.emf.close();
    }
}
