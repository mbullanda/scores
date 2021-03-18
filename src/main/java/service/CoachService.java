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

    public Coach findCoachById(Long id){
        return coachDao.findCoachById(id);
    }

    public void displayCoachesByCountryId(Long id){
        coachDao.displayCoachesByCountryId(id);
    }

    public void deleteCoach(Long id){
        coachDao.deleteCoach(id);
    }

    public void editCoach(Long id, int action){
        coachDao.editCoach(id, action);
    }
}
