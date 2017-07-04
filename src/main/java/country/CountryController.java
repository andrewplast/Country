package country;

import java.util.List;

public interface CountryController {
        public List<Country> getAll();
        public List<Country> getCountryBySearch(String partName);
        public void setCountryList(List<Country> setListCountry);
        public void delete(Country deleteCountry);
        public void add(Country newCountry);
}
