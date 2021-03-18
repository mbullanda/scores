package controller;

import controller.submenu.AddNewMatchMenu;
import controller.submenu.BrowseMenu;
import controller.submenu.DataOperationsMenu;
import controller.submenu.StatisticsMenu;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import service.ClubService;
import service.CoachService;
import service.CountryService;
import service.PlayerService;

import java.util.Scanner;

@AllArgsConstructor
public class ConsoleController {
    private final PlayerService playerService;
    private final ClubService clubService;
    private final CoachService coachService;
    private final CountryService countryService;

    public void savePlayer(){
        PlayerController.savePlayer(playerService,countryService,clubService);
    }

    public void saveCoach(){
        CoachController.saveCoach(coachService, countryService, clubService);
    }

    public void saveClub(){
        ClubController.saveClub(clubService, countryService);
    }

    public void saveCountry(){
        CountryController.saveCountry(countryService);
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
                    BrowseMenu.browsePanel(playerService,coachService,clubService,countryService);
                    break;
                case 2:
                    StatisticsMenu.statisticsPanel();
                    break;
                case 3:
                    DataOperationsMenu.dataOperationsPanel(playerService,clubService,coachService,countryService);
                    break;
                case 4:
                    AddNewMatchMenu.addNewMatchPanel();
                    break;
                case 5:
                    System.out.println("Soon!");
                    break;
                case 0:
                    return;
            }
        }
    }

}
