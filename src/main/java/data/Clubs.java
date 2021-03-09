package data;

import dao.ClubDao;
import model.Club;
import org.hibernate.cfg.Configuration;
import service.ClubService;

import java.time.LocalDate;

public class Clubs {
    ClubService clubService = new ClubService(new ClubDao(new Configuration().configure().buildSessionFactory()));
    //public static Club realMadrid = new Club("Real Madrid", LocalDate.of(1902,3,6), 13, Countries.spain);
//    public static Club fcBarcelona = new Club("FC Barcelona", LocalDate.of(1899, 11,29), 5, Countries.spain);
//    public static Club interMilan = new Club("Inter Milan", LocalDate.of(1908,3,9), 3, Countries.italy);
//    public static Club juventusFC = new Club("Juventus FC", LocalDate.of(1897, 11, 1), 2, Countries.italy);

    public void initiateClubs(){
        Club realMadrid = Club.builder()
                .name("Real Madrid")
                .dateOfFoundation(LocalDate.of(1902,3,6))
                .trophies(13)
                .build();

        Club fcBarcelona = Club.builder()
                .name("FC Barcelona")
                .dateOfFoundation(LocalDate.of(1899, 11,29))
                .trophies(5)
                .build();

        Club interMilan = Club.builder()
                .name("Inter Milan")
                .dateOfFoundation(LocalDate.of(1908,3,9))
                .trophies(3)
                .build();

        Club juventusFC = Club.builder()
                .name("Juventus FC")
                .dateOfFoundation(LocalDate.of(1897, 11, 1))
                .trophies(2)
                .build();

        clubService.saveClub(realMadrid);
        clubService.saveClub(fcBarcelona);
        clubService.saveClub(interMilan);
        clubService.saveClub(juventusFC);

    }
}
