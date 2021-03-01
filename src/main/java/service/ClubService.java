package service;

import dao.ClubDao;
import lombok.AllArgsConstructor;
import model.Club;


@AllArgsConstructor
public class ClubService {
    private final ClubDao clubDao;

    public void saveClub(Club club){
        if (clubDao.isClubPresent(club)){
            System.out.println("Club already present");
        } else {
            clubDao.saveClub(club);
        }
    }

}
