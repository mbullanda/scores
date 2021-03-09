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
        return false;
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

//    public static Club findClub(String name) {
//        EntityManager entityManager = factory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//
////        TypedQuery<Club> query = entityManager.createQuery("Select c from Club c where c.name = :name", Club.class);
////        query.setParameter("name", name);
////        Club club = query.getSingleResult();
//
//        transaction.commit();
//        entityManager.close();
//
//        return club;
//    }


}
