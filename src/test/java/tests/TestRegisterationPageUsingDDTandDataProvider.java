package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterationPage;

public class TestRegisterationPageUsingDDTandDataProvider extends TestBase{

	HomePage homeObject;
	RegisterationPage registerObject;
	LoginPage loginObject;
	
	// note that to make dataprovider work as expected , you should provide only one raw in the regiter data
	// and one for the login data . in case you provide more than one raw , you need to provide the last
	// raw of register data 
	
	@DataProvider(name = "registerData")
	public static Object[][] userRegisterData()
	{
		return new Object[][] {
			{"new3" , "new3" , "new3@gmail.com" , "123456"},
			{"new4" , "new4" , "new4@gmail.com" , "123456"}
		};
	}
	
	@DataProvider(name = "loginData")
	public static Object[][] userLoginData()
	{
		return new Object[][] {
			{"new4@gmail.com" , "123456"}
		};
	}
	
	@Test(priority = 1 , dataProvider = "registerData")
	public void testUserCanRegisterSuccessfully(String firstName , String lastName , String email, String password)
	{
		homeObject = new HomePage(driver);
		registerObject = new RegisterationPage(driver);
		loginObject = new LoginPage(driver);
		homeObject.openRegisterationScreen();
		
		registerObject.userRegisteration(firstName, lastName, email, password);
		
		Assert.assertTrue(registerObject.successMesg.getText().
				contains("Your registration completed"));	
		
		loginObject.registeredUserLogOut();
		
	}
	
	@Test(enabled = false)
	public void testRegisteredUserCanLogOut()
	{
		loginObject = new LoginPage(driver);
		loginObject.registeredUserLogOut();
	}
	
	@Test(priority = 2 , dataProvider = "loginData")
	public void testUserCanLogin(String email , String password)
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

