package country.dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryCountryDAOTest {
    @Test
    public void createCountries() {
        assertNotNull(new InMemoryCountryDAO());
    }

    @Test
    public void delete() {
        InMemoryCountryDAO deleteTest = new InMemoryCountryDAO();
        try {
            deleteTest.delete(new Country("Россия"));
        } catch (Exception e) {
            fail("Ошибка удаления объекта");
        }
        Country delete = new Country("Test");
        deleteTest.add(delete);
        deleteTest.delete(delete);
        assertTrue("Удаленная страна осталась в списке", deleteTest.findCountries("Test").isEmpty());
    }

    @Test
    public void getAll() {
        assertFalse("Метод getAll вернул пустой список", new InMemoryCountryDAO().getAll().isEmpty());
    }

    @Test
    public void add() {
        InMemoryCountryDAO addTest = new InMemoryCountryDAO();
        addTest.add(new Country("Test"));
        assertFalse("Не найдена страна после добавления в список",addTest.findCountries("Test").isEmpty());
    }

    @Test
    public void findCountry() {
        InMemoryCountryDAO addTest = new InMemoryCountryDAO();
        addTest.add(new Country("Test"));
        assertFalse("Поиск заведомо существующей страны вернул пустой список",addTest.findCountries("Test").isEmpty());
    }


}