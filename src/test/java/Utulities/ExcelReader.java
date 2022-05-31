package Utulities;


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class ExcelReader {

    public static String[][] getDataFromExcel(String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Excel/testdata.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        //READING THE ADD CUSTOMER TEST SHEET
        Sheet sheet = wb.getSheet(sheetName);
        //fIGURE OUT HOW MANY ROW AND COLUMN, TO CREATE AN ARRAY
        int totalRows = sheet.getLastRowNum();
        Row rowCells = sheet.getRow(0);
        int totalCols = rowCells.getLastCellNum();
        //ARRAY IS CREATED
        String[][] data = new String[totalRows][totalCols];
        DataFormatter format = new DataFormatter();

        System.out.println("row count is : "+ totalRows+ "col count is : " + totalCols);
        for(int i=1; i<= totalRows; i++){

            for(int j =0; j < totalCols; j++){

                data[i-1][j] =format.formatCellValue(sheet.getRow(i).getCell(j));
            }

        }

        return data;


    }
}
