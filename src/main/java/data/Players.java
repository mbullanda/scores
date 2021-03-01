package data;

import model.Club;
import model.Player;
import service.PlayerService;

import java.time.LocalDate;

public class Players {
    private PlayerService playerService;

    public void initiatePlayers(){
        Player thibautCourtois =
                new Player(1, "Thibaut", "Courtois", LocalDate.of(1992,5,11),
                        0,0, Clubs.realMadrid, Countries.belgium);
        playerService.savePlayer(thibautCourtois);

    }
}
