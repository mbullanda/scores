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

       DbFiller.dbFiller(playerService,coachService,clubService,countryService);
//        initiateData();

        consoleController.mainMenu();

    }

    public static void initiateData() {
        new Countries().initiateCountries();
        new Clubs().initiateClubs();
        new Coaches().initiateCoaches();
        new Players().initiatePlayers();
    }



}
