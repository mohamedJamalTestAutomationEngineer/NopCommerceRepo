package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CompareListPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import tests.TestBase;

public class TestCompareProductsBDD extends TestBase {

	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	CompareListPage compareListObject;

	String product1 = "mac";
	String product2 = "asus";
	
	@Given("^user can find first product \"([^\"]*)\" and add it to compare list$")
	public void user_can_find_first_product_and_add_it_to_compare_list(String product1) throws InterruptedException  {
	    
		searchObject = new SearchPage(driver);
		productDetailsObject = new ProductDetailsPage(driver);

		// search for the first product mac
		searchObject.productSearchUsingAutoSuggest(product1);
		// assert you are in the right page
		Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(), "Apple MacBook Pro 13-inch");
        // navigate to the comparison page with the added product
		productDetailsObject.opencompareListPage();
	}
	

	@When("^user can find second product \"([^\"]*)\" and add it to compare list$")
	public void user_can_find_second_product_and_add_it_to_compare_list(String product2)  {
	    
		//searchObject = new SearchPage(driver);
		//productDetailsObject = new ProductDetailsPage(driver);

		// search for the first product asus
		searchObject.productSearchUsingAutoSuggest(product2);
		// assert you are in the right page
		Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(), "Asus N551JK-XO076H Laptop");
		productDetailsObject.opencompareListPage();
	}

	@When("^user can compare between two products$")
	public void user_can_compare_between_two_products()  {
		compareListObject = new CompareListPage(driver);
		//driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		compareListObject.compareBetweenProducts();
	    
	}

	@Then("^user can remove two products from compare list$")
	public void user_can_remove_two_products_from_compare_list()  {
	    
		compareListObject = new CompareListPage(driver);
	    compareListObject.clearCompareList();
	    //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    Assert.assertTrue(compareListObject.clearCompareMessage.getText().contains("no items to compare."));
	}
}
