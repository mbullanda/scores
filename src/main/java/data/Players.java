package data;

import dao.PlayerDao;
import model.Player;
import service.PlayerService;

import java.time.LocalDate;

public class Players {
    PlayerService playerService = new PlayerService(new PlayerDao());


    public void initiatePlayers(){
        Player thibautCourtois =
                new Player(1, "Thibaut", "Courtois", LocalDate.of(1992,5,11),
                        0,0, Clubs.realMadrid, Countries.belgium);
        playerService.savePlayer(thibautCourtois);

    }
}
