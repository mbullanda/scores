package dao;

import model.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

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
        if (country.getId() == null){
            return false;
        }
        return findCountryById(country.getId()) != null;
    }

    public Country findCountryById(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Country country = entityManager.find(Country.class, id);

        transaction.commit();
        entityManager.close();

        return country;
    }

}
