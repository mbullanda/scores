package dao;

import model.Club;
import model.Coach;
import model.Country;
import model.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class PlayerDao {
    private EntityManagerFactory factory;

    public PlayerDao(EntityManagerFactory factory){
        this.factory = factory;
    }

    public boolean isPlayerPresent(Player player) {
//        if (player.getId() == null){
//            return false;
//        }
//        return findPlayer(player.getId()) != null;
        return false;
    }

    public void savePlayer(Player player) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

//        Country country = player.getCountry();
//        country.addPlayer(player);
//        Club club = player.getClub();
//        club.addPlayer(player);  //do testów zamknięte

        entityManager.persist(player);
//        entityManager.persist(club);
//        entityManager.persist(country);


        System.out.println("Saving player: " + player.getFirstName() + " " + player.getLastName());

        transaction.commit();
        entityManager.close();
    }

    public Player findPlayer(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Player player = entityManager.find(Player.class, id);

        transaction.commit();
        entityManager.close();

        return player;
    }
}
