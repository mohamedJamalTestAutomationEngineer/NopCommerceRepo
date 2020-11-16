package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterationPage;

public class TestRegisterationPage extends TestBase{

	HomePage homeObject;
	RegisterationPage registerObject;
	LoginPage loginObject;
	
	String firstName = "111";
	String lastName = "222";
	String email = "hei11qpqq7tysaaawr1@gmail.com";
	String password = "12345678";
	
	@Test(priority = 1)
	public void testUserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		registerObject = new RegisterationPage(driver);
		homeObject.openRegisterationScreen();
		
		registerObject.userRegisteration(firstName, lastName, email, password);
		
		Assert.assertTrue(registerObject.successMesg.getText().
				contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void testRegisteredUserCanLogOut()
	{
		loginObject = new LoginPage(driver);
		loginObject.registeredUserLogOut();
	}
	
	@Test(priority = 3)
	public void testUserCanLogin()
	{
		loginObject = new LoginPage(driver);
		homeObject.openLoginScreen();
		loginObject.userLogin(email, password);
		Assert.assertTrue(loginObject.logOutBtn.getText().contains("Log out"));
		
		// these two lines here because we want to close the scenario with log out to start a new scenario
		//loginObject = new LoginPage(driver);
		loginObject.registeredUserLogOut();
	}
}

