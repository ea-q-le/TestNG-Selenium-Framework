package excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReadDemo {

    @Test
    public void readXLFile() {
        String path = "C:\\Users\\sgadi\\Desktop\\Cybertek\\JAVAProgramming\\Countries.xlsx";

        Workbook workbook;
        Sheet worksheet;
        Row row;
        Cell cell1, cell2;

        try {
            FileInputStream input = new FileInputStream(path);

            workbook = WorkbookFactory.create(input);
            worksheet = workbook.getSheetAt(0);
            row = worksheet.getRow(0);
            cell1 = row.getCell(0);
            cell2 = row.getCell(1);

            System.out.println(cell1.toString() + " " + cell2.toString());

            int rowsCount = worksheet.getLastRowNum();
            System.out.println(rowsCount);

            for (int i = 1; i <= rowsCount; i++)
                System.out.println(worksheet.getRow(i).getCell(0));

            Map<String, String> countries = new HashMap<>();
            for (int i = 1; i <= rowsCount; i++) {
                String country = worksheet.getRow(i).getCell(0).toString();
                String capital = worksheet.getRow(i).getCell(1).toString();

                countries.put(country, capital);
            }

            System.out.println(countries);

            workbook.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
