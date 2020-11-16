package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import tests.TestBase;

public class TestAddProductToShoppingCartBDD extends TestBase{
	
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	ShoppingCartPage cartObject;
	
	String productName = "Apple MacBook Pro 13-inch";

	@Given("^user able to search for a product \"([^\"]*)\"$")
	public void user_able_to_search_for_a_product(String productName)  {
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchObject.productSearchUsingAutoSuggest(productName);
		Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");
	}

	
	
	@When("^user can add product to shopping cart$")
	public void user_can_add_product_to_shopping_cart() throws InterruptedException  {
		productDetailsObject = new ProductDetailsPage(driver);
		cartObject = new ShoppingCartPage(driver);
		productDetailsObject.addProductToShoppingCart();
		
		Assert.assertTrue(cartObject.productColumn.getText().contains(productName));
	}

	@Then("^user can remove product from shopping cart$")
	public void user_can_remove_product_from_shopping_cart() throws InterruptedException  {
		cartObject = new ShoppingCartPage(driver);
		cartObject.removeProductFromCart();
		Assert.assertTrue(cartObject.removeMessage.getText().contains("Your Shopping Cart is empty"));
	}
	
}
