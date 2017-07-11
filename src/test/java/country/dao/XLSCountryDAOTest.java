package country.dao;

import country.Country;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class XLSCountryDAOTest {

    private XLSCountryDAO countries;

    @BeforeMethod
    public void canInitClass() throws Exception {
        countries = new XLSCountryDAO();
    }

    @Test
    public void shouldCreateInMermoryCountryDAO() throws Exception {
        assertNotNull(new XLSCountryDAO());
    }

    @Test
    public void shouldGetAllCountries() {
        assertFalse(countries.getAll().isEmpty());
    }

    @Test()
    public void shouldAddCountry() {
        Country add = new Country("Add");
        countries.add(add);
        assertTrue(countries.getAll().contains(add));
    }

    @Test()
    public void shouldDeleteCountry() {
        Country delete = new Country("Delete");
        countries.add(delete);
        countries.delete(delete);
        assertFalse(countries.getAll().contains(delete));
    }

    @DataProvider(name = "stringWithSubstringForSearch")
    public Object[][] stringWithSubstringForSearch() {
        return new Object[][]{
                {"TEST", "TE"},
                {"test", "est"},
                {"Test", "Test"}
        };
    }

    @Test(dataProvider = "stringWithSubstringForSearch")
    public void shouldFindCountryBySubstring(String nameCountry, String substring) {
        countries.add(new Country(nameCountry));
        assertFalse(countries.find(substring).contains(new Country(nameCountry)));
    }

    @DataProvider(name = "stringInDifferentRegister")
    public Object[][] stringDifferentRegister() {
        return new Object[][]{
                {"TEST", "test"},
                {"test", "TEST"},
                {"Test", "tEST"}
        };
    }

    @Test(dataProvider = "stringDifferentRegister")
    public void shouldFindCountryIgnoreCase(String nameCountry, String substring) {
        countries.add(new Country(nameCountry));
        assertFalse(countries.find(substring).contains(new Country(nameCountry)));
    }

    @Test()
    public void shouldNoFindCountryWithOtherName() {
        countries.add(new Country("FindSearch"));
        assertFalse(countries.find("FindSearchLong").contains(new Country("FindSearch")));
    }

}