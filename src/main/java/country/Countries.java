package country;
import java.util.*;

public abstract class Countries {
    CountryController countryController;

    public void setCountryList(List<Country> listCountries) {
        countryController.setCountryList(listCountries);
    }
    public List<Country> getAll() {
        return countryController.getAll();
    }
    public List<Country> getCountryBySearch(String partName) {
        return countryController.getCountryBySearch(partName);
    }
    public void delete(Country deleteCountry) {
        countryController.delete(deleteCountry);
    }
    public void add(Country newCountry) {
        countryController.add(newCountry);
    }
}