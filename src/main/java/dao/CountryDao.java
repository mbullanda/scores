package dao;

import model.Club;
import model.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Scanner;
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

    public void editCountry(long countryId, int action) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String query = "from Country c where c.id = :id";

        TypedQuery<Country> typedQuery = entityManager.createQuery(query, Country.class);
        typedQuery.setParameter("id", countryId);

        Country country = typedQuery.getSingleResult();

        Scanner scanner = new Scanner(System.in);
        switch (action){
            case 1:
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                country.setName(name);
                break;
            case 2:
                System.out.print("Enter iso code: ");
                String isoCode = scanner.nextLine();
                country.setIsoCode(isoCode);
                break;
            case 3:
                System.out.print("Enter surface area: ");
                int surfaceArea = scanner.nextInt();
                country.setSurfaceArea(surfaceArea);
                break;
            case 4:
                System.out.print("Enter population: ");
                int population = scanner.nextInt();
                country.setPopulation(population);
                break;
        }

        transaction.commit();
        entityManager.close();
    }
}
