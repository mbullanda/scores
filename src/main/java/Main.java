import controller.ConsoleController;
import dao.*;
import dbFiller.*;
import org.hibernate.cfg.Configuration;
import service.ClubService;
import service.CoachService;
import service.CountryService;
import service.PlayerService;

import javax.persistence.EntityManagerFactory;
import java.util.Scanner;

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

       // DbFiller.dbFiller(playerService,coachService,clubService,countryService);
//        initiateData();

        for (int i = 0; ; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter action: ");
            System.out.println("1.Add new player.");
            System.out.println("2.Display player");
            System.out.println("0.Exit");
            int number = scanner.nextInt();
            if (number == 1) {
                consoleController.savePlayer();
            } else if (number == 2){
                System.out.print("Enter club id: ");
                long clubId = scanner.nextLong();
                consoleController.getPLayersByClub(clubId);
            } else if (number == 3){
                playerService.addGoal();
            } else if (number == 0){
                break;
            }
        }

    }

    public static void initiateData() {
        new Countries().initiateCountries();
        new Clubs().initiateClubs();
        new Coaches().initiateCoaches();
        new Players().initiatePlayers();
    }



}
