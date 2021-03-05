package data;

import dao.CountryDao;
import model.Country;
import service.CountryService;

public class Countries {
    CountryService countryService = new CountryService(new CountryDao());
    public static Country belgium = new Country("Belgium", 30528,11303528, "BE");
    public static Country spain = new Country("Spain", 505944, 47100396, "ES");
    public static Country brazil = new Country("Brazil", 8515767, 210677000, "BR");
    public static Country france = new Country("France", 643801, 67022000, "FR");
    public static Country germany = new Country("Germany", 357578, 83019200, "DE");
    public static Country croatia = new Country("Croatia", 56594, 4149000, "HR");
    public static Country canada = new Country("Canada", 9984670, 36708083, "CA");
    public static Country russia = new Country("Russia", 17075400, 146238185, "RUS");
    public static Country italy = new Country("Italy", 302073, 60483973, "IT");
    public static Country netherlands = new Country("Netherlands", 41526, 17303291, "NL");

    public void initiateCountries(){
        countryService.saveCountry(spain);
        countryService.saveCountry(brazil);
        countryService.saveCountry(belgium);
        countryService.saveCountry(france);
        countryService.saveCountry(germany);
        countryService.saveCountry(croatia);
        countryService.saveCountry(canada);
        countryService.saveCountry(russia);
        countryService.saveCountry(italy);
        countryService.saveCountry(netherlands);
    }
}
