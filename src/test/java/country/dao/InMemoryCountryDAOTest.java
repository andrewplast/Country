package country.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryCountryDAOTest {

    private InMemoryCountryDAO test;

    @Before
    public void initClass() {
        InMemoryCountryDAO test = new InMemoryCountryDAO();
    }

    @Test
    public void create() {
        assertNotNull(new InMemoryCountryDAO());
    }

    @Test
    public void delete() {
        try {
            test.delete(new Country("Россия"));
        } catch (Exception e) {
            fail("Ошибка удаления объекта: " + e.getMessage());
        }
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
        test.add(new Country("Test"));
        assertFalse("Не найдена страна после добавления в список",test.find("Test").isEmpty());
    }

    @Test
    public void find() {
        test.add(new Country("Test"));
        assertFalse("Поиск заведомо существующей страны вернул пустой список",test.find("Test").isEmpty());
    }


}