package controller.submenu;

import controller.*;
import lombok.AllArgsConstructor;
import service.ClubService;
import service.CoachService;
import service.CountryService;
import service.PlayerService;

import java.util.Scanner;

@AllArgsConstructor
public class DataOperationsMenu {
    public static ConsoleController consoleController;

    public static void dataOperationsPanel(PlayerService playerService, ClubService clubService, CoachService coachService, CountryService countryService) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; ; i++){
            System.out.println("Welcome in data operations menu. Enter action: ");
            System.out.println("1.Add new...");
            System.out.println("2.Add goals");
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
                        consoleController.savePlayer();
                    } else if (action == 2){
                        consoleController.saveClub();
                    } else if (action == 3){
                        consoleController.saveCoach();
                    } else if (action == 4){
                        consoleController.saveCountry();
                    } else if (action == 0){
                        break;
                    }
                    break;
                case 2:
                    System.out.print("Enter player number: ");
                    int playerNumber = scanner.nextInt();
                    System.out.print("Enter club id: ");
                    long clubId = scanner.nextLong();
                    playerService.addGoal(playerNumber,clubId);
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
                        System.out.println("edit player");
                    } else if (action == 2){
                        System.out.println("edit club");
                    } else if (action == 3){
                        System.out.println("edit coach");
                    } else if (action == 4) {
                        System.out.println("edit country");
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
                        playerNumber = scanner.nextInt();
                        System.out.print("Enter club id: ");
                        clubId = scanner.nextLong();
                        playerService.deletePlayer(playerNumber,clubId);
                    } else if (action == 2){
                        System.out.println("delete club");
                    } else if (action == 3){
                        System.out.println("delete coach");
                    } else if (action == 4){
                        System.out.println("delete country");
                    } else if (action == 5){
                        System.out.print("Are you sure you want to clear statistics?[yes/no]");
                        String sure = scanner.nextLine();
                        boolean areYouSure = false;
                        if (sure.equalsIgnoreCase("yes")){
                            areYouSure = true;
                        } else {
                            break;
                        }
                        System.out.print("Type password:");
                        String password = scanner.nextLine();
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
}
