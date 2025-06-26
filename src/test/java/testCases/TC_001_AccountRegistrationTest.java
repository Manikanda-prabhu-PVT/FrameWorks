package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test
	public void verify_account_registration()
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
		regpage.RegBtn();
		
//		regpage.setPrivacyPolicy();
//		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your account was created successfully. You are now logged in.");
		
	}
	
	
	
	
}








