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
protected 
WebElement txtFirstname;

@FindBy(id="customer.lastName")
protected 
WebElement txtLasttname;

@FindBy(id="customer.address.street") 
protected
WebElement Address;

@FindBy(id="customer.address.city") 
protected
WebElement City;

@FindBy(id="customer.address.state") 
protected
WebElement State;

@FindBy(id="customer.address.zipCode") 
protected
WebElement Pincode;

@FindBy(id="customer.phoneNumber") 
protected
WebElement phoneNumber;

@FindBy(id="customer.ssn") 
protected
WebElement ssn;

@FindBy(id = "customer.username")
protected
WebElement UserName;

@FindBy(id = "customer.password")
protected
WebElement Password;

@FindBy(id = "repeatedPassword")
protected
WebElement CPassword;

@FindBy(xpath="//input[@value='Register']")
protected
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

public String getFirstName() {
    return txtFirstname.getAttribute("value");
}

public String setLastName() {
	return txtLasttname.getAttribute("value");

}

public String setAddress() {
	return Address.getAttribute("value");

}

public String setCity() {
	return City.getAttribute("value");

}

public String setState() {
	return State.getAttribute("value");

}

public String setPincode() {
	return Pincode.getAttribute("value");

}

public String setPhoneNumber() {
	return phoneNumber.getAttribute("value");

}

public String setSSN() {
	return ssn.getAttribute("value");
}	

public String setUserName() {
	return UserName.getAttribute("value");
}	

public String setPass() {
	return Password.getAttribute("value");
}	

public String conPass() {
	return CPassword.getAttribute("value");
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
