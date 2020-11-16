package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class TestAddProductToWishlist extends TestBase{

	String productName = "mac";
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	WishlistPage wishListObject;
	
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
	public void testOpenAddToWishlistPage()
	{
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.openWishlistPage();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
	}
	
	@Test(priority = 3)
	public void testRemoveProductFromWishListCart()
	{
		wishListObject = new WishlistPage(driver);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		wishListObject.removeProductFromWishlist();
		Assert.assertTrue(wishListObject.emptyWishlistMessg.getText().contains("wishlist is empty!"));
	}
}
