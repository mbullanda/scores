package dao;

import model.Club;
import model.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Comparator;
import java.util.Set;

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

    public void displayClubsInCountry(Long countryId) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Country country = entityManager.find(Country.class, countryId);

        Set<Club> clubs = country.getClubs();

        for (Club c: clubs){
            System.out.println(c.getName() + ", players in squad: " + c.getPlayers().size() + ", trophies: "
                    + c.getTrophies());
        }

        transaction.commit();
        entityManager.close();
    }

    public void deleteCountry(Long id){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String query = "from Country c where c.id = :id";

        TypedQuery<Country> typedQuery = entityManager.createQuery(query, Country.class);
        typedQuery.setParameter("id", id);

        Country country = typedQuery.getSingleResult();

        System.out.println(country.getName() + " successfully deleted!");
        entityManager.remove(country);

        transaction.commit();
        entityManager.close();
    }
}
