package service;

import dao.ClubDao;
import lombok.AllArgsConstructor;
import model.Club;
import model.Player;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@AllArgsConstructor
public class ClubService {
    private final ClubDao clubDao;

    public void saveClub(Club club){
        if (clubDao.isClubPresent(club)){
            System.out.println("Club already present!");
        } else {
            clubDao.saveClub(club);
        }
    }

    public Club findClubById(Long id){
        return clubDao.findClubById(id);
    }

    public void getPlayersByClub(Long clubId){
        if (clubDao.findClubById(clubId) != null) {
            clubDao.getPlayersByClub(clubId);
        } else {
            System.out.println("Club doesn't exists!");
        }
    }

}
