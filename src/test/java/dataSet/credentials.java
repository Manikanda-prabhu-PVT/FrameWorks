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
	}