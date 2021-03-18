package dao;

import model.Club;
import model.Coach;
import model.Country;
import model.Player;

import javax.persistence.*;
import java.util.Comparator;
import java.util.Set;

public class ClubDao {
    private EntityManagerFactory factory;

    public ClubDao(EntityManagerFactory factory){
        this.factory = factory;
    }

    public boolean isClubPresent(Club club) {
        if (club.getId() == null){
            return false;
        }
        return findClubById(club.getId()) != null;
    }

    public void saveClub(Club club) {
        Country country = club.getCountry();
        country.addClub(club);

        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(club);

        System.out.println("Saving club: " + club.getName());

        transaction.commit();
        entityManager.close();
    }

    public Club findClubById(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Club club = entityManager.find(Club.class, id);

        transaction.commit();
        entityManager.close();

        return club;
    }

    public void viewTeam(Long clubId){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Club club = entityManager.find(Club.class, clubId);

        Set<Player> players = club.getPlayers();
        Set<Coach> coaches = club.getCoaches();

        System.out.println(club.getName());
        System.out.println("    Players in: ");
        players.stream()
                .sorted(Comparator.comparing(s -> s.getNumber()))
                .forEach(System.out::println);

        System.out.println("    Coaches in: ");
        coaches.stream()
                .forEach(System.out::println);
        System.out.println();

        transaction.commit();
        entityManager.close();
    }

    public void deleteClub(Long id){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String query = "from Club c where c.id = :id";

        TypedQuery<Club> typedQuery = entityManager.createQuery(query, Club.class);
        typedQuery.setParameter("id", id);

        Club club = typedQuery.getSingleResult();

        System.out.println(club.getName() + " successfully deleted!");
        entityManager.remove(club);

        transaction.commit();
        entityManager.close();
    }

}
