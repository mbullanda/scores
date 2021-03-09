package data;

import dao.PlayerDao;
import model.Player;
import org.hibernate.cfg.Configuration;
import service.PlayerService;

import java.time.LocalDate;

public class Players {
    PlayerService playerService = new PlayerService(new PlayerDao(new Configuration().configure().buildSessionFactory()));


    public void initiatePlayers(){
        Player thibautCourtois = Player.builder()
                .firstName("Thibaut")
                .lastName("Courtois")
                .number(1)
                .dateOfBirth(LocalDate.of(1992,5,11))
                .goals(0)
                .assists(0)
                .build();
        playerService.savePlayer(thibautCourtois);

    }
}
