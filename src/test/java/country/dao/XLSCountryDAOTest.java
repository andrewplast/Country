package country.dao;

import static org.junit.Assert.*;

import country.Country;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class XLSCountryDAOTest{

    private XLSCountryDAO test;

    @Before
    public void initClass() throws IOException {
        test = new XLSCountryDAO();
    }

    @Test
    public void create() throws IOException  {
        assertNotNull(new XLSCountryDAO());
    }

    @Test
    public void delete() {
        Country delete = new Country("Test");
        test.add(delete);
        test.delete(delete);
        assertTrue("Удаленная страна " + delete.getName() + " осталась в списке", test.find("Test").isEmpty());
    }

    @Test
    public void getAll() {
        assertFalse("Метод getAll вернул пустой список", test.getAll().isEmpty());
    }

    public boolean assertFindCountry() {
        test.add(new Country(""));
        test.add(new Country("TEST"));
        test.add(new Country("New country"));
        return ((test.find("Test").isEmpty()) && (test.find("TEST").isEmpty()) && (test.find("test").isEmpty()) && (test.find("NEW").isEmpty()) && (test.find("ew").isEmpty()));
    }

    public boolean assertAddSizeNameCountry() {
        test.add(new Country(""));
        test.add(new Country("Very long country name with many words and many charachters"));
        return (test.find("charachters").isEmpty());
    }

    public boolean assertNoAddCountry() {
        return (test.find("Wrong").isEmpty() && test.find("WRONG").isEmpty() && test.find("ERROR").isEmpty());
    }

    @Test
    public void add() {
        assertFalse("Проверка добавления стран с длинным и коротким названием", assertAddSizeNameCountry());
        assertTrue("Найдена страна, которая не была добавлены в список", assertNoAddCountry());
    }

    @Test
    public void find() {
        assertFalse("После добавления страны не работает регистронезависимый поиск", assertFindCountry());
    }
}