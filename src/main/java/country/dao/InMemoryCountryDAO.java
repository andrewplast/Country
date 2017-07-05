package country.dao;

import java.util.Collection;
import java.util.HashSet;

public class InMemoryCountryDAO implements CountryDAO {

    private Collection<Country> countries = new HashSet<>();

    public InMemoryCountryDAO() {
        add(new Country("Россия"));
        add(new Country("Россия"));
        add(new Country("Россия"));
        add(new Country("Россия"));
        add(new Country("Украина"));
        add(new Country("США"));
        add(new Country("Англия"));
        add(new Country("Германия"));
        add(new Country("Франция"));
        add(new Country("Бразилия"));
        add(new Country("Мексика"));
        add(new Country("Казахстан"));
        add(new Country("Китай"));
        add(new Country("Въетнам"));
        add(new Country("Италия"));
        add(new Country("Испания"));
        add(new Country("Турция"));
        add(new Country("Греция"));
        add(new Country("Япония"));
        add(new Country("Австралия"));
        add(new Country("Индия"));
    }

    public Collection<Country> getAll() {
        return countries;
    }

    public Collection<Country> find(String substring) {
        Collection<Country> result = new HashSet<>();
        for (Country country : countries) {
            if (nameContainsSubstring(country, substring))
                result.add(country);
        }
        return result;
    }

    public void delete(Country country) {
        countries.remove(country);
    }

    public void add(Country country) {
        if (!countries.contains(country))
            countries.add(country);
    }

    private boolean nameContainsSubstring(Country country, String substring) {
        return country.getName().toUpperCase().contains(substring.toUpperCase());
    }
}
