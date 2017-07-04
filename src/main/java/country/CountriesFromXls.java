package country;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.util.*;

public class CountriesFromXls extends Countries {

    CountriesFromXls() throws IOException {
       readCountryFromXls("Countries.xls");
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
                    addCountryInList(new Country(cell.getStringCellValue()));
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
