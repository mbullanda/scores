package controller;

import lombok.AllArgsConstructor;
import model.Player;
import service.PlayerService;

@AllArgsConstructor
public class ConsoleController {
    private final PlayerService playerService;

    public void savePlayer(){
        //scanner i te inne rzeczy dla użytkownika do wczytywania
        playerService.savePlayer(new Player());//w środku jego dane wczytane ze scannera
    }

}
