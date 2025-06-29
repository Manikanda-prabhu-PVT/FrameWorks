package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import dataSet.credentials;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	@Test
	public void loginWithExcelData() throws IOException, InterruptedException {
	    String filePath = System.getProperty("user.dir") + "\\testdata\\data.xlsx";
	    String[][] userData = credentials.readExcel(filePath);

	    AccountRegistrationPage regpage=new AccountRegistrationPage(driver);

	    // Loop through 2 sets of data
	    for (int i = 0; i < userData.length; i++) {
	        String username = userData[i][0];
	        String password = userData[i][1];

	        regpage.UserName(username);
	        regpage.PassWord(password);
	        regpage.LogIn(); // if you have this method
	        Thread.sleep(5000);;
	    }
	}}