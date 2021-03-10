package dbFiller;

import dao.ClubDao;
import dao.CoachDao;
import dao.CountryDao;
import dao.PlayerDao;
import model.Club;
import model.Coach;
import model.Country;
import model.Player;
import org.hibernate.cfg.Configuration;
import service.ClubService;
import service.CoachService;
import service.CountryService;
import service.PlayerService;

import java.time.LocalDate;

public class DbFiller {
    ClubService clubService = new ClubService(new ClubDao(new Configuration().configure().buildSessionFactory()));
    CountryService countryService = new CountryService(new CountryDao(new Configuration().configure().buildSessionFactory()));
    CoachService coachService = new CoachService(new CoachDao(new Configuration().configure().buildSessionFactory()));
    PlayerService playerService = new PlayerService(new PlayerDao(new Configuration().configure().buildSessionFactory()));

    public void dbFiller(){
        Country belgium = Country.builder()
                .name("Belgium")
                .isoCode("BE")
                .surfaceArea(30528)
                .population(11303528)
                .build();
        Country spain = Country.builder()
                .name("Spain")
                .isoCode("ES")
                .surfaceArea(505944)
                .population(47100396)
                .build();
        Country brazil = Country.builder()
                .name("Brazil")
                .isoCode("BR")
                .surfaceArea(8515767)
                .population(210677000)
                .build();
        Country france = Country.builder()
                .name("France")
                .isoCode("FR")
                .surfaceArea(643801)
                .population(67022000)
                .build();
        Country germany = Country.builder()
                .name("Germany")
                .isoCode("DE")
                .surfaceArea(357578)
                .population(83019200)
                .build();
        Country croatia = Country.builder()
                .name("Croatia")
                .isoCode("HR")
                .surfaceArea(56594)
                .population(4149000)
                .build();
        Country canada = Country.builder()
                .name("Canada")
                .isoCode("CA")
                .surfaceArea(9984670)
                .population(36708083)
                .build();
        Country russia = Country.builder()
                .name("Russia")
                .isoCode("RUS")
                .surfaceArea(17075400)
                .population(146238185)
                .build();
        Country italy = Country.builder()
                .name("Italy")
                .isoCode("IT")
                .surfaceArea(302073)
                .population(60483973)
                .build();
        Country netherlands = Country.builder()
                .name("Netherlands")
                .isoCode("NL")
                .surfaceArea(41526)
                .population(17303291)
                .build();

        countryService.saveCountry(spain);
        countryService.saveCountry(brazil);
        countryService.saveCountry(belgium);
        countryService.saveCountry(france);
        countryService.saveCountry(germany);
        countryService.saveCountry(croatia);
        countryService.saveCountry(canada);
        countryService.saveCountry(russia);
        countryService.saveCountry(italy);
        countryService.saveCountry(netherlands);

        Club realMadrid = Club.builder()
                .name("Real Madrid")
                .dateOfFoundation(LocalDate.of(1902,3,6))
                .trophies(13)
                .country(countryService.findCountry(1L))
                .build();
        Club fcBarcelona = Club.builder()
                .name("FC Barcelona")
                .dateOfFoundation(LocalDate.of(1899, 11,29))
                .trophies(5)
                .country(countryService.findCountry(1L))
                .build();
        Club interMilan = Club.builder()
                .name("Inter Milan")
                .dateOfFoundation(LocalDate.of(1908,3,9))
                .trophies(3)
                .country(countryService.findCountry(9L))
                .build();
        Club juventusFC = Club.builder()
                .name("Juventus FC")
                .dateOfFoundation(LocalDate.of(1897, 11, 1))
                .trophies(2)
                .country(countryService.findCountry(9L))
                .build();

        clubService.saveClub(realMadrid);
        clubService.saveClub(fcBarcelona);
        clubService.saveClub(interMilan);
        clubService.saveClub(juventusFC);

        Coach zinedineZidane = Coach.builder()
                .firstName("Zinedine")
                .lastName("Zidane")
                .dateOfBirth(LocalDate.of(1972, 6,23))
                .club(clubService.findClub(1L))
                .country(countryService.findCountry(4L))
                .build();
        Coach ronaldKoeman = Coach.builder()
                .firstName("Ronald")
                .lastName("Koeman")
                .dateOfBirth(LocalDate.of(1963,3,21))
                .club(clubService.findClub(2L))
                .country(countryService.findCountry(10L))
                .build();
        Coach andreaPirlo = Coach.builder()
                .firstName("Andrea")
                .lastName("Pirlo")
                .dateOfBirth(LocalDate.of(1979,5,19))
                .club(clubService.findClub(4L))
                .country(countryService.findCountry(9L))
                .build();
        Coach antonioConte = Coach.builder()
                .firstName("Antonio")
                .lastName("Conte")
                .dateOfBirth(LocalDate.of(1969, 7, 31))
                .club(clubService.findClub(3L))
                .country(countryService.findCountry(9L))
                .build();

        coachService.saveCoach(zinedineZidane);
        coachService.saveCoach(ronaldKoeman);
        coachService.saveCoach(andreaPirlo);
        coachService.saveCoach(antonioConte);

        Player thibautCourtois = Player.builder()
                .firstName("Thibaut")
                .lastName("Courtois")
                .number(1)
                .dateOfBirth(LocalDate.of(1992,5,11))
                .goals(0)
                .assists(0)
                .country(countryService.findCountry(3L))
                .club(clubService.findClub(1L))
                .build();

        playerService.savePlayer(thibautCourtois);



    }

}
