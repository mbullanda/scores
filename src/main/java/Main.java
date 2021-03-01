import controller.ConsoleController;
import dao.ClubDao;
import dao.CoachDao;
import dao.PlayerDao;
import service.ClubService;
import service.CoachService;
import service.PlayerService;

public class Main {

    public static void main(String[] args) {
        PlayerDao playerDao = new PlayerDao();
        CoachDao coachDao = new CoachDao();
        ClubDao clubDao = new ClubDao();

        PlayerService playerService = new PlayerService(playerDao);
        CoachService coachService = new CoachService(coachDao);
        ClubService clubService = new ClubService(clubDao);

        ConsoleController consoleController = new ConsoleController(playerService, clubService, coachService);


    }



}
