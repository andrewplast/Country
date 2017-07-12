package country.dao;

import country.Country;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class XLSCountryDAOTest {

    private XLSCountryDAO sut;

    @BeforeMethod
    public void canInitClass() throws Exception {
        sut = new XLSCountryDAO();
    }

    @Test
    public void shouldCreateInMermoryCountryDAO() throws Exception {
        assertNotNull(new XLSCountryDAO());
    }
    @Test
    public void shouldAddCountry() {
        Country country = new Country("Add");
        sut.add(country);
        assertTrue(sut.getAll().contains(country));
    }

    @Test
    public void shouldDeleteCountry() {
        Country country = new Country("Россия");
        assertTrue(sut.contains(country));

        sut.delete(country);

        assertFalse(sut.contains(country));
    }

    @Test(dataProvider = "stringWithSubstringForSearch")
    public void shouldFindCountryBySubstring(String substring) {
        assertFalse(sut.find(substring).contains(new Country("test")));
    }

    @Test(dataProvider = "stringDifferentRegister")
    public void shouldFindCountryIgnoreCase(String substring) {
        assertFalse(sut.find(substring).contains(new Country("test")));
    }

    @Test
    public void shouldNotFindCountryWithOtherName() {
        assertFalse(sut.find("FindSearchLong").contains(new Country("FindSearch")));
    }


    @DataProvider(name = "stringWithSubstringForSearch")
    public Object[][] stringWithSubstringForSearch() {
        return new Object[][]{
                {"test"},
                {"tes"},
                {"te"}
        };
    }

    @DataProvider(name = "stringInDifferentRegister")
    public Object[][] stringDifferentRegister() {
        return new Object[][]{
                {"TEST"},
                {"test"},
                {"Test"},
                {"teSt"}
        };
    }

}