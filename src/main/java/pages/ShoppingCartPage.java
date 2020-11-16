package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver constructorDriver) {
		super(constructorDriver);
	}

	@FindBy(name = "removefromcart")
	WebElement removeProductFromShoppingCart;
	
	@FindBy(name = "updatecart")
	WebElement updateShoppingCart;
	
	@FindBy(css = "input.qty-input.valid")
	WebElement quantityTxt;
	
	@FindBy(css = "td.subtotal")
	public WebElement totalLabel;
	
	@FindBy(css = "a.product-name")
	public WebElement productColumn;
	
	@FindBy(id = "termsofservice")
	WebElement agreeCheckBox;
	
	@FindBy(id = "checkout")
	WebElement checkOutBtn;
	
	@FindBy(css = "div.no-data")
	public WebElement removeMessage;
	
	public void updateProductQtyInShoppingCart(String value)
	{
		// value should be integer not string but I make data type of value as string to be used later with method
		// setElementTxtBox
		clearTxtBox(quantityTxt);
		setElementTxtBox(quantityTxt, value);
		clickOnButton(updateShoppingCart);
	}
	
	public void removeProductFromCart()
	{
		//waitForElementToBeClickable(removeProductFromShoppingCart);
		clickOnButton(removeProductFromShoppingCart);
		
		//waitForElementToBeClickable(updateShoppingCart);
		clickOnButton(updateShoppingCart);
	}
	
	public void openCheckOutPage()
	{
		clickOnButton(agreeCheckBox);
		clickOnButton(checkOutBtn);
	}
	
}
