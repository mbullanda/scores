package dao;

import model.Club;
import model.Coach;
import model.Country;
import model.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
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

    public void editCoach(Long id, int action){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String query = "from Coach c where c.id = :id";

        TypedQuery<Coach> typedQuery = entityManager.createQuery(query, Coach.class);
        typedQuery.setParameter("id", id);

        Coach coach = typedQuery.getSingleResult();

        Scanner scanner = new Scanner(System.in);
        switch (action){
            case 1:
                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();
                coach.setFirstName(firstName);
                break;
            case 2:
                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();
                coach.setLastName(lastName);
                break;
            case 3:
                System.out.print("Enter date of birth (yyyyMMdd): ");
                String dateOfBirth = scanner.nextLine();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                LocalDate parsedDate = LocalDate.parse(dateOfBirth, dateTimeFormatter);
                coach.setDateOfBirth(parsedDate);
                break;
            case 4:
                System.out.print("Enter club id: ");
                long newClubId = scanner.nextLong();
                Club newClub = entityManager.find(Club.class, newClubId);
                coach.setClub(newClub);
                break;
            case 5:
                System.out.print("Enter country id: ");
                long newCountryId = scanner.nextLong();
                Country newCountry = entityManager.find(Country.class, newCountryId);
                coach.setCountry(newCountry);
                break;
        }

        transaction.commit();
        entityManager.close();
    }

    public void deleteCoach(Long id){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String query = "from Coach c where c.id = :id";

        TypedQuery<Coach> typedQuery = entityManager.createQuery(query, Coach.class);
        typedQuery.setParameter("id", id);

        Coach coach = typedQuery.getSingleResult();

        System.out.println(coach.getFirstName() + " " + coach.getLastName() + " successfully deleted!");
        entityManager.remove(coach);

        transaction.commit();
        entityManager.close();
    }
}
