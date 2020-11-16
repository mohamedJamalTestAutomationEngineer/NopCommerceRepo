package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class TestAddProductToShoppingCart extends TestBase{

	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	ShoppingCartPage cartObject;
	String productName = "Apple MacBook Pro 13-inch";
	String abbreivatedProductName = "mac";
	
	
	@Test(priority = 1)
	public void userCanSearchForProductWithAutoSuggestion()
	{
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchObject.productSearchUsingAutoSuggest(abbreivatedProductName);
		Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(), productName);
	}
	
	@Test(priority = 2)
	public void userCanAddproductsToShoppingCart() 
	{
		productDetailsObject = new ProductDetailsPage(driver);
		cartObject = new ShoppingCartPage(driver);	
		
		productDetailsObject.addProductToShoppingCart();
		Assert.assertTrue(cartObject.productColumn.getText().contains(productName));
	}
	
	@Test(priority = 3)
	public void userCanRemoveProductFromCart()
	{
		cartObject = new ShoppingCartPage(driver);
		cartObject.removeProductFromCart();
		Assert.assertTrue(cartObject.removeMessage.getText().contains("Your Shopping Cart is empty"));
	}
}
