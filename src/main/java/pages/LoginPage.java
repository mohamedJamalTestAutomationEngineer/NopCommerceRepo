package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver constructorDriver) {
		super(constructorDriver);
	}
	
	@FindBy(id = "Email")
	WebElement emailTxtBox;
	
	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	
	@FindBy(css = "input.button-1.login-button")
	WebElement loginBtn;
	
	@FindBy(css = "a.ico-logout")
	public WebElement logOutBtn;
	
	public void userLogin(String email , String password)
	{
		setElementTxtBox(emailTxtBox, email);
		setElementTxtBox(passwordTxtBox, password);
		clickOnButton(loginBtn);
	}
	
	
	public void registeredUserLogOut()
	{
		//waitUntilLoad(logOutBtn);
		clickOnButton(logOutBtn);
	}

}
