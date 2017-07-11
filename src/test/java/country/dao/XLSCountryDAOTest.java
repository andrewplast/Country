package country.dao;

import country.Country;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class XLSCountryDAOTest {

    private XLSCountryDAO countries;

    @BeforeMethod
    public void setUp() throws Exception {
        countries = new XLSCountryDAO();
    }

    @Test
    public void shouldCreateXLSCountryDAO() throws IOException {
        assertNotNull(new XLSCountryDAO());
    }

    @Test
    public void shouldGetAllCountries() {
        assertFalse(countries.getAll().isEmpty());
    }

    @DataProvider(name = "addCountryDataProvider")
    public Object[][] addCountryProvider() {
        return new Object[][]{
                {"TEST", "TES"},
                {"test", "TEST"},
                {"New country", "New"},
                {"Very long country name with many words and many charachters", "LONG"},
                {"Add countryName with Name", "name"}
        };
    }

    @Test(dataProvider = "addCountryDataProvider")
    public void shouldAddCountry(String nameCountry, String searchSubstring) {
        countries.add(new Country(nameCountry));
        assertFalse(countries.find(searchSubstring).isEmpty());
    }

    @DataProvider(name = "deleteCountryDataProvider")
    public Object[][] deleteCountryProvider() {
        return new Object[][]{
                {"TEST"},
                {"test"},
                {"New country"},
                {"Very long country name with many words and many charachters"},
                {"Add countryName with Name"}
        };
    }

    @Test(dataProvider = "deleteCountryDataProvider")
    public void shouldDeleteCountry(String nameCountry) {
        Country delete = new Country(nameCountry);
        countries.add(delete);
        countries.delete(delete);
        assertTrue(countries.find(nameCountry).isEmpty());
    }

    @DataProvider(name = "findCountryBySubstring")
    public Object[][] findCountryBySubstringProvider() {
        return new Object[][]{
                {"TEST", "TE"},
                {"test", "est"},
                {"New country", "new"},
                {"Very long country name with many words and many charachters", "long"},
                {"Add countryName with Name", "with Name"}
        };
    }

    @Test(dataProvider = "findCountryBySubstring")
    public void shouldFindCountryBySubstring(String nameCountry, String substring) {
        countries.add(new Country(nameCountry));
        assertFalse(countries.find(substring).isEmpty());
    }

    @DataProvider(name = "findCountryIgnoreCase")
    public Object[][] findCountryIgnoreCaseProvider() {
        return new Object[][]{
                {"TEST", "te"},
                {"test", "TEST"},
                {"New country", "nEW COUNTRY"},
                {"Very long country name with many words and many charachters", "CHARACHTERS"},
                {"Add countryName with Name", "nAME WITH nAME"}
        };
    }

    @Test(dataProvider = "findCountryIgnoreCase")
    public void shouldFindCountryIgnoreCase(String nameCountry, String substring) {
        countries.add(new Country(nameCountry));
        assertFalse(countries.find(substring).isEmpty());
    }

}