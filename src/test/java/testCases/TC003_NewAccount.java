package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC003_NewAccount extends BaseClass{
	@Test
	public void verify_account_registration() throws IOException, InterruptedException{
		
		AccountRegistrationPage page=new AccountRegistrationPage(driver);
		page.UserName("zDWqS");
		page.PassWord("fEb@307");
		page.LogIn();
		page.NewAc();
		page.Savings("SAVINGS");
		page.acc();
		page.ConfirmationMsg();
		page.OverView();
		Thread.sleep(5000);
	
	
	
	
	
	
	
	}
}
