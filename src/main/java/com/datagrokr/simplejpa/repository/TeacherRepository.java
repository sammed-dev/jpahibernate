package com.datagrokr.simplejpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.datagrokr.simplejpa.model.Teacher;


public class TeacherRepository {
    private EntityManager entityManager;
    private EntityManagerFactory emf;
    public TeacherRepository(){
        this.emf = Persistence.createEntityManagerFactory("student_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public Teacher addTeacher(Teacher teacher){
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
        return teacher;
    }

    public Teacher findTeacher(long id){
        return entityManager.find(Teacher.class, id);
    }

    public Teacher updateTeacher(Teacher teacher){
        Teacher teacherToUpdate = entityManager.find(Teacher.class, teacher.getId());
        entityManager.getTransaction().begin();
        teacherToUpdate.setFirstName(teacher.getFirstName());
        teacherToUpdate.setLastName(teacher.getLastName());
        entityManager.getTransaction().commit();
        return teacherToUpdate;
    }

    public void deleteTeacher(Teacher teacher){
        entityManager.getTransaction().begin();
        entityManager.remove(teacher);
        entityManager.getTransaction().commit();
    }

    public void close(){
        this.entityManager.close();
        this.emf.close();
    }
    
}
