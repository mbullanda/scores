package dao;

import model.Club;
import model.Country;
import model.Player;

import javax.persistence.*;
import java.util.List;

public class PlayerDao {
    private EntityManagerFactory factory;

    public PlayerDao(EntityManagerFactory factory){
        this.factory = factory;
    }

    public boolean isPlayerPresent(Player player) {
        if (player.getId() == null){
            return false;
        }
        return findPlayerById(player.getId()) != null;
    }

    public void savePlayer(Player player) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(player);

        Country country = player.getCountry();
        country.addPlayer(player);
        Club club = player.getClub();
        club.addPlayer(player);

//        entityManager.persist(country);
//        entityManager.persist(club);

        System.out.println("Saving player: " + player.getFirstName() + " " + player.getLastName());

        transaction.commit();
        entityManager.close();
    }

    public Player findPlayerById(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Player player = entityManager.find(Player.class, id);

        transaction.commit();
        entityManager.close();

        return player;
    }

    public void addGoal(){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Player> query = entityManager.createQuery
                ("select distinct p form Club c " +
                        "inner join c.players p" +
                        "where p.number = 9 and c_id = 1", Player.class);

        //TypedQuery<User> query = entityManager.createQuery("select distinct u from User u " +
        //                "inner join u.phones p where p.name = 'Samsung'", User.class);

        Player singleResult = query.getSingleResult();
        System.out.println("singleResult = " + singleResult);

//        TypedQuery<Player> from_player = entityManager.createQuery("from Player p where p.number = 1", Player.class);
//        List<Player> resultList = from_player.getResultList();
//        resultList.forEach(System.out::println);


        transaction.commit();
        entityManager.close();
    }
}
