package service;

import dao.PlayerDao;
import lombok.AllArgsConstructor;
import model.Player;

@AllArgsConstructor
public class PlayerService {
    private final PlayerDao playerDao;

    public void savePlayer(Player player) {
        if (playerDao.isPlayerPresent(player)){
            System.out.println("Player already present");
        } else {
            playerDao.savePlayer(player);
        }
    }

    public Player findPlayerById(Long id){
        return playerDao.findPlayerById(id);
    }

    public Player findPlayerByNumberAndClubId(int number, Long clubId){
        return playerDao.findPlayerByNumberAndClubId(number,clubId);
    }

    public void addGoal(int number, Long clubId){
        if (findPlayerByNumberAndClubId(number,clubId) != null){
            playerDao.addGoal(number,clubId);
        } else {
            System.out.println("Player doesn't exist!");
        }
    }

    public void displayBestScorers(){
        playerDao.displayBestScorers();
    }

    public void displayBestAssistants(){
        playerDao.displayBestAssistants();
    }

    public void clearStatistics(boolean sure, String password){
        playerDao.clearStatistics(sure,password);
    }

    public void deletePlayer(int number, Long clubId){
        if (findPlayerByNumberAndClubId(number,clubId) != null){
            playerDao.deletePlayer(number,clubId);
        } else {
            System.out.println("Player doesn't exist!");
        }
    }

    public void editPlayer(int number, Long clubId, int action){
        if (findPlayerByNumberAndClubId(number,clubId) != null){
            playerDao.editPlayer(number,clubId,action);
        } else {
            System.out.println("Player doesn't exist!");
        }
    }

}
