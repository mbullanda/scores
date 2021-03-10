package dao;

import model.Club;
import model.Coach;
import model.Country;
import model.Player;

import javax.persistence.*;

public class ClubDao {
    private EntityManagerFactory factory;

    public ClubDao(EntityManagerFactory factory){
        this.factory = factory;
    }

    public boolean isClubPresent(Club club) {
        if (club.getId() == null){
            return false;
        }
        return findClub(club.getId()) != null;
    }

    public void saveClub(Club club) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //club.getCountry().addClub(club); //do testów zamknięte

        entityManager.persist(club);

        System.out.println("Saving club: " + club);

        transaction.commit();
        entityManager.close();
    }

    public Club findClub(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Club club = entityManager.find(Club.class, id);

        transaction.commit();
        entityManager.close();

        return club;
    }


}
