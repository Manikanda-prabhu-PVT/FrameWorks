package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
public class ExcelUtility {
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    //for write value
    public static void writeToExcel(String filePath, String[][] data) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        for (int i = 0; i < data.length; i++) {
            XSSFRow row = sheet.createRow(i);
            for (int j = 0; j < data[i].length; j++) {
                XSSFCell cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }

        workbook.close();
        System.out.println("Excel written successfully at: " + filePath);
    }



    //for read and write value
    public ExcelUtility(String path, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        
        if (sheet == null) {
            throw new IOException("Sheet '" + sheetName + "' not found in Excel file: " + path);
        }
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    public String getCellData(int row, int col) {
        XSSFRow currentRow = sheet.getRow(row);
        if (currentRow == null) return "";
        XSSFCell cell = currentRow.getCell(col);
        if (cell == null) return "";
        return cell.toString();
        
    }
    

    
    
}

