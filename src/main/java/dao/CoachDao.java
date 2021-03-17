package dao;

import model.Club;
import model.Coach;
import model.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Set;

public class CoachDao {
    private EntityManagerFactory factory;

    public CoachDao(EntityManagerFactory factory){
        this.factory = factory;
    }

    public void saveCoach(Coach coach) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(coach);

        Country country = coach.getCountry();
        country.addCoach(coach);
        Club club = coach.getClub();
        club.addCoach(coach);

        System.out.println("Saving coach: " + coach.getFirstName() + " " + coach.getLastName());

        transaction.commit();
        entityManager.close();
    }
    public Coach findCoachById(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Coach coach = entityManager.find(Coach.class, id);

        transaction.commit();
        entityManager.close();

        return coach;
    }

    public boolean isCoachPresent(Coach coach) {
        if (coach.getId() == null){
            return false;
        }
        return findCoachById(coach.getId()) != null;
    }

    public void displayCoachesByCountryId(Long id){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Country country = entityManager.find(Country.class, id);

        Set<Coach> coaches = country.getCoaches();

        for (Coach coach : coaches) {
            System.out.println(coach.toString() + ", " + coach.getClub().getName());
        }

        transaction.commit();
        entityManager.close();
    }

}
