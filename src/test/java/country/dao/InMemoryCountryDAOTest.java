package country.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryCountryDAOTest {

    private InMemoryCountryDAO test;

    @Before
    public void initClass() {
        test = new InMemoryCountryDAO();
    }

    @Test
    public void create() {
        assertNotNull(new InMemoryCountryDAO());
        assertNotNull(new InMemoryCountryDAO().getAll());
    }

    @Test
    public void delete() {
        Country delete = new Country("Test");
        test.add(delete);
        test.delete(delete);
        assertTrue("Удаленная страна осталась в списке", test.find("Test").isEmpty());
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
        assertFalse("Не найдена страна Test после добавления в список",test.find("Test").isEmpty());
        assertFalse("Не найдена страна TEST после добавления в список",test.find("TEST").isEmpty());
        assertFalse("Не найдена страна test после добавления в список",test.find("test").isEmpty());
        assertFalse("Не найдена страна characters после добавления в список",test.find("charachters").isEmpty());
        assertFalse("Не найдена страна NEW после добавления в список",test.find("NEW").isEmpty());
        assertFalse("Не найдена страна ew после добавления в список",test.find("ew").isEmpty());

        assertTrue("Не найдена страна Wrong, в списке ее не было",test.find("Wrong").isEmpty());
        assertTrue("Не найдена страна WRONG, в списке ее не было",test.find("WRONG").isEmpty());
        assertTrue("Не найдена страна ERROR, в списке ее не было",test.find("ERROR").isEmpty());
    }

    @Test
    public void find() {
        test.add(new Country("Test"));
        assertFalse("Поиск заведомо существующей страны вернул пустой список",test.find("Test").isEmpty());
    }


}