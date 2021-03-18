package dao;

import model.Club;
import model.Country;
import model.Player;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
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

    public Player findPlayerByNumberAndClubId(int number, Long clubId){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String query = "from Player p where p.number = :number and p.club = :club";

        Club club = entityManager.find(Club.class, clubId);

        TypedQuery<Player> typedQuery = entityManager.createQuery(query, Player.class);
        typedQuery.setParameter("number", number);
        typedQuery.setParameter("club", club);

        Player player = typedQuery.getSingleResult();

        transaction.commit();
        entityManager.close();

        return player;
    }

    public void addGoal(int number, Long clubId){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String query = "from Player p where p.number = :number and p.club = :club";

        Club club = entityManager.find(Club.class, clubId);

        TypedQuery<Player> typedQuery = entityManager.createQuery(query, Player.class);
        typedQuery.setParameter("number", number);
        typedQuery.setParameter("club", club);

        Player player = typedQuery.getSingleResult();

        player.setGoals(player.getGoals() + 1);

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

    public void clearStatistics(boolean sure, String password){
        if (sure == true && password.equals("lalala")){
            EntityManager entityManager = factory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            TypedQuery<Player> typedQuery = entityManager.createQuery("from Player", Player.class);

            List<Player> players = typedQuery.getResultList();
            players.forEach(player -> {
                player.setGoals(0);
                player.setAssists(0);
            });

            System.out.println("Are you sure you want to clear statistics?");
            String areYouSure = new Scanner(System.in).nextLine();
            if (areYouSure.equalsIgnoreCase("Yes")){
                transaction.commit();
            } else{
                transaction.rollback();
            }

            entityManager.close();
        }
    }

    public void deletePlayer(int number, Long clubId){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String query = "from Player p where p.number = :number and p.club = :club";

        Club club = entityManager.find(Club.class, clubId);

        TypedQuery<Player> typedQuery = entityManager.createQuery(query, Player.class);
        typedQuery.setParameter("number", number);
        typedQuery.setParameter("club", club);

        Player player = typedQuery.getSingleResult();

        System.out.println(player.getFirstName() + " " + player.getLastName() + " successfully deleted!");
        entityManager.remove(player);

        transaction.commit();
        entityManager.close();
    }

    public void editPlayer(int number, Long clubId, int action){
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String query = "from Player p where p.number = :number and p.club = :club";

        Club club = entityManager.find(Club.class, clubId);

        TypedQuery<Player> typedQuery = entityManager.createQuery(query, Player.class);
        typedQuery.setParameter("number", number);
        typedQuery.setParameter("club", club);

        Player player = typedQuery.getSingleResult();

        Scanner scanner = new Scanner(System.in);
        switch (action){
            case 1:
                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();
                player.setFirstName(firstName);
                break;
            case 2:
                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();
                player.setLastName(lastName);
                break;
            case 3:
                System.out.print("Enter date of birth (yyyyMMdd): ");
                String dateOfBirth = scanner.nextLine();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                LocalDate parsedDate = LocalDate.parse(dateOfBirth, dateTimeFormatter);
                player.setDateOfBirth(parsedDate);
                break;
            case 4:
                System.out.print("Enter goals: ");
                int goals = scanner.nextInt();
                player.setGoals(goals);
                break;
            case 5:
                System.out.print("Enter assists: ");
                int assists = scanner.nextInt();
                player.setAssists(assists);
                break;
            case 6:
                System.out.print("Enter club id: ");
                long newClubId = scanner.nextLong();
                Club newClub = entityManager.find(Club.class, newClubId);
                player.setClub(newClub);
                break;
            case 7:
                System.out.print("Enter country id: ");
                long newCountryId = scanner.nextLong();
                Country newCountry = entityManager.find(Country.class, newCountryId);
                player.setCountry(newCountry);
                break;
        }

        transaction.commit();
        entityManager.close();
    }



}
