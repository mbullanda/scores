package dao;

import model.Player;

public class PlayerDao {
    public boolean isPlayerPresent(Player player) {
        //sprawdza czy piłkarz już istnieje
        return false;
    }

    public void savePlayer(Player player) {
        //save to db
        System.out.println("Saving player: " + player);
    }
}
