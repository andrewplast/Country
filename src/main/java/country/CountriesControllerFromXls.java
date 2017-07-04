package country;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.util.*;

public class CountriesControllerFromXls implements CountryController {
    List<Country> countries = new ArrayList<Country>();
    CountriesControllerFromXls() throws IOException {
       readCountryFromXls("Countries.xls");
    }
    public List<Country> getAll() {
        return countries;
    }
    public List<Country> getCountryBySearch(String partName) {
        List<Country> resultOfSearch = new ArrayList<Country>();
        for (Country oneCountryInList: countries) {
            if (constrainPartNameInCountry(oneCountryInList, partName))
                resultOfSearch.add(oneCountryInList);
        }
        return resultOfSearch;
    }
    public void setCountryList(List<Country> setListCountry) {
        countries = setListCountry;
    }
    public void delete(Country deleteCountry) {
        if (countries.contains(deleteCountry)) {
            countries.remove(deleteCountry);
        }
    }
    public void add(Country newCountry) {
        if (!countries.contains(newCountry))
            countries.add(newCountry);
    }
    private boolean constrainPartNameInCountry(Country oneCountryForConstrain, String partOfName) {
        return oneCountryForConstrain.getNameCountry().toUpperCase().contains(partOfName.toUpperCase());
    }
    void readCountryFromXls(String fileName) {
        try {
            FileInputStream file = new FileInputStream(new File(getClass().getResource("../"+fileName).toURI()));
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            Sheet sheet = workbook.getSheetAt(0);
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
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
