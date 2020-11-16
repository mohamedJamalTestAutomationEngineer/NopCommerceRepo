package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import tests.TestBase;

public class ChangeCurrencyBDD extends TestBase{
 
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	HomePage homeObject;
	
	@Given("^user search for a product \"([^\"]*)\"$")
	public void user_search_for_a_product(String productName)  {
		
		try {
			searchObject = new SearchPage(driver);
			// is this line required , we can make assert on web element which is public without taking an object
			// but you are wrong , you should take an object before using it
			productDetailsObject = new ProductDetailsPage(driver);
			searchObject.productSearchUsingAutoSuggest(productName);
			Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error occurred " + e.getMessage());
		}
	}

	@When("^user click on currency drop down list and choose currecny$")
	public void user_click_on_currency_drop_down_list_and_choose_currecny()  {
		homeObject = new HomePage(driver);
	  	homeObject.changeCustomerCurrency();
	}

	@Then("^currecny has been changed$")
	public void currecny_has_been_changed()  {
		Assert.assertTrue(productDetailsObject.productPrice.getText().contains("€"));
	}
}
