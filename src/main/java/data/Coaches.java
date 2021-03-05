package data;

import dao.CoachDao;
import model.Coach;
import service.CoachService;

import java.time.LocalDate;

public class Coaches {
    CoachService coachService = new CoachService(new CoachDao());

    public void initiateCoaches(){
        Coach zinedineZidane = new Coach("Zinedine", "Zidane", LocalDate.of(1972, 6,23), Clubs.realMadrid, Countries.france);
        coachService.saveCoach(zinedineZidane);
        Coach ronaldKoeman = new Coach("Ronald", "Koeman", LocalDate.of(1963,3,21), Clubs.fcBarcelona, Countries.netherlands);
        coachService.saveCoach(ronaldKoeman);
        Coach andreaPirlo = new Coach("Andrea", "Pirlo", LocalDate.of(1979,5,19), Clubs.juventusFC, Countries.italy);
        coachService.saveCoach(andreaPirlo);
        Coach antonioConte = new Coach("Antonio", "Conte", LocalDate.of(1969, 7, 31), Clubs.interMilan, Countries.italy);
        coachService.saveCoach(antonioConte);
    }
}
