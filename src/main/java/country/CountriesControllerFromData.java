package country;

import java.util.ArrayList;
import java.util.List;

public class CountriesControllerFromData implements CountryController{
   List<Country> countries = new ArrayList<Country>();
   CountriesControllerFromData() {
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
   public List<Country> getAll() {
      return countries;
   }
   public List<Country> getCountryBySearch(String partName) {
      List<Country> resultOfSearch = new ArrayList<Country>();
      for (Country oneCountryInList: countries) {
         if (constrainPartNameInCountry(oneCountryInList, partName))
            resultOfSearch.add(oneCountryInList);
      }
      return resultOfSearch;
   }
   public void setCountryList(List<Country> setListCountry) {
      countries = setListCountry;
   }
   public void delete(Country deleteCountry) {
      if (countries.contains(deleteCountry)) {
         countries.remove(deleteCountry);
      }
   }
   public void add(Country newCountry) {
      if (!countries.contains(newCountry))
         countries.add(newCountry);
   }
   private boolean constrainPartNameInCountry(Country oneCountryForConstrain, String partOfName) {
      return oneCountryForConstrain.getNameCountry().toUpperCase().contains(partOfName.toUpperCase());
   }
}
