package dao;

import model.Club;
import model.Coach;
import model.Country;
import model.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class PlayerDao {
    public boolean isPlayerPresent(Player player) {
        //sprawdza czy piłkarz już istnieje
        return false;
    }

    public void savePlayer(Player player) {
        EntityManagerFactory factory = SessionConnector.createFactory(Player.class, Coach.class, Club.class, Country.class);
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Player playerToSave = new Player();
        playerToSave.setNumber(player.getNumber());
        playerToSave.setFirstName(player.getFirstName());
        playerToSave.setLastName(player.getLastName());
        playerToSave.setDateOfBirth(player.getDateOfBirth());
        playerToSave.setGoals(player.getGoals());
        playerToSave.setAssists(player.getAssists());

        Country country = player.getCountry();
        country.addPlayer(playerToSave);
        Club club = player.getClub();
        club.addPlayer(playerToSave);

        entityManager.persist(playerToSave);
        entityManager.persist(club);
        entityManager.persist(country);


        System.out.println("Saving player: " + playerToSave.getFirstName() + " " + playerToSave.getLastName());

        transaction.commit();
        entityManager.close();
    }
}
