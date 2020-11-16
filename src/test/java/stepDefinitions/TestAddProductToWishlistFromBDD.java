package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;
import tests.TestBase;

public class TestAddProductToWishlistFromBDD extends TestBase {

	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	WishlistPage wishListObject;
	String productName = "mac";

	@Given("^user is able to search for a product \"([^\"]*)\"$")
	public void user_is_able_to_search_for_a_product(String productName) {

		try {
			searchObject = new SearchPage(driver);
			// is this line required , we can make assert on webelement which is public
			// without taking an object
			// but you are wrong , you should take an object before using it
			productDetailsObject = new ProductDetailsPage(driver);
			searchObject.productSearchUsingAutoSuggest(productName);
			Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error occurred " + e.getMessage());
		}
	}

	@When("^user can add product to wishlist$")
	public void user_can_add_product_to_wishlist() {
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.openWishlistPage();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
	}

	@Then("^user can remove product from wishlist$")
	public void user_can_remove_product_from_wishlist() {
		wishListObject = new WishlistPage(driver);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		wishListObject.removeProductFromWishlist();
		Assert.assertTrue(wishListObject.emptyWishlistMessg.getText().contains("wishlist is empty!"));
	}

}
