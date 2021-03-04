import controller.ConsoleController;
import dao.*;
import data.Clubs;
import data.Countries;
import data.Players;
import model.Club;
import model.Coach;
import model.Country;
import model.Player;
import org.hibernate.SessionFactory;
import service.ClubService;
import service.CoachService;
import service.CountryService;
import service.PlayerService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        PlayerDao playerDao = new PlayerDao();
        CoachDao coachDao = new CoachDao();
        ClubDao clubDao = new ClubDao();
        CountryDao countryDao = new CountryDao();

        PlayerService playerService = new PlayerService(playerDao);
        CoachService coachService = new CoachService(coachDao);
        ClubService clubService = new ClubService(clubDao);
        CountryService countryService = new CountryService(countryDao);

        ConsoleController consoleController = new ConsoleController(playerService, clubService, coachService, countryService);


        EntityManagerFactory factory = SessionConnector.createFactory(Player.class, Coach.class, Club.class, Country.class);
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

//        Country belgium = new Country("Belgium", 30528,11303528, "BE");
//
//        countryService.saveCountry(belgium);
//
//        Club realMadrid = new Club("Real Madrid", LocalDate.of(1902,3,6), 13, belgium);
//
//        clubService.saveClub(realMadrid);
//
//        Player thibautCourtois =
//                new Player(1, "Thibaut", "Courtois", LocalDate.of(1992,5,11),
//                        0,0, realMadrid, belgium);
//        playerService.savePlayer(thibautCourtois);



        transaction.commit();
        entityManager.close();


        initiateData(playerService, clubService, countryService);

        for (int i = 0; ; i++) {
            System.out.println("Enter action: ");
            System.out.println("1.Add new player.");
            System.out.println("2.Display player");
            System.out.println("0.Exit");
            int number = consoleController.scanner().nextInt();
            if (number == 1) {
                consoleController.savePlayer();
            } else if (number == 2){
                System.out.println("...");
            } else if (number == 1){
                break;
            }
        }

    }

    public static void initiateData(PlayerService playerService, ClubService clubService, CountryService countryService) {
        new Countries().initiateCountries();
        new Clubs().initiateClubs();
        new Players().initiatePlayers();
    }



}
