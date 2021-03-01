package controller;

import lombok.AllArgsConstructor;
import model.Club;
import model.Coach;
import model.Player;
import service.ClubService;
import service.CoachService;
import service.PlayerService;

@AllArgsConstructor
public class ConsoleController {
    private final PlayerService playerService;
    private final ClubService clubService;
    private final CoachService coachService;

    public void savePlayer(){
        //scanner i te inne rzeczy dla użytkownika do wczytywania
        playerService.savePlayer(new Player());//w środku jego dane wczytane ze scannera
    }
    public void saveCoach(){
        coachService.saveCoach(new Coach());
    }
    public void saveClub(){
        clubService.saveClub(new Club());
    }

}
