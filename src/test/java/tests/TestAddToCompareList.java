package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareListPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class TestAddToCompareList extends TestBase{

	String appleProduct = "mac";
	String asusProduct = "asus";
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	CompareListPage compareListObject;
	
	@Test(priority = 1)
	public void testUserCanCompareProducts() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		compareListObject = new CompareListPage(driver);
		
		// search for the first product mac 
		searchObject.productSearchUsingAutoSuggest(appleProduct);
		// assert you are in the right page
		Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");
		// then add it to the compare list
		productDetailsObject.opencompareListPage();
		
		// search for the second product asus
		searchObject.productSearchUsingAutoSuggest(asusProduct);
		// assert you are in the right page
		Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(), "Asus N551JK-XO076H Laptop");
		// then add it to the compare list
		productDetailsObject.opencompareListPage();
		// this is a mandatory line to assure that two products appeared in the compare page
		Thread.sleep(3000);
		
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		
		
		compareListObject.compareBetweenProducts();
		
	}
	
	@Test(priority = 2)
	public void testClearcompareList() throws InterruptedException
	{
	    compareListObject = new CompareListPage(driver);
	    compareListObject.clearCompareList();
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    Assert.assertTrue(compareListObject.clearCompareMessage.getText().contains("no items to compare."));
	    //Thread.sleep(1000);
	}
	

}
