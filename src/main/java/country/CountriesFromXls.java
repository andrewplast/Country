package country;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.util.*;

public class CountriesFromXls extends Countries {

    CountriesFromXls() throws IOException {
        addCountryInList(new Country(getClass().getResource("Countries.xls")));

        /*FileInputStream file = new FileInputStream(new File("./Countries.xls"));
        HSSFWorkbook workbook = new HSSFWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int cellType = cell.getCellType();
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        addCountryInList(new Country(cell.getStringCellValue()));
                        break;
                }
            }
        }*/
    }
}
