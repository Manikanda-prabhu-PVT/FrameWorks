package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_LoginTest extends BaseClass{
	
	    @Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
		public void verify_loginDDT(String uname, String pass)
		{
			logger.info("**** Starting TC_002_LoginTest *****");
			
			try {
	    AccountRegistrationPage regpage=new AccountRegistrationPage(driver);

	    

	        regpage.UserName(uname);
	        regpage.PassWord(pass);
	        regpage.LogIn(); // if you have this method
	        Thread.sleep(5000);;
			}
			catch(Exception e)
			{
				Assert.fail("An exception occurred: " + e.getMessage());
			}
				
			logger.info("**** Finished TC_003_LoginDDT *****");
	    
	}}