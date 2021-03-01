package dao;

import model.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class CountryDao {

    public void saveCountry(Country country) {
        EntityManagerFactory factory = SessionConnector.createFactory(Country.class);
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
}
