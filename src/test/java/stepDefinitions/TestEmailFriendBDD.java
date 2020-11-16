package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.RegisterationPage;
import pages.SearchPage;
import tests.TestBase;

public class TestEmailFriendBDD extends TestBase{

	HomePage homeObject;
	RegisterationPage registerObject;
	EmailPage EmailPageOBject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage productDetailsObject;
	
	@Given("^user register with \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_register_with(String firstname, String lastname, String email, String password)  {
		homeObject = new HomePage(driver);
		registerObject = new RegisterationPage(driver);
		homeObject.openRegisterationScreen();		
		registerObject.userRegisteration(firstname, lastname, email, password);
		
		Assert.assertTrue(registerObject.successMesg.getText().
				contains("registration completed"));
	}

	@When("^user also can search for a product \"([^\"]*)\"$")
	public void user_also_can_search_for_a_product(String productName)  {
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

	@When("^user can successfully email friend with data \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_can_successfully_email_friend_with_data(String friendmail, String txtMessage)  {
	    
		productDetailsObject = new ProductDetailsPage(driver);
		EmailPageOBject = new EmailPage(driver);
		productDetailsObject.openEmailFriendScreen();
		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		EmailPageOBject.sendEmailToFriend(friendmail,txtMessage);
		Assert.assertTrue(EmailPageOBject.successOfSendMailMessage.getText().contains("message has been sent"));
	}

	@Then("^user can logout at the end$")
	public void user_can_logout_at_the_end()  {
		loginObject = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		loginObject.registeredUserLogOut();	    
	}
}
