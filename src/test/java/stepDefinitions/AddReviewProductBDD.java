package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.RegisterationPage;
import pages.SearchPage;
import tests.TestBase;

public class AddReviewProductBDD extends TestBase {

	HomePage homeObject;
	RegisterationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	ProductReviewPage reviewPageObject;

	@Given("^user register in website with \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_register_in_website_with(String firstname, String lastname, String email, String password) {
		homeObject = new HomePage(driver);
		registerObject = new RegisterationPage(driver);
		homeObject.openRegisterationScreen();
		registerObject.userRegisteration(firstname, lastname, email, password);
		Assert.assertTrue(registerObject.successMesg.getText().contains("Your registration completed"));
	}

	@When("^user can search for a product \"([^\"]*)\"$")
	public void user_can_search_for_a_product(String productName) {
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

	@Then("^user able to review product and log out \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_able_to_review_product_and_log_out(String reviewTitle, String reviewMessageBox) {
		productDetailsObject = new ProductDetailsPage(driver);
		reviewPageObject = new ProductReviewPage(driver);
		loginObject = new LoginPage(driver);
		homeObject = new HomePage(driver);
		productDetailsObject.openReviewScreen();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		reviewPageObject.addProductReview(reviewTitle, reviewMessageBox);
		Assert.assertTrue(reviewPageObject.reviewSuccessMessage.getText().contains("Product review is successfully added"));
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		loginObject.registeredUserLogOut();	
		Assert.assertTrue(homeObject.loginScreenBtn.getText().contains("Log in"));
	}
}
