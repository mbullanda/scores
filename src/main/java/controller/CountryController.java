package controller;

import model.Country;
import service.CountryService;

import java.util.Scanner;

public class CountryController {

    public static void saveCountry(CountryService countryService){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter iso code: ");
        String isoCode = scanner.nextLine();
        System.out.print("Enter population: ");
        int population = scanner.nextInt();
        System.out.print("Enter surface area: ");
        int surfaceArea = scanner.nextInt();
        Country country = Country.builder()
                .name(name)
                .isoCode(isoCode)
                .population(population)
                .surfaceArea(surfaceArea)
                .build();
        countryService.saveCountry(country);
    }
}
