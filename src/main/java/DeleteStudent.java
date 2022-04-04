import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.datagrokr.simplejpa.model.Student;

public class DeleteStudent {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        Student student = entityManager.find(Student.class, 6L);
        entityManager.remove(student);
        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
