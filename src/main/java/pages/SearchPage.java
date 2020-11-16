package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver constructorDriver) {
		super(constructorDriver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "small-searchterms")
	WebElement searchTxtBox;
	
	@FindBy(css = "input.button-1.search-box-button")
	WebElement searchBtn;

	@FindBy(id = "ui-id-1")
	List<WebElement> productSuggest;
	
	// motaz changed css locator to be product name which is apple 13inch
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	public void productSearch(String productName)
	{
		setElementTxtBox(searchTxtBox, productName);
		clickOnButton(searchBtn);
	}
	
	public void openProductDetails()
	{
		clickOnButton(productTitle);
	}
	
	public void productSearchUsingAutoSuggest(String abbrevationForProductName)
	{
		setElementTxtBox(searchTxtBox, abbrevationForProductName);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productSuggest.get(0).click();
	}
}
