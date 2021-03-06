package service;

import dao.ClubDao;
import lombok.AllArgsConstructor;
import model.Club;


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

    public void viewTeam(Long clubId){
        if (clubDao.findClubById(clubId) != null) {
            clubDao.viewTeam(clubId);
        } else {
            System.out.println("Club doesn't exist!");
        }
    }
    public void deleteClub(Long id){
        if (clubDao.findClubById(id) != null){
            clubDao.deleteClub(id);
        } else {
            System.out.println("Club doesn't exist!");
        }
    }

    public void editClub(Long clubId, int action){
        if (clubDao.findClubById(clubId) != null){
            clubDao.editClub(clubId,action);
        } else {
            System.out.println("Club doesn't exist!");
        }
    }

}
