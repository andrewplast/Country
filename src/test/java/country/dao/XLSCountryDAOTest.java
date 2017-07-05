package country.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class XLSCountryDAOTest {
    @Test
    public void create() {
        assertNotNull(new InMemoryCountryDAO());
    }

    @Test
    public void delete() {
        InMemoryCountryDAO deleteDAO = new InMemoryCountryDAO();
        try {
            deleteDAO.delete(new Country("Россия"));
        } catch (Exception e) {
            fail("Ошибка удаления объекта" + e.getMessage());
        }
        Country delete = new Country("Test");
        deleteDAO.add(delete);
        deleteDAO.delete(delete);
        assertTrue("Удаленная страна осталась в списке", deleteDAO.find("Test").isEmpty());
    }

    @Test
    public void getAll() {
        assertFalse("Метод getAll вернул пустой список", new InMemoryCountryDAO().getAll().isEmpty());
    }

    @Test
    public void add() {
        InMemoryCountryDAO addTest = new InMemoryCountryDAO();
        addTest.add(new Country("Test"));
        assertFalse("Не найдена страна после добавления в список",addTest.find("Test").isEmpty());
    }

    @Test
    public void find() {
        InMemoryCountryDAO addTest = new InMemoryCountryDAO();
        addTest.add(new Country("Test"));
        assertFalse("Поиск заведомо существующей страны вернул пустой список",addTest.find("Test").isEmpty());
    }
}