package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver constructorDriver) {
		super(constructorDriver);
	}

	@FindBy(css = "a.ico-account")
	WebElement myAccountScreenBtn;
	
	@FindBy(linkText = "Change password")
	WebElement ChangePasswordScreenBtn;
	
	@FindBy(id = "OldPassword")
	WebElement OldPasswordTxt;
	
	@FindBy(id = "NewPassword")
	WebElement NewPasswordTxt;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement ConfirmNewPasswordTxt;
	
	@FindBy(css = "input.button-1.change-password-button")
	WebElement ChangePasswordBtn;
	
	@FindBy(className = "result")
	public WebElement changePasswordSuccessMesg;
	
	
	public void openMyAccount()
	{
		//waitUntilLoad(myAccountScreenBtn);
		clickOnButton(myAccountScreenBtn);
		//waitUntilLoad(ChangePasswordScreenBtn);
		clickOnButton(ChangePasswordScreenBtn);
	}
	
	public void changePassword(String oldPass , String newPass)
	{
		setElementTxtBox(OldPasswordTxt, oldPass);
		setElementTxtBox(NewPasswordTxt, newPass);
		setElementTxtBox(ConfirmNewPasswordTxt, newPass);
		clickOnButton(ChangePasswordBtn);
	}
}
