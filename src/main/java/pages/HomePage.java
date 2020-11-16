package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


// in this class , we can add different buttons in the homepage like search , register
public class HomePage extends PageBase{

	public HomePage(WebDriver constructorDriver) {
		super(constructorDriver);
		jse = (JavascriptExecutor) constructorDriver;
		actionBuilder = new Actions(constructorDriver);
	}
    
	@FindBy(linkText = "Register")
	public WebElement registerScreenBtn;
	
	@FindBy(linkText = "Log in")
	public WebElement loginScreenBtn;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsScreenBtn;
	
	@FindBy(id = "customerCurrency")
	WebElement selectCustomerCurrency;
	
	@FindBy(xpath = "/html/body/div[7]/div[2]/ul[1]/li[1]/a")
	WebElement computersMenu;
	
	@FindBy(linkText = "Notebooks")
	WebElement NotebooksButtonInMenu;
	
	public void openRegisterationScreen()
	{
		//waitForElementToBeClickable(registerScreenBtn);
		clickOnButton(registerScreenBtn);
	}
	
	public void openLoginScreen()
	{
		clickOnButton(loginScreenBtn);
	}
	
	public void openContactUsPage()
	{
		scrollTo();
		clickOnButton(contactUsScreenBtn);
	}
	
	public void changeCustomerCurrency()
	{
		selectOptions = new Select(selectCustomerCurrency);
		selectOptions.selectByVisibleText("Euro");
	}
	
	public void selectNoteBooksFromMainMenu()
	{
		actionBuilder.moveToElement(computersMenu).moveToElement(NotebooksButtonInMenu).click().build().perform();
	}
}
