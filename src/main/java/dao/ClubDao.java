package dao;

import model.Club;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class ClubDao {

    public boolean isClubPresent(Club club) {
        return false;
    }

    public void saveClub(Club club) {
        EntityManagerFactory factory = SessionConnector.createFactory(Club.class);
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(club);

        System.out.println("Saving club: " + club);

        transaction.commit();
        entityManager.close();
    }
}
