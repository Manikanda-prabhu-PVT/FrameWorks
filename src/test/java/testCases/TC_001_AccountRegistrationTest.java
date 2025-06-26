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
	public void verify_account_registration() throws IOException
	{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setAddress(randomeString());
		regpage.setCity("Erode");
		regpage.setState("TamilNadu");
		regpage.setPincode("638002");
		regpage.setPhoneNumber("0424-244024");
		regpage.setSSN(randomeString());
		regpage.setUserName(randomeString());
		
		String password=randomAlphaNumeric();
		
		regpage.setPass(password);
		regpage.conPass(password);
		
		String[][] data = {
	            {"First Name", regpage.getFirstName()},
	            {"Last Name", regpage.setLastName()},
	            {"Username", regpage.setAddress()},
	            {"City", regpage.setCity()},
	            {"State", regpage.setState()},
	            {"SSN", regpage.setPincode()},
	            {"SSN", regpage.setPhoneNumber()},
	            {"SSN", regpage.setSSN()},
	            {"SSN", regpage.setUserName()},
	            {"SSN", regpage.setPass()},
	            {"SSN", regpage.conPass()}
	            
	        };

	        // Write to Excel
	        String excelPath = System.getProperty("user.dir") + "\\testdata\\data.xlsx";
	        credentials.writeToExcel(excelPath, data);
		
		
		
		regpage.RegBtn();
		
//		regpage.setPrivacyPolicy();
//		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your account was created successfully. You are now logged in.");
		
	}
	
	
	
	
}








