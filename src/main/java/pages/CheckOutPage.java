package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver constructorDriver) {
		super(constructorDriver);
	}

	@FindBy(css = "input.button-1.checkout-as-guest-button")
	WebElement checkOutGuestBtn;
	
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement fnTxt;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lnTxt;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTxt;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryList;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;

	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxt;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addressTxt;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postCodeTxt;

	// fill Xpath value
	@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/input")
	WebElement continueBtn;

	@FindBy(id = "shippingoption_1")
	WebElement shippingMethodRDO;

	// fill Xpath value
	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement continueShippingBtn;

	// fill Xpath value
	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement continuePaymentBtn;

	// fill Xpath value
	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement continueInfoBtn;
	
	@FindBy(css = "a.product-name")
	public WebElement productName;
	
	@FindBy(css = "input.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBy(css = "h1")
	public WebElement ThankYouLb1;
	
	@FindBy(css = "div.title")
	public WebElement successMessage;
	
	@FindBy(linkText = "Click here for order details.")
	public WebElement orderDetailsLink;
	
	
	public void OpencheckOutPageAsGuest()
	{
		clickOnButton(checkOutGuestBtn);
	}
	 
	public void checkOutAsGuest(
			String firstName , String lastName , String Email , String countryName , String address , String postCode , 
			String phone , String city ,String productName) throws InterruptedException
	{
		setElementTxtBox(fnTxt, firstName);
		setElementTxtBox(lnTxt, lastName);
		setElementTxtBox(emailTxt, Email);
		
		selectOptions = new Select(countryList);
		selectOptions.selectByVisibleText(countryName);
		
		setElementTxtBox(cityTxt, city);
		setElementTxtBox(addressTxt, address);
		setElementTxtBox(postCodeTxt, postCode);
		setElementTxtBox(phoneTxt, phone);
		
		clickOnButton(continueBtn);
		clickOnButton(shippingMethodRDO);
		clickOnButton(continueShippingBtn);
		Thread.sleep(1000);
		clickOnButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickOnButton(continueInfoBtn);
	}
	
	
	public void registeredUserCheckOutProducts(
			String countryName , String address , String postCode , String phone , String city ,String productName) throws InterruptedException
	{
		selectOptions = new Select(countryList);
		selectOptions.selectByVisibleText(countryName);
		
		setElementTxtBox(cityTxt, city);
		setElementTxtBox(addressTxt, address);
		setElementTxtBox(postCodeTxt, postCode);
		setElementTxtBox(phoneTxt, phone);
		
		clickOnButton(continueBtn);
		clickOnButton(shippingMethodRDO);
		clickOnButton(continueShippingBtn);
		Thread.sleep(1000);
		clickOnButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickOnButton(continueInfoBtn);
	}
	
	public void confirmOrder() throws InterruptedException
	{
		Thread.sleep(1000);
		clickOnButton(confirmBtn);
		//Thread.sleep(1000);
	}
	
	public void openOrdersDetailsPage()
	{
		clickOnButton(orderDetailsLink);
	}
}
