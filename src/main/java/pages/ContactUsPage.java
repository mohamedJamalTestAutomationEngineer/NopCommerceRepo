package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver constructorDriver) {
		super(constructorDriver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(name = "FullName")
	WebElement fullNameTxt;
	
	@FindBy(name = "Email")
	WebElement emailTxt;
	
	@FindBy(name = "Enquiry")
	WebElement enquiryTxt;
	
	@FindBy(name = "send-email")
	WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMessg;
	
	public void ContactUs(String fullname , String email , String message)
	{
		setElementTxtBox(fullNameTxt, fullname);
		setElementTxtBox(emailTxt, email);
		setElementTxtBox(enquiryTxt, message);
		clickOnButton(submitBtn);
	}
}
