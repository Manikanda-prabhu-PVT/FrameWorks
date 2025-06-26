package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	

@FindBy(id="customer.firstName") 
WebElement txtFirstname;

@FindBy(id="customer.lastName") 
WebElement txtLasttname;

@FindBy(id="customer.address.street") 
WebElement Address;

@FindBy(id="customer.address.city") 
WebElement City;

@FindBy(id="customer.address.state") 
WebElement State;

@FindBy(id="customer.address.zipCode") 
WebElement Pincode;

@FindBy(id="customer.phoneNumber") 
WebElement phoneNumber;

@FindBy(id="customer.ssn") 
WebElement ssn;

@FindBy(id = "customer.username")
WebElement UserName;

@FindBy(id = "customer.password")
WebElement Password;

@FindBy(id = "repeatedPassword")
WebElement CPassword;

@FindBy(xpath="//input[@value='Register']")
WebElement Registerbtn2;

@FindBy(xpath = "//p[normalize-space()='Your account was created successfully. You are now logged in.']")
WebElement msgConfirmation;


public void setFirstName(String fname) {
	txtFirstname.sendKeys(fname);

}

public void setLastName(String lname) {
	txtLasttname.sendKeys(lname);

}

public void setAddress(String adress) {
	Address.sendKeys(adress);

}

public void setCity(String city) {
	City.sendKeys(city);

}

public void setState(String state) {
	State.sendKeys(state);

}

public void setPincode(String pincode) {
	Pincode.sendKeys(pincode);

}

public void setPhoneNumber(String PNo) {
	phoneNumber.sendKeys(PNo);

}

public void setSSN(String SSN) {
	ssn.sendKeys(SSN);
}	

public void setUserName(String Uname) {
	UserName.sendKeys(Uname);
}	

public void setPass(String NewPass) {
	Password.sendKeys(NewPass);
}	

public void conPass(String conPass) {
	CPassword.sendKeys(conPass);
}

public void RegBtn() {
	Registerbtn2.click();
}



public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());

	}

}
}
