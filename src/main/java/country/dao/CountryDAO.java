package country.dao;

import country.Country;

import java.util.Collection;
import java.util.List;

public interface CountryDAO {

    Collection<Country> getAll();

    Collection<Country> findCountries(String substring);

    void delete(Country country);

    void add(Country country);
}
