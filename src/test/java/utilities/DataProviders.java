package utilities;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="data")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\data.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("data",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	//DataProvider 2
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
	//DataProvider 3
	
	//DataProvider 4
}
