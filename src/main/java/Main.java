import controller.ConsoleController;
import dao.ClubDao;
import dao.CoachDao;
import dao.CountryDao;
import dao.PlayerDao;
import service.ClubService;
import service.CoachService;
import service.CountryService;
import service.PlayerService;

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

        for (int i = 0; ; i++) {
            System.out.println("Enter action: ");
            System.out.println("1.Add new player.");
            System.out.println("0.Exit");
            int number = consoleController.scanner().nextInt();
            if (number == 1) {
                consoleController.savePlayer();
            } else if (number == 1){
                break;
            }
        }

    }



}
