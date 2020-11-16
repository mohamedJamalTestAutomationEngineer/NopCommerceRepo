package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class TestSearchProduct extends TestBase{

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	
	@Test
	public void testProductSearch()
	{
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchObject.productSearch(productName);
		searchObject.openProductDetails();
		Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(), productName);
	}
}
