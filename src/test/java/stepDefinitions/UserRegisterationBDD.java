package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterationPage;
import tests.TestBase;

public class UserRegisterationBDD extends TestBase{
	
	HomePage homeObject;
	RegisterationPage registerObject;
	LoginPage loginObject;
	
	@Given("^the user in homepage$")
	public void the_user_in_homepage()  {
		homeObject = new HomePage(driver);
		registerObject = new RegisterationPage(driver);
		Assert.assertTrue(homeObject.registerScreenBtn.getText().contains("Register"));
	}

	@When("^I click on the register button$")
	public void i_click_on_the_register_button()  {
		homeObject = new HomePage(driver);
		homeObject.openRegisterationScreen();
	}

//	@When("^I enter the user data$")
//	public void i_enter_the_user_data()  {
//		registerObject = new RegisterationPage(driver);
//		registerObject.userRegisteration(firstName, lastName, email, password);
//	}
	
	@When("^I enter the user \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_enter_the_user(String firstName, String lastName, String email, String password) {
		registerObject = new RegisterationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, password);
	}

	@Then("^registertion completed successfully$")
	public void registertion_completed_successfully()  {
		loginObject = new LoginPage(driver);
		homeObject = new HomePage(driver);
		Assert.assertTrue(registerObject.successMesg.getText().
				contains("Your registration completed"));
		loginObject.registeredUserLogOut();
		Assert.assertTrue(homeObject.loginScreenBtn.getText().contains("Log in"));
	}
}
