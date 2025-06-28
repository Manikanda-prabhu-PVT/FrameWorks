package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import dataSet.credentials;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test
	public void verify_account_registration() throws IOException, InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setAddress(randomeString());
		regpage.setCity("Chennai");
		regpage.setState("TamilNadu");
		regpage.setPincode("600028");
		regpage.setPhoneNumber("0424-244024");
		regpage.setSSN(randomeString());
		regpage.setUserName(randomeString());
		
		String password=randomAlphaNumeric();
		
		regpage.setPass(password);
		regpage.conPass(password);
		
		String[][] data = {
	       
	            {"Username", regpage.setAddress()},
	            {"Password", regpage.conPass()}
	            
	        };

	        // Write to Excel
	        String excelPath = System.getProperty("user.dir") + "\\testdata\\data.xlsx";
	        credentials.writeToExcel(excelPath, data);
		
		
		
		regpage.RegBtn();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your account was created successfully. You are now logged in.");
//		regpage.setPrivacyPolicy();
//		regpage.clickContinue();
		regpage.logOut();
		Thread.sleep(2000);
		
		
		    String[][] userData = credentials.readExcel(excelPath);

		    // Loop through 2 sets of data
		    for (int i = 0; i < userData.length; i++) {
		        String username = userData[i][0];
		        String password1 = userData[i][1];

		        regpage.UserName(username);
		        regpage.PassWord(password1);
		        regpage.LogIn(); // if you have this method
		    }
		
		

		
		
		
		
		
		
		
	}
	
		
	
	
}








