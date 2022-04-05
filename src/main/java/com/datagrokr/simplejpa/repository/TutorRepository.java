package com.datagrokr.simplejpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.datagrokr.simplejpa.model.Tutor;

public class TutorRepository {
    private EntityManager entityManager;
    private EntityManagerFactory emf;
    public TutorRepository(){
        this.emf = Persistence.createEntityManagerFactory("student_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public Tutor addTutor(Tutor tutor){
        entityManager.getTransaction().begin();
        entityManager.persist(tutor);
        entityManager.getTransaction().commit();
        return tutor;
    }

    public Tutor findTutor(long id){
        return entityManager.find(Tutor.class, id);
    }

    public Tutor updateTutor(Tutor tutor){
        Tutor tutorToUpdate = entityManager.find(Tutor.class, tutor.getId());
        entityManager.getTransaction().begin();
        tutorToUpdate.setFirstName(tutor.getFirstName());
        tutorToUpdate.setLastName(tutor.getLastName());
        entityManager.getTransaction().commit();
        return tutorToUpdate;
    }

    public void deleteTutor(Tutor tutor){
        entityManager.getTransaction().begin();
        entityManager.remove(tutor);
        entityManager.getTransaction().commit();
    }

    public void close(){
        this.entityManager.close();
        this.emf.close();
    }
}
