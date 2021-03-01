package dao;

import model.Coach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class CoachDao {
    public void saveCoach(Coach coach) {
        EntityManagerFactory factory = SessionConnector.createFactory(Coach.class);
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(coach);

        System.out.println("Saving coach: " + coach);

        transaction.commit();
        entityManager.close();
    }

    public boolean isCoachPresent(Coach coach) {
        //sprawdza czy istnieje już taki coach
        return false;
    }
}
