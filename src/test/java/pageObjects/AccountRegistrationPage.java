package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


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

@FindBy(linkText="Log Out")
WebElement LogOut;


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
public void logOut() {
	LogOut.click();
}	
	

//login data

@FindBy(xpath="//input[@name='username']")
WebElement Username;
public void UserName(String uname) {
	Username.sendKeys(uname);
}
@FindBy(xpath="//input[@name='password']")
WebElement PassWord;
public void PassWord(String pass) {
	PassWord.sendKeys(pass);
}
@FindBy(xpath="//input[@value='Log In']")
WebElement Login;
public void LogIn() {
	Login.click();
}

@FindBy(linkText="Open New Account")
WebElement NewAC;
public void NewAc() {
	NewAC.click();
	}
@FindBy(xpath="//select[@id='type']")
WebElement select;

public void Savings(String Sav) {
	Select sav=new Select(select);
	sav.selectByVisibleText(Sav);
}
@FindBy(xpath="//input[@value='Open New Account']")
WebElement ACC;
public void acc() {
	ACC.click();
}

@FindBy(xpath="Congratulations, your account is now open.")
WebElement confirmationMsg;
public String ConfirmationMsg() {
	try {
		return(confirmationMsg.getText());
	}catch(Exception e) {
		return(e.getMessage());
	}
}

@FindBy(xpath="//a[text()='Accounts Overview']")
WebElement overview;
public void OverView() {
	overview.click();
}

public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());

	}

}


}
