import controller.ConsoleController;
import dao.*;
import dbFiller.*;
import org.hibernate.cfg.Configuration;
import service.ClubService;
import service.CoachService;
import service.CountryService;
import service.PlayerService;

import javax.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration().configure().buildSessionFactory();
        PlayerDao playerDao = new PlayerDao(entityManagerFactory);
        CoachDao coachDao = new CoachDao(entityManagerFactory);
        ClubDao clubDao = new ClubDao(entityManagerFactory);
        CountryDao countryDao = new CountryDao(entityManagerFactory);

        PlayerService playerService = new PlayerService(playerDao);
        CoachService coachService = new CoachService(coachDao);
        ClubService clubService = new ClubService(clubDao);
        CountryService countryService = new CountryService(countryDao);

        ConsoleController consoleController = new ConsoleController(playerService, clubService, coachService, countryService);

        //new DbFiller().dbFiller();

        for (int i = 0; ; i++) {
            System.out.println("Enter action: ");
            System.out.println("1.Add new player.");
            System.out.println("2.Display player");
            System.out.println("0.Exit");
            int number = consoleController.scanner().nextInt();
            if (number == 1) {
//                consoleController.savePlayer();
            } else if (number == 2){
                System.out.println("...");
            } else if (number == 1){
                break;
            }
        }

    }

//    public static void initiateData() {
//        new Countries().initiateCountries();
//        new Clubs().initiateClubs();
//        new Coaches().initiateCoaches();
//        new Players().initiatePlayers();
//    }



}
