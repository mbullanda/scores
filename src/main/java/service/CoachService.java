package service;

import dao.CoachDao;
import lombok.AllArgsConstructor;
import model.Coach;

@AllArgsConstructor
public class CoachService {
    private final CoachDao coachDao;


    public void saveCoach(Coach coach) {
        if (coachDao.isCoachPresent(coach)){
            System.out.println("Coach already present");
        } else {
            coachDao.saveCoach(coach);
        }
    }
}
