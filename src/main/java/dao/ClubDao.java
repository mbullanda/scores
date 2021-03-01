package dao;

import model.Club;

import javax.persistence.*;

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

    public static Club findClub(String name) {
        EntityManagerFactory factory = SessionConnector.createFactory(Club.class);
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Club> query = entityManager.createQuery("Select c from Club c where c.name = :name", Club.class);
        query.setParameter("name", name);
        Club club = query.getSingleResult();

        transaction.commit();
        entityManager.close();

        return club;
    }


}
