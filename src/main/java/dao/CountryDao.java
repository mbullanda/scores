package dao;

import model.Club;
import model.Coach;
import model.Country;
import model.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class CountryDao {
    private EntityManagerFactory factory;

    public CountryDao(EntityManagerFactory factory){
        this.factory = factory;
    }

    public void saveCountry(Country country) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();



        entityManager.persist(country);


        System.out.println("Saving country: " + country);

        transaction.commit();
        entityManager.close();
    }

    public boolean isCountryPresent(Country country) {
        return false;
    }

//    public static Country findCountry(String name) {
//        EntityManager entityManager = factory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//
//        TypedQuery<Country> query = entityManager.createQuery("Select c from Country c where c.name = :name", Country.class);
//        query.setParameter("name", name);
//        Country country = query.getSingleResult();
//
//        transaction.commit();
//        entityManager.close();
//
//        return country;
//    }

}
