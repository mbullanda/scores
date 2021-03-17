package controller;

import lombok.AllArgsConstructor;
import model.Club;
import model.Coach;
import model.Country;
import model.Player;
import service.ClubService;
import service.CoachService;
import service.CountryService;
import service.PlayerService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@AllArgsConstructor
public class ConsoleController {
    private final PlayerService playerService;
    private final ClubService clubService;
    private final CoachService coachService;
    private final CountryService countryService;

    public Scanner scanner(){
        return new Scanner(System.in);
    }

    public void savePlayer(){
        new PlayerController().savePlayer(playerService,countryService,clubService);
    }

    public void saveCoach(){
        new CoachController().saveCoach(coachService, countryService, clubService);
    }
    public void saveClub(){
        new ClubController().saveClub(clubService, countryService);
    }
    public void saveCountry(){
        new CountryController().saveCountry(countryService);
    }

    public void mainMenu(){
        for (int i = 0; ; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome in Scores! Enter action: ");
            System.out.println("1.BROWSE");
            System.out.println("2.STATISTICS");
            System.out.println("3.DATA OPERATIONS");
            System.out.println("4.ADD NEW MATCH");
            System.out.println("5.Soon");
            System.out.println();
            System.out.println("0.EXIT");
            int number = scanner.nextInt();
            switch (number){
                case 1:
                    browsePanel();
                    break;
                case 2:
                    statisticsPanel();
                    break;
                case 3:
                    dataOperationsPanel();
                    break;
                case 4:
                    addNewMatchPanel();
                    break;
                case 5:
                    System.out.println("Soon!");
                    break;
                case 0:
                    return;
            }
        }
    }

    private void addNewMatchPanel() {

    }

    private void dataOperationsPanel() {
        for (int i = 0; ; i++){
            System.out.println("Welcome in data operations menu. Enter action: ");
            System.out.println("1.Add new...");
            System.out.println("2.Add goals");
            System.out.println("3.");
            System.out.println("4.Delete...");
            System.out.println();
            System.out.println("0.Back");
            int number = scanner().nextInt();

            switch (number) {
                case 1:
                    System.out.println("Enter adding action:");
                    System.out.println("1.Add new player");
                    System.out.println("2.Add new club");
                    System.out.println("3.Add new coach");
                    System.out.println("4.Add new country");
                    System.out.println();
                    System.out.println("0.Back");
                    int action = scanner().nextInt();
                    if (action == 1){
                        savePlayer();
                    } else if (action == 2){
                        saveClub();
                    } else if (action == 3){
                        saveCoach();
                    } else if (action == 4){
                        saveCountry();
                    } else if (action == 0){
                        break;
                    }
                        break;
                case 2:
                    System.out.print("Enter player number: ");
                    int playerNumber = scanner().nextInt();
                    System.out.print("Enter club id: ");
                    long clubId = scanner().nextLong();
                    playerService.addGoal(playerNumber,clubId);
                    break;
                case 3:
                    System.out.print("soon");
                    break;
                case 4:
                    System.out.println("Enter action: ");
                    System.out.println("1.Delete player");
                    System.out.println("2.Delete club");
                    System.out.println("3.Delete coach");
                    System.out.println("4.Delete country");
                    System.out.println("5.Clear statistics");
                    System.out.println();
                    System.out.println("0.Back");
                    action = scanner().nextInt();
                    if (action == 1){
                        System.out.println("delete player");
                    } else if (action == 2){
                        System.out.println("delete club");
                    } else if (action == 3){
                        System.out.println("delete coach");
                    } else if (action == 4){
                        System.out.println("delete country");
                    } else if (action == 5){
                        System.out.print("Are you sure you want to clear statistics?[yes/no]");
                        String sure = scanner().nextLine();
                        boolean areYouSure = false;
                        if (sure.equalsIgnoreCase("yes")){
                            areYouSure = true;
                        } else {
                            break;
                        }
                        System.out.print("Type password:");
                        String password = scanner().nextLine();
                        playerService.clearStatistics(areYouSure,password);
                    } else if (action == 0){
                        break;
                    }
                    break;
                case 0:
                    return;
            }
        }

    }

    private void statisticsPanel() {

    }

    private void browsePanel() {
        for (int i = 0; ; i++){
            System.out.println("Welcome in browse menu. Enter action: ");
            System.out.println("1.Display best scorers/assistants");
            System.out.println("2.View team");
            System.out.println("3.Display clubs by country");
            System.out.println("4.Display coaches by country");
            System.out.println();
            System.out.println("0.Back");
            int number = scanner().nextInt();

            switch (number) {
                case 1:
                    System.out.println("Enter action:");
                    System.out.println("1.Scorers");
                    System.out.println("2.Assistants");
                    System.out.println();
                    System.out.println("0.Back");
                    int action = scanner().nextInt();
                    if (action == 1){
                        playerService.displayBestScorers();
                    } else if (action == 2){
                        playerService.displayBestAssistants();
                    } else if (action == 0){
                        break;
                    }
                    break;
                case 2:
                    System.out.print("Enter club id: ");
                    long clubId = scanner().nextLong();
                    clubService.viewTeam(clubId);
                    break;
                case 3:
                    System.out.print("Enter country id:");
                    long countryId = scanner().nextLong();
                    countryService.displayClubsInCountry(countryId);
                    break;
                case 4:
                    System.out.println("Enter country id:");
                    countryId = scanner().nextLong();
                    coachService.displayCoachesByCountryId(countryId);
                    break;
                case 0:
                    return;
            }
        }
    }

}
