package controller;

import model.Club;
import model.Country;
import model.Player;
import service.ClubService;
import service.CountryService;
import service.PlayerService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PlayerController {

    public void savePlayer(PlayerService playerService, CountryService countryService, ClubService clubService){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scanner.nextInt();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter date of birth (yyyyMMdd): ");
        String dateOfBirth = scanner.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate parsedDate = LocalDate.parse(dateOfBirth, dateTimeFormatter);
        System.out.print("Enter goals: ");
        int goals = scanner.nextInt();
        System.out.print("Enter assists: ");
        int assists = scanner.nextInt();
        System.out.print("Enter club id: ");
        long clubId = scanner.nextLong();
        Club club = clubService.findClubById(clubId);
        System.out.print("Enter country id: ");
        long countryId = scanner.nextLong();
        Country country = countryService.findCountryById(countryId);
        Player player = Player.builder()
                .number(number)
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(parsedDate)
                .assists(assists)
                .goals(goals)
                .club(club)
                .country(country)
                .build();
        playerService.savePlayer(player);
    }
}
