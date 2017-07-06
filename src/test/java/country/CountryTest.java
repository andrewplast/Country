package country;

import country.Country;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CountryTest {
    @Test
    public void getName() throws Exception {
        assertTrue("Имя созданной страны не совпадает с именем в конструкторе", "Test".equals(new Country("Test").getName()));
    }
}