package country;
import country.*;
import org.junit.Test;
import junit.framework.TestCase;
import static junit.framework.Assert.*;
public class CountriesTest {
    @Test
      public void testCountries() throws Exception {
        Countries test = new Countries();
        test.addCountryInList(new Country("Test"));
        assertEquals(new Country("Test"),test);

      }
}