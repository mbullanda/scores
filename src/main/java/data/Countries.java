package data;

import dao.CountryDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Country;
import service.CoachService;
import service.CountryService;

public class Countries {
    CountryService countryService = new CountryService(new CountryDao());
    public static Country belgium = new Country("Belgium", 30528,11303528, "BE");
    public static Country spain = new Country("Spain", 505944, 47100396, "ES");

    public void initiateCountries(){
        countryService.saveCountry(spain);
        Country brazil = new Country("Brazil", 8515767, 210677000, "BR");
        countryService.saveCountry(belgium);
        Country france = new Country("France", 643801, 67022000, "FR");
        Country germany = new Country("Germany", 357578, 83019200, "DE");
        Country croatia = new Country("Croatia", 56594, 4149000, "HR");
        Country canada = new Country("Canada", 9984670, 36708083, "CA");
        Country russia = new Country("Russia", 17075400, 146238185, "RUS");
    }
}
