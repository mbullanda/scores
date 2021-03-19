package controller.submenu;

import controller.*;
import lombok.AllArgsConstructor;
import model.Coach;
import model.Player;
import service.ClubService;
import service.CoachService;
import service.CountryService;
import service.PlayerService;

import java.util.Scanner;

@AllArgsConstructor
public class DataOperationsMenu {

    public static void dataOperationsPanel(PlayerService playerService, ClubService clubService, CoachService coachService, CountryService countryService) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; ; i++){
            System.out.println("Welcome in data operations menu. Enter action: ");
            System.out.println("1.Add new...");
            System.out.println("2.Add goals/assists");
            System.out.println("3.Edit...");
            System.out.println("4.Delete...");
            System.out.println();
            System.out.println("0.Back");
            int number = scanner.nextInt();

            switch (number) {
                case 1:
                    System.out.println("Enter adding action:");
                    System.out.println("1.Add new player");
                    System.out.println("2.Add new club");
                    System.out.println("3.Add new coach");
                    System.out.println("4.Add new country");
                    System.out.println();
                    System.out.println("0.Back");
                    int action = scanner.nextInt();
                    if (action == 1){
                       new ConsoleController(playerService, clubService, coachService, countryService).savePlayer();
                    } else if (action == 2){
                       new ConsoleController(playerService, clubService, coachService, countryService).saveClub();
                    } else if (action == 3){
                        new ConsoleController(playerService, clubService, coachService, countryService).saveCoach();
                    } else if (action == 4){
                        new ConsoleController(playerService, clubService, coachService, countryService).saveCountry();
                    } else if (action == 0){
                        break;
                    }
                    break;
                case 2:
                    System.out.println("What do you want to add?");
                    System.out.println("1.Goals");
                    System.out.println("2.Assists");
                    int goalsAssists = scanner.nextInt();
                    if (goalsAssists == 1){
                        System.out.print("Enter player number: ");
                        int playerNumber = scanner.nextInt();
                        System.out.print("Enter club id: ");
                        long clubId = scanner.nextLong();
                        playerService.addGoal(playerNumber,clubId);
                    } else if (goalsAssists == 2){
                        System.out.print("Enter player number: ");
                        int playerNumber = scanner.nextInt();
                        System.out.print("Enter club id: ");
                        long clubId = scanner.nextLong();
                        playerService.addAssist(playerNumber,clubId);
                    }
                    break;
                case 3:
                    System.out.println("Enter action: ");
                    System.out.println("1.Edit player");
                    System.out.println("2.Edit club");
                    System.out.println("3.Edit coach");
                    System.out.println("4.Edit country");
                    System.out.println();
                    System.out.println("0.Back");
                    action = scanner.nextInt();
                    if (action == 1){
                        System.out.print("Enter player number: ");
                        int playerNumber = scanner.nextInt();
                        System.out.print("Enter club id: ");
                        long clubId = scanner.nextLong();
                        System.out.println("What do you want to edit?");
                        System.out.println("1.First name");
                        System.out.println("2.Last name");
                        System.out.println("3.Date of birth");
                        System.out.println("4.Goals");
                        System.out.println("5.Assists");
                        System.out.println("6.Club");
                        System.out.println("7.Country");
                        int actionEdit = scanner.nextInt();
                        playerService.editPlayer(playerNumber,clubId,actionEdit);
                    } else if (action == 2){
                        System.out.print("Enter club id: ");
                        long clubId = scanner.nextLong();
                        System.out.println("What do you want to edit?");
                        System.out.println("1.Name");
                        System.out.println("2.Country");
                        System.out.println("3.Date of foundation");
                        System.out.println("4.Amount of trophies");
                        int actionEdit = scanner.nextInt();
                        clubService.editClub(clubId,actionEdit);
                    } else if (action == 3){
                        System.out.print("Enter coach id: ");
                        long coachId = scanner.nextLong();
                        System.out.println("What do you want to edit?");
                        System.out.println("1.First name");
                        System.out.println("2.Last name");
                        System.out.println("3.Date of birth");
                        System.out.println("4.Club");
                        System.out.println("5.Country");
                        int actionEdit = scanner.nextInt();
                        coachService.editCoach(coachId,actionEdit);
                    } else if (action == 4) {
                        System.out.print("Enter country id: ");
                        long countryId = scanner.nextLong();
                        System.out.println("What do you want to edit?");
                        System.out.println("1.Name");
                        System.out.println("2.Iso code");
                        System.out.println("3.Surface area");
                        System.out.println("4.Population");
                        int actionEdit = scanner.nextInt();
                        countryService.editCountry(countryId,actionEdit);
                    } else if (action == 0) {
                        break;
                    }
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
                    action = scanner.nextInt();
                    if (action == 1){
                        System.out.print("Enter player number: ");
                        int playerNumber = scanner.nextInt();
                        System.out.print("Enter club id: ");
                        long clubId = scanner.nextLong();
                        Player player = playerService.findPlayerByNumberAndClubId(playerNumber, clubId);
                        System.out.println("Are you sure you want to delete " + player.getFirstName() + " "
                                + player.getLastName() + "?[yes/no]");
                        boolean sure = areYouSure();
                        if (!sure){
                            break;
                        }
                        playerService.deletePlayer(playerNumber,clubId);
                    } else if (action == 2){
                        System.out.print("Enter club id: ");
                        long clubId = scanner.nextLong();
                        System.out.println("Are you sure you want to delete " + clubService.findClubById(clubId).getName()
                                + "?[yes/no]");
                        boolean sure = areYouSure();
                        if (!sure){
                            break;
                        }
                        clubService.deleteClub(clubId);
                    } else if (action == 3){
                        System.out.print("Enter coach id: ");
                        long coachId = scanner.nextLong();
                        Coach coachById = coachService.findCoachById(coachId);
                        System.out.print("Are you sure you want to delete " + coachById.getFirstName() + " "
                                + coachById.getLastName() + "?[yes/no]");
                        boolean sure = areYouSure();
                        if (!sure){
                            break;
                        }
                        coachService.deleteCoach(coachId);
                    } else if (action == 4){
                        System.out.print("Enter country id: ");
                        long countryId = scanner.nextLong();
                        System.out.println("Are you sure you want to delete " + countryService.findCountryById(countryId).getName()
                                + "?[yes/no]");
                        boolean sure = areYouSure();
                        if (!sure){
                            break;
                        }
                        countryService.deleteCountry(countryId);
                    } else if (action == 5){
                        System.out.print("Are you sure you want to clear statistics?[yes/no]");
                        if (!areYouSure()){
                            break;
                        }
                        System.out.print("Type password:");
                        String password = scanner.nextLine();
                        playerService.clearStatistics(true,password);
                    } else if (action == 0){
                        break;
                    }
                    break;
                case 0:
                    return;
            }
        }

    }

    public static boolean areYouSure(){
        Scanner scanner = new Scanner(System.in);
        String sure = scanner.nextLine();
        if (sure.equalsIgnoreCase("yes")){
            return true;
        } else {
            return false;
        }
    }
}
