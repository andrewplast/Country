package country.dao;

import java.util.Collection;

public interface CountryDAO {

    Collection<Country> getAll();

    Collection<Country> findCountries(String substring);

    void delete(Country country);

    void add(Country country);
}
