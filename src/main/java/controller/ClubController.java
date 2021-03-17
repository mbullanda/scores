package controller;

import model.Club;
import model.Country;
import service.ClubService;
import service.CountryService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClubController {

    public void saveClub(ClubService clubService, CountryService countryService){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter date of foundation (yyyyMMdd): ");
        String dateOfFoundation = scanner.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate parsedDate = LocalDate.parse(dateOfFoundation, dateTimeFormatter);
        System.out.print("Enter amount of trophies: ");
        int trophies = scanner.nextInt();
        System.out.print("Enter country id: ");
        long countryId = scanner.nextLong();
        Country country = countryService.findCountryById(countryId);
        Club club = Club.builder()
                .name(name)
                .dateOfFoundation(parsedDate)
                .trophies(trophies)
                .country(country)
                .build();
        clubService.saveClub(club);
    }
}
