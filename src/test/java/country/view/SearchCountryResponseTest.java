package country.view;

import country.dao.InMemoryCountryDAO;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchCountryResponseTest {
    @Test
    public void testResponse() {
        InMemoryCountryDAO testDAO = new InMemoryCountryDAO();
        assertNotNull(country.view.SearchCountryResponse.getResponse(testDAO.getAll()));
    }
}