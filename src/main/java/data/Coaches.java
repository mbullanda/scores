package data;

import dao.CoachDao;
import model.Coach;
import org.hibernate.cfg.Configuration;
import service.CoachService;

import java.time.LocalDate;

public class Coaches {
    CoachService coachService = new CoachService(new CoachDao(new Configuration().configure().buildSessionFactory()));

    public void initiateCoaches(){
        Coach zinedineZidane = Coach.builder()
                .firstName("Zinedine")
                .lastName("Zidane")
                .dateOfBirth(LocalDate.of(1972, 6,23))
                .build();
        coachService.saveCoach(zinedineZidane);
        Coach ronaldKoeman = Coach.builder()
                        .firstName("Ronald")
                        .lastName("Koeman")
                        .dateOfBirth(LocalDate.of(1963,3,21))
                        .build();
        coachService.saveCoach(ronaldKoeman);
        Coach andreaPirlo = Coach.builder()
                .firstName("Andrea")
                .lastName("Pirlo")
                .dateOfBirth(LocalDate.of(1979,5,19))
                .build();
        coachService.saveCoach(andreaPirlo);
        Coach antonioConte = Coach.builder()
                .firstName("Antonio")
                .lastName("Conte")
                .dateOfBirth(LocalDate.of(1969, 7, 31))
                .build();
        coachService.saveCoach(antonioConte);
    }
}
