package country;

import country.Country;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CountryTest {
    @Test
    public void shouldGetEqualsNameCountry() throws Exception {
        assertTrue("Test".equals(new Country("Test").getName()));
    }
}