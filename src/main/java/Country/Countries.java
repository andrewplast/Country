package main.java.Country;

import java.util.*;
import org.json.JSONObject;
import javax.ws.rs.core.Response;

public class Countries {
    private List<Country> countries = new ArrayList<Country>();

    Countries(){
        countries.add(new Country("Россия"));
        countries.add(new Country("Россия"));
        countries.add(new Country("Россия"));
        countries.add(new Country("Россия"));
        countries.add(new Country("Украина"));
        countries.add(new Country("США"));
        countries.add(new Country("Англия"));
        countries.add(new Country("Германия"));
        countries.add(new Country("Франция"));
        countries.add(new Country("Бразилия"));
        countries.add(new Country("Мексика"));
        countries.add(new Country("Казахстан"));
        countries.add(new Country("Китай"));
        countries.add(new Country("Въетнам"));
        countries.add(new Country("Италия"));
        countries.add(new Country("Испания"));
        countries.add(new Country("Турция"));
        countries.add(new Country("Греция"));
        countries.add(new Country("Япония"));
        countries.add(new Country("Австралия"));
        countries.add(new Country("Индия"));
    }

    void addCountyInList(String NameNewCountry) {
        Country NewCountry = new Country(NameNewCountry);
        if (!countries.contains(NewCountry))
            countries.add(NewCountry);
    }

    Response JSONDefaultListCountry() {
        return JSONResultSearchCountry(getCountryList());
    }

    Response JSONSearchListCountry(String partName) {
        return JSONResultSearchCountry(searchCountryInList(partName));
    }
    private Response JSONResultSearchCountry(List<Country> CountryForResponse) {
        JSONObject JSONCountryList = new JSONObject();
        for (Country OneCountryInResult: CountryForResponse) {
            JSONCountryList.put(Integer.toString(OneCountryInResult.getKeyValue()), OneCountryInResult.getNameCountry());
        }
        return Response.status(Response.Status.OK).entity(JSONCountryList.toString()).build();
    }

    private List<Country> searchCountryInList(String PartNameOfCountry) {
        List<Country> resultOfSearch = new ArrayList<Country>();
        for (Country OneCountryInList: countries)
        {
            if (ConstrainPartNameInCountry(OneCountryInList, PartNameOfCountry))
                resultOfSearch.add(OneCountryInList);
        }
        return resultOfSearch;
    }

    private List<Country> getCountryList() {
        return countries;
    }

    private boolean ConstrainPartNameInCountry(Country OneCountryForConstrain, String PartOfName) {
        return OneCountryForConstrain.getNameCountry().toUpperCase().contains(PartOfName.toUpperCase());
    }
}