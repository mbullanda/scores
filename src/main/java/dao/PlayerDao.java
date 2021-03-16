package dao;

import model.Club;
import model.Country;
import model.Player;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public void addGoal(int number, Long clubId){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String string = "from Player p where p.number = :number";

        TypedQuery<Player> query = entityManager.createQuery(string, Player.class);
        query.setParameter("number", number);

        List<Player> resultList = query.getResultList();

        for (Player p: resultList){
            if (p.getClub().getId() == clubId){
                p.setGoals(p.getGoals() + 1);
            }
        }

        transaction.commit();
        entityManager.close();
    }

    public void displayBestScorers(){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Player> playerTypedQuery = entityManager.createQuery("from Player", Player.class);

        List<Player> players = playerTypedQuery.getResultList().stream()
                .sorted(Comparator.comparing(g -> g.getGoals(), Comparator.reverseOrder()))
                .collect(Collectors.toList());

        for (int i = 0; i < players.size(); i++){
            Player player = players.get(i);
            System.out.println((i + 1) + ". " + player.getFirstName() + " " + player.getLastName() +
                    " (" + player.getClub().getName() + ") :  " + player.getGoals() + " goals.");
        }

        transaction.commit();
        entityManager.close();
    }

    public void displayBestAssistants(){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Player> playerTypedQuery = entityManager.createQuery("from Player", Player.class);

        List<Player> players = playerTypedQuery.getResultList().stream()
                .sorted(Comparator.comparing(a -> a.getAssists(), Comparator.reverseOrder()))
                .collect(Collectors.toList());

        for (int i = 0; i < players.size(); i++){
            Player player = players.get(i);
            System.out.println((i + 1) + ". " + player.getFirstName() + " " + player.getLastName() +
                    " (" + player.getClub().getName() + ") :  " + player.getAssists() + " assists.");
        }

        transaction.commit();
        entityManager.close();
    }



}
