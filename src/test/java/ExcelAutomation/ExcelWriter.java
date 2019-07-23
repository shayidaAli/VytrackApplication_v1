package ExcelAutomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWriter {
    @Test
    public void writeExcel() throws Exception {
        String filePath = "/Users/syd/Downloads/testng-selenium-framework/src/test/resources/Countries.xlsx";

        FileInputStream in = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(in);
        Sheet worksheet = workbook.getSheetAt(0);

        //Write column name
        Cell column = worksheet.getRow(0).getCell(2);

        if(column == null){
            column = worksheet.getRow(0).createCell(2);
        }
        column.setCellValue("Continent");


        Cell cont1 = worksheet.getRow(1).getCell(2);
        if (cont1 == null) {
            cont1 = worksheet.getRow(1).createCell(2);
        }
        cont1.setCellValue("North America");

        //Save changes
        //Open the file to WRITE into it
        FileOutputStream out = new FileOutputStream(filePath);
        //Write and save the changes
        workbook.write(out);

        out.close();
        workbook.close();
        in.close();



    }
}
