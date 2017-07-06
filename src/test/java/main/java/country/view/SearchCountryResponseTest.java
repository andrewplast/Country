package main.java.country.view;

import country.dao.InMemoryCountryDAO;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchCountryResponseTest {
    @Test
    public void testResponse() {
        InMemoryCountryDAO testDAO = new InMemoryCountryDAO();
        assertNotNull(main.java.country.view.SearchCountryResponse.getResponse(testDAO.getAll()));
    }
}