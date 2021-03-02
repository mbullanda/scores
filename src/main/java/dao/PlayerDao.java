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

        player.getCountry().addPlayer(player);
        player.getClub().addPlayer(player);

        entityManager.persist(player);

        System.out.println("Saving player: " + player.getFirstName() + " " + player.getLastName());

        transaction.commit();
        entityManager.close();
    }
}
