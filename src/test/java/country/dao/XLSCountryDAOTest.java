package country.dao;

import static org.junit.Assert.*;

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
    public void create() throws IOException{
        assertNotNull(new XLSCountryDAO());
        assertNotNull(new XLSCountryDAO().getAll());
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
        assertFalse("Метод getAll вернул пустой список", new InMemoryCountryDAO().getAll().isEmpty());
    }

    @Test
    public void add() {
        test.add(new Country(""));
        test.add(new Country("Test"));
        test.add(new Country("New country"));
        test.add(new Country("Very long country name with many words and many charachters"));
        assertFalse("Не найдена страна Test после добавления в список", test.find("Test").isEmpty());
        assertFalse("Не найдена страна TEST после добавления в список", test.find("TEST").isEmpty());
        assertFalse("Не найдена страна test после добавления в список", test.find("test").isEmpty());
        assertFalse("Не найдена страна characters после добавления в список", test.find("charachters").isEmpty());
        assertFalse("Не найдена страна NEW после добавления в список", test.find("NEW").isEmpty());
        assertFalse("Не найдена страна ew после добавления в список", test.find("ew").isEmpty());

        assertTrue("Не найдена страна Wrong, в списке ее не было", test.find("Wrong").isEmpty());
        assertTrue("Не найдена страна WRONG, в списке ее не было", test.find("WRONG").isEmpty());
        assertTrue("Не найдена страна ERROR, в списке ее не было", test.find("ERROR").isEmpty());
    }

    @Test
    public void find() {
        test.add(new Country("Test"));
        test.add(new Country("Second test"));
        assertFalse("Поиск заведомо существующей страны Test вернул пустой список", test.find("Test").isEmpty());
        assertFalse("Поиск заведомо существующей страны Second test вернул пустой список", test.find("second test").isEmpty());
    }
}