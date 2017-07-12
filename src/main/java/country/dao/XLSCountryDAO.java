package country.dao;

import country.Country;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class XLSCountryDAO implements CountryDAO {

    private Collection<Country> countries = new HashSet<>();

    public XLSCountryDAO() throws IOException {
        readXls("Countries.xls");
    }

    public Collection<Country> getAll() {
        return countries;
    }

    public Collection<Country> find(String substring) {
        Collection<Country> result = new HashSet<>();
        for (Country country : countries) {
            if (nameContainsSubstring(country, substring))
                result.add(country);
        }
        return result;
    }

    public void delete(Country country) {
        for (Country c : countries) {
            if (c.getName().toUpperCase().equals(country.getName().toUpperCase())) {
                countries.remove(c);
                break;
            }
        }
    }

    public void add(Country country) {
        if (!contains(country))
            countries.add(country);
    }

    private boolean nameContainsSubstring(Country country, String substring) {
        return country.getName().toUpperCase().contains(substring.toUpperCase());
    }

    private void readXls(String fileName) {
        try {
            tryReadXls(fileName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void tryReadXls(String fileName) throws URISyntaxException, IOException {
        FileInputStream file = new FileInputStream(new File(getClass().getResource("../../" + fileName).toURI()));
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(0);
        readSheet(sheet);
    }

    private void readSheet(Sheet sheet) {
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                add(new Country(cell.getStringCellValue()));
            }
        }
    }

    public boolean contains(Country country) {
        for (Country c : countries) {
            if (c.getName().toUpperCase().equals(country.getName().toUpperCase()))
                return true;
        }
        return false;
    }
}
