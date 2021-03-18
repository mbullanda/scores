package controller.submenu;

import model.Club;
import service.ClubService;
import service.CoachService;
import service.CountryService;
import service.PlayerService;

import java.util.Scanner;

public class BrowseMenu {

    public static void browsePanel(PlayerService playerService, CoachService coachService, ClubService clubService, CountryService countryService){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; ; i++){
            System.out.println("Welcome in browse menu. Enter action: ");
            System.out.println("1.Display best scorers/assistants");
            System.out.println("2.View team");
            System.out.println("3.Display clubs by country");
            System.out.println("4.Display coaches by country");
            System.out.println("5.Display players by country");
            System.out.println();
            System.out.println("0.Back");
            int number = scanner.nextInt();

            switch (number) {
                case 1:
                    System.out.println("Enter action:");
                    System.out.println("1.Scorers");
                    System.out.println("2.Assistants");
                    System.out.println();
                    System.out.println("0.Back");
                    int action = scanner.nextInt();
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
                    long clubId = scanner.nextLong();
                    clubService.viewTeam(clubId);
                    break;
                case 3:
                    System.out.print("Enter country id: ");
                    long countryId = scanner.nextLong();
                    countryService.displayClubsInCountry(countryId);
                    break;
                case 4:
                    System.out.print("Enter country id: ");
                    countryId = scanner.nextLong();
                    coachService.displayCoachesByCountryId(countryId);
                    break;
                case 5:
                    System.out.print("Enter country id: ");
                    countryId = scanner.nextLong();
                    playerService.displayPlayersByCountryId(countryId);
                    break;
                case 0:
                    return;
            }
        }
    }
}
