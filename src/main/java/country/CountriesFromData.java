package country;

public class CountriesFromData extends Countries {
    CountriesFromData() {
        countryController = new CountriesControllerFromData();
    }
}
