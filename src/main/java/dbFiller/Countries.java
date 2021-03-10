package dbFiller;

import dao.CountryDao;
import model.Country;
import org.hibernate.cfg.Configuration;
import service.CountryService;

public class Countries {
    CountryService countryService = new CountryService(new CountryDao(new Configuration().configure().buildSessionFactory()));
//    public static Country belgium = new Country("Belgium", 30528,11303528, "BE");
//    public static Country spain = new Country("Spain", 505944, 47100396, "ES");
//    public static Country brazil = new Country("Brazil", 8515767, 210677000, "BR");
//    public static Country france = new Country("France", 643801, 67022000, "FR");
//    public static Country germany = new Country("Germany", 357578, 83019200, "DE");
//    public static Country croatia = new Country("Croatia", 56594, 4149000, "HR");
//    public static Country canada = new Country("Canada", 9984670, 36708083, "CA");
//    public static Country russia = new Country("Russia", 17075400, 146238185, "RUS");
//    public static Country italy = new Country("Italy", 302073, 60483973, "IT");
//    public static Country netherlands = new Country("Netherlands", 41526, 17303291, "NL");

    public void initiateCountries(){
        Country belgium = Country.builder()
                .name("Belgium")
                .isoCode("BE")
                .surfaceArea(30528)
                .population(11303528)
                .build();
        Country spain = Country.builder()
                .name("Spain")
                .isoCode("ES")
                .surfaceArea(505944)
                .population(47100396)
                .build();
        Country brazil = Country.builder()
                .name("Brazil")
                .isoCode("BR")
                .surfaceArea(8515767)
                .population(210677000)
                .build();
        Country france = Country.builder()
                .name("France")
                .isoCode("FR")
                .surfaceArea(643801)
                .population(67022000)
                .build();
        Country germany = Country.builder()
                .name("Germany")
                .isoCode("DE")
                .surfaceArea(357578)
                .population(83019200)
                .build();
        Country croatia = Country.builder()
                .name("Croatia")
                .isoCode("HR")
                .surfaceArea(56594)
                .population(4149000)
                .build();
        Country canada = Country.builder()
                .name("Canada")
                .isoCode("CA")
                .surfaceArea(9984670)
                .population(36708083)
                .build();
        Country russia = Country.builder()
                .name("Russia")
                .isoCode("RUS")
                .surfaceArea(17075400)
                .population(146238185)
                .build();
        Country italy = Country.builder()
                .name("Italy")
                .isoCode("IT")
                .surfaceArea(302073)
                .population(60483973)
                .build();
        Country netherlands = Country.builder()
                .name("Netherlands")
                .isoCode("NL")
                .surfaceArea(41526)
                .population(17303291)
                .build();

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
