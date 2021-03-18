package controller;

import model.Club;
import model.Coach;
import model.Country;
import service.ClubService;
import service.CoachService;
import service.CountryService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CoachController {

    public static void saveCoach(CoachService coachService, CountryService countryService, ClubService clubService){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter date of birth (yyyyMMdd): ");
        String dateOfBirth = scanner.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate parsedDate = LocalDate.parse(dateOfBirth, dateTimeFormatter);
        System.out.print("Enter club id: ");
        long clubId = scanner.nextLong();
        Club club = clubService.findClubById(clubId);
        System.out.print("Enter country id: ");
        long countryId = scanner.nextLong();
        Country country = countryService.findCountryById(countryId);
        Coach coach = Coach.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(parsedDate)
                .club(club)
                .country(country)
                .build();
        coachService.saveCoach(coach);
    }
}
