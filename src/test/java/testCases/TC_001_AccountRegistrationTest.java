package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test
	public void verify_account_registration() throws IOException, InterruptedException
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try
		{
			
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer details...");
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
	       
	            {"Username", "Password"},
	            {regpage.setAddress(),regpage.conPass()}
	            
	        };

	        // Write to Excel
	        String excelPath = System.getProperty("user.dir") + "\\testdata\\data.xlsx";
	        DataProviders.writeToExcel(excelPath, data);
		
		
		
		regpage.RegBtn();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your account was created successfully. You are now logged in.");
		
//		regpage.setPrivacyPolicy();
//		regpage.clickContinue();
		regpage.logOut();
		Thread.sleep(2000);
		logger.info("Test passed");
		} 
		catch (Exception e)
		{
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
		
}}








