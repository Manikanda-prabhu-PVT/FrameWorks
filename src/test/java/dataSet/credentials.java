package dataSet;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.AccountRegistrationPage;
import pageObjects.BasePage;

public class credentials extends AccountRegistrationPage{
	public credentials(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	 public static void writeToExcel(String filePath, String[][] data) throws IOException {
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("UserDetails");

	        for (int i = 0; i < data.length; i++) {
	            XSSFRow row = sheet.createRow(i);
	            row.createCell(0).setCellValue(data[i][0]); // Header
	            row.createCell(1).setCellValue(data[i][1]); // Value
	            
	        }
	        FileOutputStream out = new FileOutputStream(filePath);
	        workbook.write(out);
	        workbook.close();
	        out.close();
	 }
	      //1) read data from excel
	 		public static String[][] readExcel(String filePath) throws IOException {
	        String[][] data = new String[2][2]; // 2 rows, 2 columns

	        for (int i = 1; i <= 2; i++) {
	            String data1 = credentials.getCellData(filePath, "Sheet1", i, 0);  // Column A
	            String data2 = credentials.getCellData(filePath, "Sheet1", i, 1);  // Column B

	            data[i - 1][0] = data1;
	            data[i - 1][1] = data2;
	        }

	        return data;
	    }
	       
	      

	 		public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) {
	 		    String cellValue = "";
	 		    try {
	 		        FileInputStream fis = new FileInputStream(filePath);
	 		        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	 		        XSSFSheet sheet = workbook.getSheet(sheetName);
	 		        XSSFRow row = sheet.getRow(rowNum);
	 		        XSSFCell cell = row.getCell(colNum);
	 		       XSSFSheet sheet1 = workbook.getSheet("Sheet1");
			 		if (sheet1 == null) {
			 		    System.out.println("Sheet1 not found in Excel file!");
			 		    return null; // Or throw custom exception
			 		}
	 		        cellValue = cell.toString();  // convert cell to string
	 		        workbook.close();
	 		        fis.close();
	 		    } catch (Exception e) {
	 		        System.out.println("Error reading cell data: " + e.getMessage());
	 		    }

	 		    return cellValue;
	 		   
	 		}
	 		
	}