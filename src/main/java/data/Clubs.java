package data;

import model.Club;
import model.Country;
import service.ClubService;

import java.time.LocalDate;

public class Clubs {
    ClubService clubService;
    public static Club realMadrid;

    public void initiateClubs(){
        realMadrid = new Club("Real Madrid", LocalDate.of(1902,3,6), 13, Countries.spain);
        clubService.saveClub(realMadrid);

    }
}
