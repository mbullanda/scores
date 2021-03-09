package dao;

import model.Club;
import model.Coach;
import model.Country;
import model.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class CoachDao {
    private EntityManagerFactory factory;

    public CoachDao(EntityManagerFactory factory){
        this.factory = factory;
    }

    public void saveCoach(Coach coach) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

//        coach.getCountry().addCoach(coach);
//        coach.getClub().addCoach(coach); //do testów zamknięte

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
