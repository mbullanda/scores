package service;

import dao.CountryDao;
import lombok.AllArgsConstructor;
import model.Country;

@AllArgsConstructor
public class CountryService {
    private final CountryDao countryDao;

    public void saveCountry (Country country){
        if (countryDao.isCountryPresent(country)){
            System.out.println("Country already present");
        } else {
            countryDao.saveCountry(country);
        }
    }

    public Country findCountryById(Long id){
        return countryDao.findCountryById(id);
    }

    public void displayClubsInCountry(Long countryId){
        countryDao.displayClubsInCountry(countryId);
    }

    public void deleteCountry(Long id){
        if (findCountryById(id) != null){
            countryDao.deleteCountry(id);
        } else {
            System.out.println("Country doesn't exist!");
        }

    }

    public void editCountry(long countryId, int actionEdit) {
        if (findCountryById(countryId) != null){
            countryDao.editCountry(countryId,actionEdit);
        } else {
            System.out.println("Country doesn't exist!");
        }
    }
}
