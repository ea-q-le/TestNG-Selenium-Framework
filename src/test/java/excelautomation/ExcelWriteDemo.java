package excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWriteDemo {

    @Test
    public void writeExcel() throws Exception {
        String path = "./src/test/resources/Countries.xlsx";

        FileInputStream input = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(input);
        Sheet worksheet = workbook.getSheetAt(0);

        //Write column name
        Cell column = worksheet.getRow(0).createCell(2);
        column.setCellValue("Continent");

        Cell continent1 = worksheet.getRow(1).createCell(2);
        continent1.setCellValue("North America");

        //Save changes
        FileOutputStream output = new FileOutputStream(path);
        //Write and save the changes
        workbook.write(output);

        input.close();
        output.close();
        workbook.close();
    }
}
