package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPage extends PageBase{

	public RegisterationPage(WebDriver constructorDriver) {
		super(constructorDriver);
	}

	@FindBy(id = "gender-male")
	WebElement maleRdoBtn;
	
	@FindBy(id = "gender-female")
	WebElement femaleRdoBtn;
	
	@FindBy(name = "FirstName")
	WebElement fnTxtBox;
	
	@FindBy(name = "LastName")
	WebElement lnTxtBox;
	
	@FindBy(name = "DateOfBirthDay")
	WebElement dayDropdownList;
	
	@FindBy(name = "DateOfBirthMonth")
	WebElement monthDropdownList;
	
	@FindBy(name = "DateOfBirthYear")
	WebElement yearDropdownList;
	
	@FindBy(name = "Email")
	WebElement emailTxtBox;
	
	@FindBy(id = "Company")
	WebElement CompanyTxtBox;
	
	@FindBy(id = "Password")
	WebElement PasswordTxtBox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPasswordTxtBox;
	
	@FindBy(id = "register-button")
	WebElement registerBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMesg;
	
	
	public void userRegisteration(String firstName , String lastName , String email ,
			String password)
	{
		
		clickOnButton(maleRdoBtn);
		
	    setElementTxtBox(fnTxtBox, firstName);
	    setElementTxtBox(lnTxtBox, lastName);
	    setElementTxtBox(emailTxtBox, email);
	    setElementTxtBox(PasswordTxtBox, password);
	    setElementTxtBox(ConfirmPasswordTxtBox, password);
	    
		clickOnButton(registerBtn);
	}
	
	
}
