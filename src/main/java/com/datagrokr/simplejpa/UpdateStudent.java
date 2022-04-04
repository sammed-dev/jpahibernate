package com.datagrokr.simplejpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.datagrokr.simplejpa.model.Student;

public class UpdateStudent {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student_pu");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        Student student = entityManager.find(Student.class, 3L);
        student.setFirstName("virat");
        student.setLastName("King kohli");
        entityTransaction.commit();
        entityManager.close();
        emf.close();
    }
}
