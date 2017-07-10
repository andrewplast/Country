package country.dao;

import country.Country;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryCountryDAOTest {

    private InMemoryCountryDAO test;

    @Before
    public void canInitClass() {
        test = new InMemoryCountryDAO();
    }

    @Test
    public void shouldCreateInMemoryCountryDAO() {
        assertNotNull(new InMemoryCountryDAO());
    }

    @Test
    public void shouldDeleteCountry() {
        Country delete = new Country("Test");
        test.add(delete);
        test.delete(delete);
        assertTrue(test.find("Test").isEmpty());
    }

    @Test
    public void shouldGetAllCountries() {
        assertFalse(test.getAll().isEmpty());
    }

    public boolean assertFindCountryBySubstringIgnoreCase() {
        test.add(new Country(""));
        test.add(new Country("TEST"));
        test.add(new Country("New country"));
        return ((test.find("Test").isEmpty()) && (test.find("TEST").isEmpty()) && (test.find("test").isEmpty()) && (test.find("NEW").isEmpty()) && (test.find("ew").isEmpty()));
    }

    public boolean assertAddCountryWithDifferentNameSize() {
        test.add(new Country(""));
        test.add(new Country("Very long country name with many words and many charachters"));
        return (test.find("charachters").isEmpty());
    }

    public boolean assertFindCountryWithoutAdd() {
        return (test.find("Wrong").isEmpty() && test.find("WRONG").isEmpty() && test.find("ERROR").isEmpty());
    }

    @Test
    public void shouldAddCountry() {
        assertFalse(assertAddCountryWithDifferentNameSize());
        assertTrue(assertFindCountryWithoutAdd());
    }

    @Test
    public void shouldFindCountryBySubstringIgnoreCase() {
        assertFalse(assertFindCountryBySubstringIgnoreCase());
    }


}