package main.java.country;

import java.util.*;
import org.json.JSONObject;
import javax.ws.rs.core.Response;

public class Countries {
    private List<Country> countries = new ArrayList<Country>();

    void setCountryList(List<Country> listCountries) {
        countries = listCountries;
    }
    void addCountryInList(Country newCountry) {
        if (!countries.contains(newCountry))
            countries.add(newCountry);
    }
    boolean isCountryInList(Country searchCountry) {
        return countries.contains(searchCountry);
    }
    void deleteCountryFromList(Country deleteCountry) {
        if (countries.contains(deleteCountry)) {
            countries.remove(deleteCountry);
        }
    }
    private boolean constrainPartNameInCountry(Country oneCountryForConstrain, String partOfName) {
        return oneCountryForConstrain.getNameCountry().toUpperCase().contains(partOfName.toUpperCase());
    }
    public List<Country> getCountryBySearch(String partNameCountry) {
        List<Country> resultOfSearch = new ArrayList<Country>();
        for (Country oneCountryInList: countries) {
            if (constrainPartNameInCountry(oneCountryInList, partNameCountry))
                resultOfSearch.add(oneCountryInList);
        }
        return resultOfSearch;
    }
    public List<Country> getAllCountry() {
        return countries;
    }
}