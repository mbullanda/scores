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

    public void addGoal(int number, Long clubId){
        playerDao.addGoal(number,clubId);
    }

    public void displayBestScorers(){
        playerDao.displayBestScorers();
    }

}
