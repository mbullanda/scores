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
        System.out.print("Enter number: ");
        int number = scanner().nextInt();
        System.out.print("Enter first name: ");
        String firstName = scanner().nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner().nextLine();
        System.out.print("Enter date of birth (yyyyMMdd): ");
        String dateOfBirth = scanner().nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate parsedDate = LocalDate.parse(dateOfBirth, dateTimeFormatter);
        System.out.print("Enter goals: ");
        int goals = scanner().nextInt();
        System.out.print("Enter assists: ");
        int assists = scanner().nextInt();
        System.out.print("Enter club id: ");
        long clubId = scanner().nextLong();
        Club club = clubService.findClubById(clubId);
        System.out.print("Enter country id: ");
        long countryId = scanner().nextLong();
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

    public void getPLayersByClub(Long clubId){
        clubService.getPlayersByClub(clubId);
    }


    public void saveCoach(){
        coachService.saveCoach(new Coach());
    }
    public void saveClub(){
        clubService.saveClub(new Club());
    }
    public void saveCountry(){
        countryService.saveCountry(new Country());
    }

}
