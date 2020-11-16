package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class TestChangeCustomerCurrency extends TestBase{

	String productName = "mac";
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	HomePage homeObject;
	
	@Test(priority = 1)
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
	
	@Test(priority = 2)
	public void testUserCanChangeCurrecny()
	{
	  	homeObject = new HomePage(driver);
	  	homeObject.changeCustomerCurrency();
	  	driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	  	Assert.assertTrue(productDetailsObject.productPrice.getText().contains("€"));
	}
	
}
