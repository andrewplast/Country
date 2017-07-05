package country.dao;

import java.util.Collection;

interface CountryDAO {

    Collection<Country> getAll();

    Collection<Country> find(String substring);

    void delete(Country country);

    void add(Country country);
}
