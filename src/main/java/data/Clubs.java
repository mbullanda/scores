package data;

import dao.ClubDao;
import lombok.AllArgsConstructor;
import model.Club;
import model.Country;
import service.ClubService;

import java.time.LocalDate;

public class Clubs {
    ClubService clubService = new ClubService(new ClubDao());
    public static Club realMadrid = new Club("Real Madrid", LocalDate.of(1902,3,6), 13, Countries.spain);

    public void initiateClubs(){
        clubService.saveClub(realMadrid);

    }
}
