package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.RegisterationPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class TestRegisteredUserCheckOutProduct extends TestBase{

	HomePage homeObject;
	RegisterationPage registerObject;
	LoginPage loginObject;
	
	String firstName = "111";
	String lastName = "222";
	String email = "hs611qqrtyui2a1@gmail.com";
	String password = "12345678";
	
	String productName = "mac";
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	ShoppingCartPage cartObject;
	CheckOutPage checkOutPageObject;
	OrderDetailsPage orderDetailsObject;
	
	String countryName = "Egypt";
	String address = "test adsddressqq";
	String postCode = "132332127";
	String phone = "083990832";
	String city = "Cairo";
	
	@Test(priority = 1)
	public void testUserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		registerObject = new RegisterationPage(driver);
		homeObject.openRegisterationScreen();
		
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		registerObject.userRegisteration(firstName, lastName, email, password);
		
		Assert.assertTrue(registerObject.successMesg.getText().
				contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void testUserCanSearchWithAutoSuggest()
	{
		try {
			searchObject = new SearchPage(driver);
			// is this line required , we can make assert on webelement which is public without taking an object
			// but you are wrong , you should take an object before using it
			productDetailsObject = new ProductDetailsPage(driver);
			searchObject.productSearchUsingAutoSuggest(productName);
			Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error occurred " + e.getMessage());
		}
		
	}
	
	@Test(priority = 3)
	public void userCanAddproductsToShoppingCart() throws InterruptedException
	{
		productDetailsObject = new ProductDetailsPage(driver);
		cartObject = new ShoppingCartPage(driver);
		productDetailsObject.addProductToShoppingCart();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		Assert.assertTrue(cartObject.totalLabel.getText().contains("3,600"));
	}
	
	@Test(priority = 4)
	public void userCanCheckOutProduct() throws InterruptedException
	{
		checkOutPageObject = new CheckOutPage(driver);
		orderDetailsObject = new OrderDetailsPage(driver);
		cartObject.openCheckOutPage();
		checkOutPageObject.registeredUserCheckOutProducts(countryName, address, postCode, phone, city, productName);
		Thread.sleep(1000);
		Assert.assertTrue(checkOutPageObject.productName.isDisplayed());
		//Assert.assertTrue(checkOutPageObject.productName.getText().contains(productName));
		Thread.sleep(1000);
		checkOutPageObject.confirmOrder();
		Assert.assertTrue(checkOutPageObject.ThankYouLb1.isDisplayed());
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		checkOutPageObject.openOrdersDetailsPage();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/orderdetails/"));
		
		orderDetailsObject.printOrder();
		orderDetailsObject.downloadPDFInvoice();
	}
	
	@Test(priority = 5)
	public void userCanLogout()
	{
		loginObject = new LoginPage(driver);
		loginObject.registeredUserLogOut();
	}
}
